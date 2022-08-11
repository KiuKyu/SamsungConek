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
@Table(name = "ORDERS")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ORDER_SQ")
    @SequenceGenerator(name = "ORDER_SQ", allocationSize = 1)
    @Column(name = "ID")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "USER_ID", nullable = false)
    private User user;

    @OneToMany
    @Column(name = "ORDER_ID")
    private List<OrderDetail> orderDetails;

    @NotNull
    @Column(name = "SHIPPING_ADDRESS", nullable = false, columnDefinition = "NVARCHAR2(200)")
    private String shippingAddress;

    @NotNull
    @Column(name = "PAYMENT_METHOD", nullable = false, columnDefinition = "NVARCHAR2(30)")
    private String paymentMethod;

    @NotNull
    @Column(name = "PAYMENT_DATE", nullable = false)
    private long paymentDate;

    @NotNull
    @Column(name = "TOTAL_PRICE", nullable = false)
    private double totalPrice;

    @NotNull
    @Column(name = "STATUS", nullable = false)
    private boolean status = false;

//    @NotNull
//    @Column(name = "CREATE_DATE", columnDefinition = "NUMBER(19)", nullable = false)
//    private long createDate;
//
//    @NotNull
//    @Column(name = "MODIFY_DATE", nullable = false, columnDefinition = "NUMBER(19) default 0")
//    private long modifyDate = 0L;
}
