package com.samsungconek.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "COMMENT_IMAGE")
public class CommentImage {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CMT_IMAGE_SQ")
    @SequenceGenerator(name = "CMT_IMAGE_SQ", allocationSize = 1)
    @Column(name = "ID")
    private Long id;

    @NotNull
    @Column(name = "NAME", columnDefinition = "NVARCHAR2(150)", nullable = false)
    private String image;

    @ManyToOne
    @JoinColumn(name = "COMMENT_ID")
    private Comment comment;

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
