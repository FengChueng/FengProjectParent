package com.feng.dao;

import com.feng.domain.SysUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Administrator on 2018/12/3.
 */
@Repository
public interface UserDAO extends JpaRepository<SysUser,Long>{
}
