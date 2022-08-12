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
@Table(name = "footer")
public class Footer {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "FOOTER_SQ")
    @SequenceGenerator(name = "FOOTER_SQ", allocationSize = 1)
    private Long id;

    @NotNull
    @Column(name = "NAME", columnDefinition = "NVARCHAR2(20)")
    private String name;

    @NotNull
    @Column(name = "VALUE", columnDefinition = "NVARCHAR2(200)")
    private String value;
}
