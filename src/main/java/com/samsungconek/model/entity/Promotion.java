package com.samsungconek.model.entity;


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
@Table(name = "PROMOTION")
public class Promotion {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PROMO_SQ")
    @SequenceGenerator(name = "PROMO_SQ", allocationSize = 1)
    @Column(name = "ID")
    private Long id;

    @NotNull
    @Column(name = "NAME", columnDefinition = "NVARCHAR2(100)", nullable = false)
    private String name;

    @NotNull
    @Column(name = "CONTENT", nullable = false, columnDefinition = "NVARCHAR2(1000)")
    private String content;

    @NotNull
    @Column(name = "PROMO_IMAGE", nullable = false, columnDefinition = "NVARCHAR2(150)")
    private String image;

    @OneToMany
    @JoinColumn(name = "PROMOTION_ID")
    private List<Product> products;
}
