package me.lukegs7.springsecurity.securitydemo.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

interface UserDetailService {
    UserDetails loadUserByUsername(String username) throws UsernameNotFoundException;
}
