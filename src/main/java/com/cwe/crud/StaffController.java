package com.cwe.crud;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.ui.Model;

@Controller
public class StaffController {

    List<Staff> allStaff = new ArrayList<>();

    @GetMapping("/")
    public String addNewStaff(Model model) {
        model.addAttribute("addNewStaff", new Staff());
        return "addNewStaff";
    }

    @PostMapping("/addSubmitForm")
    public String addSubmitForm(Staff staff) {
        allStaff.add(staff);
        return "redirect:/getAllStaff";
    }

    @GetMapping("/getAllStaff")
    public String getAllStaff(Model model) {
        model.addAttribute("allStaff", allStaff);
        return "getAllStaff";
    }
}
