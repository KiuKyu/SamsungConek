package com.samsungconek.service.banner;

import com.samsungconek.model.dto.BannerDto;
import com.samsungconek.model.dto.ListDto;
import com.samsungconek.model.entity.Banner;
import com.samsungconek.repository.IBannerRepository;
import com.samsungconek.utils.CustomResponse;
import com.samsungconek.utils.exception.BusinessAssert;
import com.samsungconek.utils.exception.BusinessExceptionCode;
import com.samsungconek.utils.exception.CustomException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Optional;

@Service
public class BannerService implements IBannerService {
    @Autowired
    private IBannerRepository bannerRepository;

    @Value("${file-upload}")
    private String uploadPath;

    public Iterable<Banner> findAll() {
        return bannerRepository.findAll();
    }

    public Object saveNew(BannerDto bannerDto) {
        MultipartFile img = bannerDto.getImage();
        try {
            if (img != null && img.getSize() != 0) {
                String fileName = img.getOriginalFilename();
                long currentTime = System.currentTimeMillis();
//            Logger logger = new Logger();
//            logger.setLogTime(currentTime);
                fileName = currentTime + "_" + fileName;
                FileCopyUtils.copy(img.getBytes(), new File(uploadPath + fileName));
                Banner banner = new Banner();
                banner.setName(bannerDto.getName());
                banner.setImage(fileName);
                banner.setStatus(bannerDto.isStatus());
                banner.setEndDate(bannerDto.getEndDate());
                banner.setPriority(bannerDto.getPriority());
                return bannerRepository.save(banner);
            }
            return new CustomException(400, "No image file!");
        } catch (Exception e) {
            return e;
        }
    }

    @Override
    public Banner create(BannerDto bannerDto) {
        BusinessAssert.isTrue(,BusinessExceptionCode.PERMISSION_DENIED,"Không có quyền");
    }

    @Override
    public Banner update(Long id, BannerDto bannerDto) {
        Optional<Banner> bannerOptional = bannerRepository.findById(id);
//        BusinessAssert.isTrue();
        return null;
    }

    @Override
    public Banner getOne(Long id) {
        Optional<Banner> bannerOptional = bannerRepository.findById(id);
        BusinessAssert.isTrue(bannerOptional.isPresent(), "2", "Không tồn tại");
        return bannerOptional.get();
    }

    @Override
    public ListDto<BannerDto> getList() {
        return null;
    }

    @Override
    public CustomResponse delete(Long id) {
        Optional<Banner> bannerOptional = bannerRepository.findById(id);
        BusinessAssert.isTrue();
    }

//    @Override
//    public void deleteById(Long id) {
//        bannerRepository.deleteById(id);
//    }
}
