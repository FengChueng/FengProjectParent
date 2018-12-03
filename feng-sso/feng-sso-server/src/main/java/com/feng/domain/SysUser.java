package com.feng.domain;

import lombok.Data;
import lombok.ToString;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Data
@ToString
@Entity
@Table(name = "sys_user")
@DynamicUpdate
@DynamicInsert
public class SysUser implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 用户编号
     */
    @Column(length = 32,name = "user_code")
    private String usercode;

    /**
     * 用户名
     */
    @Column(length = 32,name = "user_name")
    private String username;

    /**
     * 密码
     */
    @Column(length = 64)
    private String password;

    /**
     * 盐
     */
    private String salt;

    /**
     * 用户角色
     */
//    @OneToMany(cascade = CascadeType.ALL,targetEntity = SysRole.class)
//    @JoinColumn(name = "sid")

    @ManyToMany(cascade = CascadeType.ALL,targetEntity = SysRole.class)
    @JoinTable(name = "sys_user_role",joinColumns = {@JoinColumn(name = "uid")},inverseJoinColumns = {@JoinColumn(name = "rid")})
    private Set<SysRole> sysRoles;

    public SysUser(String username, String password) {
        this.username = username;
        this.password = password;
    }
}