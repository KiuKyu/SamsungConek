package com.samsungconek.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "LOGGER")
public class Logger {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "LOG_SQ")
    @SequenceGenerator(name = "LOG_SQ", allocationSize = 1)
    @Column(name = "ID")
    private Long id;

    @NotNull
    @Column(name = "DETAILS", columnDefinition = "NVARCHAR2(500)", nullable = false)
    private String details;

    @ManyToMany
    @JoinTable(name = "USER_LOGGED")
    private List<User> users;

    @NotNull
    @Column(name = "LOG_TIME")
    private long logTime;
}