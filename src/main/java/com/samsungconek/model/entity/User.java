package com.samsungconek.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.samsungconek.constant.ActiveStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "USERS")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "USER_SQ")
    @SequenceGenerator(name = "USER_SQ", allocationSize = 1)
    private Long id;

    @NotNull
    @Column(name = "FULL_NAME", columnDefinition = "NVARCHAR2(40)")
    private String fullName;

    @NotNull
    @Column(name = "USERNAME", columnDefinition = "VARCHAR2(32)", nullable = false)
    private String username;

    @NotNull
    @JsonIgnore
    @Column(name = "PASSWORD", columnDefinition = "VARCHAR2(60)", nullable = false)
//    60 for bcrypt pw
    private String password;

    @Column(name = "STATUS")
    @Enumerated(EnumType.ORDINAL)
    private ActiveStatus status;

    @Column(name = "AVATAR")
    private String avatar;

    @NotNull
    @Column(name = "EMAIL", columnDefinition = "VARCHAR2(40)")
    private String email;

    @NotNull
    @Column(name = "PHONE", columnDefinition = "VARCHAR2(20)")
    private String phone;

    @Column(name = "COMPANY")
    private String company;

    @NotNull
    @Column(name = "ADDRESS1", nullable = false)
    private String address1;

    @Column(name = "ADDRESS2")
    private String address2;

    @ManyToOne
    @JoinColumn(name = "ROLE_ID")
    private Role role;
}
