package com.feng.service;

import com.feng.domain.SysUser;

/**
 * Created by Administrator on 2018/12/3.
 */
public interface IUserService {
    SysUser getUserByPrimaryKey(Long pkId);
}
