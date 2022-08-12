package com.samsungconek.model.entity;

import com.samsungconek.constant.UserRole;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "ROLES")
public class Role {
//    public static final String ROLE_ADMIN = "ROLE_ADMIN";
//    public static final String ROLE_SUPPORT = "ROLE_SUPPORT";
//    public static final String ROLE_CUSTOMER = "ROLE_CUSTOMER";

    @Id
    @Column(name = "ID", columnDefinition = "NUMBER(2)")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ROLE_SQ")
    @SequenceGenerator(name = "ROLE_SQ", allocationSize = 1)
    private Long id;

    @NotNull
    @Column(columnDefinition = "NVARCHAR2(20)", name = "NAME", nullable = false)
    private String name;

    @NotNull
    @Column(name = "IS_ADMIN", nullable = false)
    private boolean isAdmin = false;

    @NotNull
    @Column(name = "IS_ACTIVE", nullable = false)
    private boolean isActive = true;

    @NotNull
    @Column(name = "CREATE_DATE", nullable = false, columnDefinition = "NUMBER(19)")
    private long createDate;

    @NotNull
    @Column(name = "MODIFY_DATE", nullable = false, columnDefinition = "NUMBER(19) default 0")
    private long modifyDate = 0L;

    @NotNull
    @Column(name = "CREATE_USER", columnDefinition = "NUMBER(19)", nullable = false)
    private long createUser;

    @NotNull
    @Column(name = "MODIFY_USER", columnDefinition = "NUMBER(19) default 0", nullable = false)
    private long modifyUser = 0L;

    public Role (UserRole roleName, boolean isActive, boolean isAdmin) {
        this.name = roleName.name();
        this.isActive = isActive;
        this.isAdmin = isAdmin;
    }
}