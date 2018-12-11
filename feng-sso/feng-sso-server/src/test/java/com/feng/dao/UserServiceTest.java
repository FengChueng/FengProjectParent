package com.feng.dao;

import com.feng.BaseTest;
import com.feng.domain.SysUser;
import com.feng.service.IUserService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Administrator on 2018/12/6.
 */
public class UserServiceTest extends BaseTest{

    @Autowired
    private IUserService userService;

    @Test
    public void testGetUser(){
        SysUser sysUser = userService.getUserByPrimaryKey(1L);
    }

}
