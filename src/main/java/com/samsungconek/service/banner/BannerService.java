package com.samsungconek.service.banner;

import com.samsungconek.model.dto.BannerDto;
import com.samsungconek.model.dto.ListDto;
import com.samsungconek.model.entity.Banner;
import com.samsungconek.repository.IBannerRepository;
import com.samsungconek.service.base.A_Service;
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
import java.util.List;
import java.util.Optional;

@Service
public class BannerService extends A_Service implements IBannerService {
    @Autowired
    private IBannerRepository bannerRepository;

    @Value("${file-upload}")
    private String uploadPath;

//    public Object saveNew(BannerDto bannerDto) {
//        MultipartFile img = bannerDto.getImage();
//        try {
//            if (img != null && img.getSize() != 0) {
//                String fileName = img.getOriginalFilename();
//                long currentTime = System.currentTimeMillis();
////            Logger logger = new Logger();
////            logger.setLogTime(currentTime);
//                fileName = currentTime + "_" + fileName;
//                FileCopyUtils.copy(img.getBytes(), new File(uploadPath + fileName));
//                Banner banner = new Banner();
//                banner.setName(bannerDto.getName());
//                banner.setImage(fileName);
//                banner.setStatus(bannerDto.isStatus());
//                banner.setEndDate(bannerDto.getEndDate());
//                banner.setPriority(bannerDto.getPriority());
//                return bannerRepository.save(banner);
//            }
//            return new CustomException(400, "No image file!");
//        } catch (Exception e) {
//            return e;
//        }
//    }

    @Override
    public Banner create(BannerDto bannerDto) {
        BusinessAssert.isTrue(isAdmin(), BusinessExceptionCode.PERMISSION_DENIED,"Không có quyền");
        MultipartFile img = bannerDto.getImage();
        BusinessAssert.notTrue(img.isEmpty(), BusinessExceptionCode.INVALID_PARAM, "Thiếu ảnh banner");
        String fileName = img.getOriginalFilename();
        long currentTime = System.currentTimeMillis();
        fileName = currentTime + "_" + fileName;
        try {
            FileCopyUtils.copy(img.getBytes(), new File(uploadPath + fileName));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Banner banner = new Banner();
        banner.setName(bannerDto.getName());
        banner.setStatus(bannerDto.isStatus());
        banner.setEndDate(bannerDto.getEndDate());
        banner.setPriority(bannerDto.getPriority());
        banner.setImage(fileName);
        return banner;
    }

    @Override
    public Banner update(Long id, BannerDto bannerDto) {
        BusinessAssert.isTrue(isAdmin(), BusinessExceptionCode.PERMISSION_DENIED, "Không có quyền");
        Optional<Banner> bannerOptional = bannerRepository.findById(id);
        BusinessAssert.isTrue(bannerOptional.isPresent(), BusinessExceptionCode.);
        return null;
    }

    @Override
    public Banner getOne(Long id) {
        Optional<Banner> bannerOptional = bannerRepository.findById(id);
        BusinessAssert.isTrue(bannerOptional.isPresent(), "2", "Không tồn tại");
        return bannerOptional.get();
    }

//    @Override
//    public ListDto<BannerDto> getList() {
//        ListDto<BannerDto> bannerListDto;
//        BusinessAssert.isTrue(, BusinessExceptionCode.EMPTY_LIST, "Không có banner nào tồn tại");
//        return null;
//    }

    @Override
    public CustomResponse delete(Long id) {
        BusinessAssert.isTrue(isAdmin(), BusinessExceptionCode.PERMISSION_DENIED, "Không có quyền");
        Optional<Banner> bannerOptional = bannerRepository.findById(id);
        BusinessAssert.isTrue(bannerOptional.isPresent(), "2", "Không tồn tại");
        bannerRepository.deleteById(id);
        return new CustomResponse("Thành công", 1);
    }

    @Override
    public List<Banner> findAll() {
        List<Banner> bannerList = bannerRepository.findAll();
        BusinessAssert.isTrue(bannerList.size() > 0, BusinessExceptionCode.EMPTY_LIST, "Danh sách rỗng");
        return bannerList;
    }
}
