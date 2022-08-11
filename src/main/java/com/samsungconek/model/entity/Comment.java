package com.samsungconek.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "PRODUCT_COMMENTS")
public class Comment {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "COMM_SQ")
    @SequenceGenerator(name = "COMM_SQ", allocationSize = 1)
    private Long id;

    @Column(name = "CONTENT", columnDefinition = "NVARCHAR2(500)")
    private String comment;

    @ManyToOne
    @JoinColumn(name = "USER_ID")
    private User user;

    @NotNull
    @Column(name = "STATUS", nullable = false)
    private boolean status = false;

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
