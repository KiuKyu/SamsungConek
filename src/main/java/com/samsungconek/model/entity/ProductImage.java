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
@Table(name = "PRODUCT_IMAGES")
public class ProductImage {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PRD_IMG_SQ")
    @SequenceGenerator(name = "PRD_IMG_SQ", allocationSize = 1)
    @Column(name = "ID")
    private Long id;

    @NotNull
    @Column(name = "IMAGE", columnDefinition = "NVARCHAR2(150)", nullable = false)
    private String image;

    @JoinColumn(name = "PRODUCT_ID")
    @ManyToOne
    private Product product;

    @NotNull
    @Column(name = "STATUS", nullable = false)
    private boolean status = true;

//    Vị trí hiển thị ảnh trong trang
//        1 => hiển thị làm ảnh bìa (khi chưa click vào sản phẩm)
//        2 => hiển thị ở mục xem ảnh sản phẩm (khi click vào sản phẩm)
//        3 => hiển thị ở mục xem chi tiết thông tin sản phẩm (khi đã click vào sản phẩm)

    @NotNull
    @Column(columnDefinition = "NUMBER(1) default 3", name = "IMAGE_POSITION", nullable = false)
    private int imagePosition = 3;

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
