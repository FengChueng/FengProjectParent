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
@Table(name = "sys_role")
@DynamicUpdate
@DynamicInsert
public class SysRole implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 角色编码
     */
    @Column(name = "role_code")
    private String roleCode;

    /**
     * 角色名称
     */
    @Column(name = "role_name")
    private String roleName;

    @ManyToMany(cascade = CascadeType.ALL,targetEntity = SysUser.class,mappedBy = "sysRoles")
    private Set<SysUser> sysUsers;

    /**
     * 角色拥有的权限
     */
    @ManyToMany(cascade = CascadeType.ALL,targetEntity = SysPermission.class)
    @JoinTable(name = "sys_role_pms",joinColumns = {@JoinColumn(name = "rid")},inverseJoinColumns = {@JoinColumn(name = "pid")})
    private Set<SysPermission> sysPermissions;

    public SysRole() {
    }

    public SysRole(String roleCode, String roleName) {
        this.roleCode = roleCode;
        this.roleName = roleName;
    }
}