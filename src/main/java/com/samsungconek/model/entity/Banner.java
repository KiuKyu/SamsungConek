package com.samsungconek.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "BANNERS")
public class Banner {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "BANNER_SQ")
    @SequenceGenerator(name = "BANNER_SQ", allocationSize = 1)
    @Column(name = "ID")
    private Long id;

    @NotNull
    @Column(name = "NAME", columnDefinition = "NVARCHAR2(50)", nullable = false)
    private String name;

    @NotNull
    @Column(name = "IMAGE", nullable = false, columnDefinition = "NVARCHAR2(200)")
    private String image;

    @NotNull
    @Column(name = "STATUS", nullable = false, columnDefinition = "NUMBER(1,0) default 0")
    private boolean status = false;

    @NotNull
    @Column(name = "END_DATE", nullable = false)
    private long endDate;

    @NotNull
    @Column(name = "PRIORITY", nullable = false, columnDefinition = "NUMBER(2) default 0")
    private int priority = 0;

//    @NotNull
//    @Column(name = "CREATE_DATE", nullable = false, columnDefinition = "NUMBER(19)")
//    private long createDate;
//
//    @NotNull
//    @Column(name = "MODIFY_DATE", nullable = false, columnDefinition = "NUMBER(19) default 0")
//    private long modifyDate = 0L;
//
//    @NotNull
//    @Column(name = "CREATE_USER", columnDefinition = "NUMBER(19)", nullable = false)
//    private long createUser;
//
//    @NotNull
//    @Column(name = "MODIFY_USER", columnDefinition = "NUMBER(19) default 0", nullable = false)
//    private long modifyUser = 0L;
}
