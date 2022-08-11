package com.samsungconek.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BrandDto {
    private Long id;

    private String name;

    private String description;

    private MultipartFile image;
}
