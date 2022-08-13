package com.samsungconek.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "LAYOUTS")
public class Layout {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "LAYOUT_SQ")
    @SequenceGenerator(name = "LAYOUT_SQ", allocationSize = 1)
    private Long id;

    @NotNull
    @Column(name = "NAME", columnDefinition = "NVARCHAR2(100)", nullable = false)
    private String name;

    @NotNull
    @Column(name = "STATUS")
    private boolean status;
}
