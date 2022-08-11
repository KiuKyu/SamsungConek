package com.samsungconek.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "PRODUCTS")
public class Product {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PRODUCT_SQ")
    @SequenceGenerator(name = "PRODUCT_SQ", allocationSize = 1)
    private Long id;

    @NotNull
    @Column(name = "NAME", columnDefinition = "NVARCHAR2(100)", nullable = false)
    private String name;

    @NotNull
    @Column(name = "DISCOUNT", nullable = false)
    private double discount = 0;

    @NotNull
    @Column(name = "STOCK", nullable = false, columnDefinition = "NUMBER(19) default 0")
    private long stock = 0;

    @NotNull
    @Column(name = "PRICE", nullable = false)
    private double price;

    @ManyToMany
    @JoinTable(name = "PRODUCT_CATEGORY")
    private List<Category> categories;

    @NotNull
    @Column(name = "VIEW_COUNT", columnDefinition = "NUMBER(19) default 0", nullable = false)
    private long view = 0;

    @NotNull
    @Column(name = "SOLD_COUNT", columnDefinition = "NUMBER(19) default 0", nullable = false)
    private long sold = 0;

    @NotNull
    @Column(name = "STATUS", nullable = false)
    private boolean status = true;

    @NotNull
    @Column(name = "PRIORITY", columnDefinition = "NUMBER(2) default 0", nullable = false)
    private int priority = 0;

    @NotNull
    @Column(name = "CONTENT", columnDefinition = "NVARCHAR2(1000)", nullable = false)
    private String content;

    @NotNull
    @Column(name = "DESCRIPTION", columnDefinition = "NVARCHAR2(500)", nullable = false)
    private String description;

    @OneToOne
    @JoinColumn(name = "COLOR_ID", columnDefinition = "NUMBER(2)")
    private Color color;

    @OneToMany(mappedBy = "product")
    private List<ProductImage> productImages;

//    @NotNull
//    @JsonIgnore
//    @Column(name = "CREATE_DATE", nullable = false, columnDefinition = "NUMBER(19)")
//    private long createDate;
//
//    @NotNull
//    @JsonIgnore
//    @Column(name = "MODIFY_DATE", nullable = false, columnDefinition = "NUMBER(19) default 0")
//    private long modifyDate = 0L;
//
//    @NotNull
//    @JsonIgnore
//    @Column(name = "CREATE_USER", columnDefinition = "NUMBER(19)", nullable = false)
//    private long createUser;
//
//    @NotNull
//    @JsonIgnore
//    @Column(name = "MODIFY_USER", columnDefinition = "NUMBER(19) default 0", nullable = false)
//    private long modifyUser = 0L;
}