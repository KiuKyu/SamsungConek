package com.samsungconek.model.dto.base;

import lombok.Data;

@Data
public class PageNumberRequestDto {
    private Integer pageSize;
    private Integer pageNumber;
}
