package com.samsungconek.model.dto;

import java.util.List;

public class BannerDtoList {

    private List<BannerDto> list;

    public BannerDtoList() {
    }

    public BannerDtoList(List<BannerDto> list) {
        this.list = list;
    }

    public List<BannerDto> getList() {
        return list;
    }

    public void setList(List<BannerDto> list) {
        this.list = list;
    }
}
