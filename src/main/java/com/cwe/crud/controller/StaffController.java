package com.cwe.crud.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cwe.crud.Constants;
import com.cwe.crud.Staff;
import com.cwe.crud.repository.StaffRepo;
import com.cwe.crud.service.StaffService;

import jakarta.validation.Valid;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

@Controller
public class StaffController {

    StaffService staffService = new StaffService();

    @GetMapping("/")
    public String addNewStaff(Model model, @RequestParam(required = false) String id) {
        Staff staff = new Staff();
        int index = getStaffIndex(id);

        model.addAttribute("addNewStaff", index == Constants.NO_MATCH ? staff : staffRepo.getStaffByIndex(index));
        return "addNewStaff";
    }

    public int getStaffIndex(String id) {
        for (int i = 0; i < staffRepo.getAllstaff().size(); i++) {
            if (staffRepo.getStaffByIndex(i).getId().equals(id)) {
                return i;
            }
        }
        return Constants.NO_MATCH;
    }

    @PostMapping("/addSubmitForm")
    public String addSubmitForm(@Valid @ModelAttribute("addNewStaff") Staff staff, BindingResult result) {

        if (result.hasErrors()) {
            return "addNewStaff";
        }
        int index = getStaffIndex(staff.getId());

        if (index == Constants.NO_MATCH) {
            staffRepo.addStaff(staff);
        } else {
            staffRepo.updateStaffByIndex(index, staff);
        }

        return "redirect:/getAllStaff";
    }

    @GetMapping("/getAllStaff")
    public String getAllStaff(Model model) {
        model.addAttribute("allStaff", staffRepo.getAllstaff());
        return "getAllStaff";
    }

}
