package com.bi.usermgmt.controller;

import com.bi.usermgmt.entity.Account;
import com.bi.usermgmt.entity.AccountRole;
import com.bi.usermgmt.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/account")
public class AccountController {
    @Autowired
    AccountRepository accountRepository;

    @PostMapping("/create")
    public String create(Account account) {
        AccountRole role = new AccountRole();
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        account.setPwd(encoder.encode(account.getPwd()));
        role.setRoleName("BASIC");
//        account.setRoles(Arrays.asList(role));
        accountRepository.save(account);

        return "redirect:/";
    }

    @GetMapping("/login")
    public String loginForm(HttpServletRequest req) {
        String referer = req.getHeader("Referer");
        req.getSession().setAttribute("prevPage", referer);
        return "account/login";
    }

    @GetMapping("/signUp")
    public String signForm() {
        return "account/signUp";
    }
    @GetMapping("/fail")
    public String failPage() {
        return "fail";
    }
    @GetMapping("/success")
    public String successPage() {
        return "success";
    }
}
