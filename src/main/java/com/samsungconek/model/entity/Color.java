package com.samsungconek.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "COLOR")
public class Color {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "COLOR_SQ")
    @SequenceGenerator(name = "COLOR_SQ", allocationSize = 1)
    @Column(columnDefinition = "NUMBER(2)", name = "ID")
    private Long id;

    @NotNull
    @Column(name = "NAME", columnDefinition = "NVARCHAR2(20)", nullable = false, unique = true)
    private String name;
}