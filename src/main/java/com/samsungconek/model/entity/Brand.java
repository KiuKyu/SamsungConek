package com.samsungconek.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "BRANDS")
public class Brand {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "BRAND_SQ")
    @SequenceGenerator(name = "BRAND_SQ", allocationSize = 1)
    @Column(name = "ID", columnDefinition = "NUMBER(2)")
    private Long id;

    @NotNull
    @Column(columnDefinition = "NVARCHAR2(20)", name = "NAME", nullable = false)
    private String name;

    @Column(columnDefinition = "NVARCHAR2(1000)", name = "DESCRIPTION")
    private String description;

    @Column(columnDefinition = "NVARCHAR2(200) default 'logo.png'", name = "IMAGE")
    private String image;

//    @NotNull
//    @Column(name = "CREATE_DATE", nullable = false, columnDefinition = "NUMBER(19)")
//    private long createDate;
//
//    @NotNull
//    @Column(name = "MODIFY_DATE", nullable = false, columnDefinition = "NUMBER(19) default 0")
//    private long modifyDate = 0L;
//
//    @NotNull
//    @Column(name = "CREATE_USER", nullable = false)
//    private long createUser;
//
//    @NotNull
//    @Column(name = "MODIFY_USER", columnDefinition = "NUMBER(19) default 0", nullable = false)
//    private long modifyUser = 0L;
}
