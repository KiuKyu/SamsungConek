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
@Table(name = "CARTS")
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CART_SQ")
    @SequenceGenerator(name = "CART_SQ", allocationSize = 1)
    @Column(name = "ID")
    private Long id;

    @OneToOne
    @JoinColumn(name = "USER_ID")
    private User user;

    @ManyToMany
    @JoinTable(name = "CART_DETAILS")
    private List<Product> products;

    @NotNull
    @Column(name = "TOTAL_PRICE", nullable = false)
    private double totalPrice = 0;

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
