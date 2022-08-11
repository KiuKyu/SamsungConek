package com.samsungconek.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BannerDto {
    private Long id;

    private String name;

    private MultipartFile image;

    private boolean status;

    private long endDate;

    private int priority;
}
