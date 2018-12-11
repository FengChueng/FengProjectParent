package com.feng.config.security.common;

import com.feng.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Administrator on 2018/12/3.
 */
public class UserDetailServiceImpl implements UserDetailsService {

    @Autowired
    private IUserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //查询数据库
        List<SimpleGrantedAuthority> simpleGrantedAuthorities = Arrays.asList(new SimpleGrantedAuthority("USER"),
                new SimpleGrantedAuthority("ADMIN"));
//        userService
        return null;
    }
}
