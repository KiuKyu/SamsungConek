package com.samsungconek.service.footer;

import com.samsungconek.model.entity.Footer;
import com.samsungconek.repository.IFooterRepository;
import com.samsungconek.utils.CustomResponse;
import com.samsungconek.utils.exception.BusinessAssert;
import com.samsungconek.utils.exception.BusinessExceptionCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FooterService implements IFooterService {
    @Autowired
    private IFooterRepository footerRepository;


    @Override
    public List<Footer> findAll() {
        List<Footer> footerList = footerRepository.findAll();
        BusinessAssert.isTrue(footerList.size() > 0, BusinessExceptionCode.EMPTY_LIST, "Danh sách rỗng");
        return footerList;
    }

    @Override
    public Footer findById(Long id) {
        Optional<Footer> footerOptional = footerRepository.findById(id);
        BusinessAssert.isTrue(footerOptional.isPresent(), BusinessExceptionCode.NOT_EXIST, "Không tồn tại");
        return footerOptional.get();
    }

    @Override
    public Footer save(Footer footer) {
        return footerRepository.save(footer);
    }

    @Override
    public CustomResponse deleteById(Long id) {
        Optional<Footer> footerOptional = footerRepository.findById(id);
        BusinessAssert.isTrue(footerOptional.isPresent(), BusinessExceptionCode.NOT_EXIST, "Không tồn tại");
        footerRepository.deleteById(id);
        return new CustomResponse("Thành công", 1);
    }

    public Footer update(Long id, Footer newFooter) {
        Optional<Footer> footerOptional = footerRepository.findById(id);
        BusinessAssert.isTrue(footerOptional.isPresent(), BusinessExceptionCode.NOT_EXIST, "Không tồn tại");
        Footer footer = new Footer();
        footer.setId(id);
        footer.setName(newFooter.getName());
        footer.setValue(newFooter.getValue());
        return footerRepository.save(footer);
    }
}
