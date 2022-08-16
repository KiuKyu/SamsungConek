package com.samsungconek.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "SHIPPING")
public class Shipping {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SHIP_SQ")
    @SequenceGenerator(name = "SHIP_SQ", allocationSize = 1)
    private Long id;

    @OneToMany
    @JoinColumn(name = "ORDER_ID")
    private List<Order> orderList;

    @OneToMany
    @JoinColumn(name = "USER_ID")
    private List<User> user;
}
