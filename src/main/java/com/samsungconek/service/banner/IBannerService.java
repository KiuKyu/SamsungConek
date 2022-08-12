package com.samsungconek.service.banner;

import com.samsungconek.model.dto.BannerDto;
import com.samsungconek.model.dto.ListDto;
import com.samsungconek.model.entity.Banner;
import com.samsungconek.utils.CustomResponse;

public interface IBannerService {
    Banner create(BannerDto bannerDto);

    Banner update(Long id, BannerDto bannerDto);

    Banner getOne(Long id);

    ListDto<BannerDto> getList();

    CustomResponse delete(Long id);
}
