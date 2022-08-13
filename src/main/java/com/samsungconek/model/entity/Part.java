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
@Table(name = "PARTS")
public class Part {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PART_SQ")
    @SequenceGenerator(name = "PART_SQ", allocationSize = 1)
    private Long id;

    @NotNull
    @Column(name = "NAME", columnDefinition = "NVARCHAR2(100)", nullable = false)
    private String name;

    @ManyToOne
    @JoinColumn(name = "LAYOUT_ID")
    private Layout layout;
}
