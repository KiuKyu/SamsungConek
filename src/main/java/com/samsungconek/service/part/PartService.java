package com.samsungconek.service.part;

import com.samsungconek.model.entity.Part;
import com.samsungconek.repository.IPartRepository;
import com.samsungconek.utils.exception.BusinessAssert;
import com.samsungconek.utils.exception.BusinessExceptionCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PartService implements IPartService {
    @Autowired
    private IPartRepository partRepository;

    @Override
    public List<Part> findAll() {
        List<Part> parts = partRepository.findAll();
        BusinessAssert.isTrue(parts.size() > 0, BusinessExceptionCode.EMPTY_LIST, "Danh sách rỗng");
        return parts;
    }

    @Override
    public Part findById(Long id) {
        Optional<Part> partOptional = partRepository.findById(id);
        BusinessAssert.isTrue(partOptional.isPresent(), BusinessExceptionCode.NOT_EXIST, "Không tồn tại");
        return partOptional.get();
    }

    @Override
    public Part save(Part part) {
        return partRepository.save(part);
    }

    @Override
    public void deleteById(Long id) {
        Optional<Part> partOptional = partRepository.findById(id);
        BusinessAssert.isTrue(partOptional.isPresent(), BusinessExceptionCode.NOT_EXIST, "Không tồn tại");
        partRepository.deleteById(id);
    }
}
