package com.cwe.crud.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.cwe.crud.Staff;

@Repository
public class StaffRepo {
    private List<Staff> allstaff = new ArrayList<>();

    public Staff getStaffByIndex(int index) {
        return allstaff.get(index);
    }

    public void addStaff(Staff staff) {
        allstaff.add(staff);
    }

    public void updateStaffByIndex(int index, Staff staff) {
        allstaff.set(index, staff);
    }

    public List<Staff> getAllstaff() {
        return allstaff;
    }
}