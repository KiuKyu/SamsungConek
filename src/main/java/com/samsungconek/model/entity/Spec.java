package com.samsungconek.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "SPECS")
public class Spec {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SPEC_SQ")
    @SequenceGenerator(name = "SPEC_SQ", allocationSize = 1)
    @Column(name = "ID")
    private Long id;

    @NotNull
    @Column(name = "NAME", columnDefinition = "NVARCHAR2(20)", nullable = false)
    private String name;

//    Status = thông số đó có trên sản phẩm đó không . True = có . False = không
    @NotNull
    @Column(name = "STATUS", nullable = false, columnDefinition = "NUMBER(1) default 0")
    private boolean status = false;
}
