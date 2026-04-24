package com.cwe.crud;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;

@Controller
public class StaffController {

    List<Staff> allStaff = new ArrayList<>();

    @GetMapping("/")
    public String addNewStaff(Model model, @RequestParam(required = false) String id) {
        Staff staff = new Staff();
        int index = getStaffIndex(id);

        model.addAttribute("addNewStaff", index == -1 ? staff : allStaff.get(index));
        return "addNewStaff";
    }

    public int getStaffIndex(String id) {
        for (int i = 0; i < allStaff.size(); i++) {
            if (allStaff.get(i).getId().equals(id)) {
                return i;
            }
        }
        return -1;
    }

    @PostMapping("/addSubmitForm")
    public String addSubmitForm(Staff staff) {
        int index = getStaffIndex(staff.getId());

        if (index == -1) {
            allStaff.add(staff);
        } else {
            allStaff.set(index, staff);
        }

        return "redirect:/getAllStaff";
    }

    @GetMapping("/getAllStaff")
    public String getAllStaff(Model model) {
        model.addAttribute("allStaff", allStaff);
        return "getAllStaff";
    }
}
