package com.samsungconek.service.banner;

import com.samsungconek.model.dto.BannerDto;
import com.samsungconek.model.dto.ListDto;
import com.samsungconek.model.entity.Banner;
import com.samsungconek.service.IGeneralService;
import com.samsungconek.utils.CustomResponse;

import java.util.List;

public interface IBannerService extends IGeneralService<Banner> {
    Banner save(BannerDto bannerDto);

    Banner update(Long id, BannerDto bannerDto);

//    ListDto<BannerDto> getList();

    CustomResponse delete(Long id);
}
