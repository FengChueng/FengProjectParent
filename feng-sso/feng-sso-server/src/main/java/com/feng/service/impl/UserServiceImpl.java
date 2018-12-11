package com.feng.service.impl;

import com.feng.dao.UserDAO;
import com.feng.domain.SysUser;
import com.feng.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Created by Administrator on 2018/12/3.
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class UserServiceImpl implements IUserService {
    @Autowired
    private UserDAO userDAO;

    @Override
    //方法的@Transactional会覆盖类上面声明的事务
    @Transactional(readOnly = true,rollbackFor = Exception.class)
    public SysUser getUserByPrimaryKey(Long pkId) {
        Optional<SysUser> user = userDAO.findById(pkId);
        return user.isPresent()?user.get():null;
    }
}
