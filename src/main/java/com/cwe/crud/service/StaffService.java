package com.cwe.crud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cwe.crud.Staff;
import com.cwe.crud.repository.StaffRepo;
import com.cwe.crud.Constants;

@Service
public class StaffService {
    @Autowired
    StaffRepo staffRepo;

    public Staff getStaffByIndex(int index) {
        return staffRepo.getStaffByIndex(index);
    }

    public void addStaff(Staff staff) {
        staffRepo.addStaff(staff);
    }

    public void updateStaffByIndex(int index, Staff staff) {
        staffRepo.updateStaffByIndex(index, staff);
    }

    public List<Staff> getAllstaff() {
        return staffRepo.getAllstaff();
    }

    public int getStaffIndex(String id) {
        for (int i = 0; i < getAllstaff().size(); i++) {
            if (getStaffByIndex(i).getId().equals(id)) {
                return i;
            }
        }
        return Constants.NO_MATCH;
    }

    public Staff getStaffById(String id) {
        int index = getStaffIndex(id);
        return index == Constants.NO_MATCH ? new Staff() : getStaffByIndex(index);
    }

    public void submitStaff(Staff staff) {
        int index = getStaffIndex(staff.getId());
        if (index == Constants.NO_MATCH) {
            addStaff(staff);
        } else {
            updateStaffByIndex(index, staff);
        }
    }

}