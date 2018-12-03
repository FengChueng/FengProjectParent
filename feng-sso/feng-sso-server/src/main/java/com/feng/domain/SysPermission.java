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
@Table(name = "sys_permission")
@DynamicUpdate
@DynamicInsert
public class SysPermission implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 权限名称
     */
    private String name;

    /**
     * 权限字符串
     */
    private String code;

    /**
     * 资源类型
     */
    private Integer type;

    /**
     * URL
     */
    private String url;

    /**
     * 排序
     */
    private Integer sort;

    /**
     * 父菜单ID
     */
//    @Column(name = "pid")
//    @PrimaryKeyJoinColumn(referencedColumnName = "id")
//    private Long pid;

    @ManyToOne(targetEntity = SysPermission.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "pid")
    private SysPermission parentSysPms;

    @OneToMany(targetEntity = SysPermission.class, mappedBy = "parentSysPms")
    private Set<SysPermission> childrenSysPms;

    @ManyToMany(cascade = CascadeType.ALL, targetEntity = SysRole.class, mappedBy = "sysPermissions")
    private Set<SysRole> sysRoles;

}