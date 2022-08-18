package com.samsungconek.controller;

import com.samsungconek.model.dto.BannerDto;
import com.samsungconek.utils.CustomResponse;
import com.samsungconek.model.entity.Banner;
import com.samsungconek.service.banner.IBannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/banners")
public class BannerController extends AbstractController {
    @Autowired
    private IBannerService bannerService;

    @GetMapping
    public ResponseEntity<?> findAll() {
//        Iterable<Banner> banners = bannerService.findAll();
//        CustomResponse customResponse = new CustomResponse("SUCCESS", 1, banners);
//        return new ResponseEntity<>(customResponse, HttpStatus.OK);

        List<Banner> bannerList = bannerService.findAll();
        return getResponseEntity(bannerService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getOne(@PathVariable Long id) {
        return getResponseEntity(bannerService.findById(id));
    }

    @PostMapping
    public ResponseEntity<?> create(@ModelAttribute BannerDto bannerDto) {
        return getResponseEntity(bannerService.save(bannerDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @ModelAttribute BannerDto bannerDto) {
        return getResponseEntity(bannerService.update(id, bannerDto));
    }

//    @PostMapping
//    public ResponseEntity<?> create(@ModelAttribute BannerDto bannerDto) {
//        Object banner = bannerService.saveNew(bannerDto);
//        Envelope cr = new Envelope(banner);
//        return cr.toResponseEntity();
//    }
//
//    @PutMapping("/{id}")
//    public ResponseEntity<?> updateBanner(@PathVariable Long id, @ModelAttribute BannerDto bannerDto) {
//        ResponseHandler responseHandler = new ResponseHandler();
//        Banner banner;
//        try {
//            Optional<Banner> bannerOptional = bannerService.findById(id);
//            banner = bannerOptional.get();
//        } catch (CustomException e) {
//            responseHandler.setCode(2);
//            responseHandler.setMessage("FAILURE");
//            return new ResponseEntity<>(responseHandler, HttpStatus.BAD_REQUEST);
//        }
//        Banner oldBanner = new Banner();
//        oldBanner.setId(id);
//        oldBanner.setName(bannerDto.getName());
//        oldBanner.setStatus(bannerDto.isStatus());
//        oldBanner.setPriority(bannerDto.getPriority());
//        oldBanner.setEndDate(bannerDto.getEndDate());
//
//        MultipartFile img = bannerDto.getImage();
//        if (img != null && img.getSize() != 0) {
//            String fileName = img.getOriginalFilename();
//            long currentTime = System.currentTimeMillis();
////            Logger logger = new Logger();
////            logger.setLogTime(currentTime);
//            fileName = currentTime + "_" + fileName;
//            try {
//                FileCopyUtils.copy(img.getBytes(), new File(uploadPath + fileName));
//            } catch (IOException e) {
//                throw new RuntimeException(e);
//            }
//            oldBanner.setImage(fileName);
//            bannerService.save(oldBanner);
//            responseHandler.setCode(1);
//            responseHandler.setMessage("SUCCESS");
//            responseHandler.setData(oldBanner);
//            return new ResponseEntity<>(responseHandler, HttpStatus.OK);
//        }
//        responseHandler.setCode(2);
//        responseHandler.setMessage("FAILURE");
//        return new ResponseEntity<>(responseHandler, HttpStatus.BAD_REQUEST);
//    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteBanner(@PathVariable Long id) {
        return getResponseEntity(bannerService.deleteById(id));
    }

    @PostMapping("/multiple")
    public ResponseEntity<?> saveMulti() {
        return null;
    }
}
