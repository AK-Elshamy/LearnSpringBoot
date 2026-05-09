package com.codeWithElshamy.voucherApp.voucherApp.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;

import com.codeWithElshamy.voucherApp.voucherApp.Repo.UserRepo;
import com.codeWithElshamy.voucherApp.voucherApp.model.User;

@Service
public class UserDetailsServiceVouch implements UserDetailsService {

    @Autowired
    private UserRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = userRepo.findByEmail(username);

        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }

        return org.springframework.security.core.userdetails.User.builder()
                .username(user.getEmail())
                .password(user.getPassword())

                // ✅ الحل هنا 👇 (مهم جدًا)
                .roles(
                        user.getRoles().stream()
                                .map(role -> role.getName().replace("ROLE_", "")) // يشيل ROLE_
                                .toArray(String[]::new))

                .build();
    }
}