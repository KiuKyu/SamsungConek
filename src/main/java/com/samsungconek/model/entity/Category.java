package com.samsungconek.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "CATEGORIES")
public class Category {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CATE_SQ")
    @SequenceGenerator(name = "CATE_SQ", allocationSize = 1)
    private Long id;

    @Column(columnDefinition = "NVARCHAR2(40)", nullable = false, name = "NAME")
    @NotNull
    private String name;

    @ManyToMany
    @JoinTable(name = "CATE_BRAND")
    private List<Brand> brands;

    @NotNull
    @Column(name = "VIEW_COUNT", columnDefinition = "NUMBER(19) default 0")
    private long viewCount = 0;

    @NotNull
    @Column(name = "ORDER_COUNT", columnDefinition = "NUMBER(19) default 0")
    private long orderCount = 0;

    @NotNull
    @Column(name = "STATUS", nullable = false)
    private boolean status = true;

    @ManyToOne
    @JoinColumn(name = "PARENT_CATE_ID")
    private Category parentCategory;

    @ManyToMany
    @JoinTable(name = "CATE_SPEC")
    private List<Spec> specs;
}
