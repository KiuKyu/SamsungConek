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
@Table(name = "PHASE")
public class Phase {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PHASE_SQ")
    @SequenceGenerator(name = "PHASE_SQ", allocationSize = 1)
    private Long id;

    @NotNull
    @Column(name = "NAME", columnDefinition = "NVARCHAR2(200)", nullable = false)
    private String name;
}
