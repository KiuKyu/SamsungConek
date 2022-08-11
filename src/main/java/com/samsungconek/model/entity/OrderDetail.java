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
@Table(name = "ORDER_DETAILS")
public class OrderDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ORDER_DETAIL_SQ")
    @SequenceGenerator(name = "ORDER_DETAIL_SQ", allocationSize = 1)
    private Long id;

    @OneToOne
    @JoinColumn(name = "PRODUCT_ID")
    private Product product;

    @NotNull
    @Column(name = "QUANTITY", nullable = false)
    private long productQuantity;

    @NotNull
    @Column(name = "PRICE", nullable = false)
    private long productPrice;

    @NotNull
    @Column(name = "DISCOUNT", nullable = false)
    private long productDiscount;
}
