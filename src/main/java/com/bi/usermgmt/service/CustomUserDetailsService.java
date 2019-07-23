package com.bi.usermgmt.service;

import com.bi.usermgmt.entity.Account;
import com.bi.usermgmt.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

@Service("customUserDetailsService")
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    AccountRepository accountRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Account account = accountRepository.findUserByUid(username);
        return (UserDetails) Optional.ofNullable(account)
                .filter(m -> m!=null)
                .map(m -> new User(username, m.getPwd(), authorities(account))).get();
    }

    private static Collection authorities(Account account) {
        Collection authorities = new ArrayList();
        if (account.getUserName().equals("ADMIN")) {
            authorities.add(new SimpleGrantedAuthority("ADMIN"));
        } else {
            authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
        }
        return authorities;
    }
}
