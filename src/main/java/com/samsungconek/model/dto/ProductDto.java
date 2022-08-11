package com.samsungconek.model.dto;

import com.samsungconek.model.entity.Category;
import com.samsungconek.model.entity.Color;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDto {
    private Long id;

    private String name;

    private List<Category> categories;

    private double price;

    private long stock;

    private double discount;

    private List<MultipartFile> productImages;

    private Color color;

    private int priority;

    private boolean status;

    private String content;
}
