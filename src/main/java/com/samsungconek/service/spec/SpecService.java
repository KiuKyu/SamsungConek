package com.samsungconek.service.spec;

import com.samsungconek.model.entity.Spec;
import com.samsungconek.repository.ISpecRepository;
import com.samsungconek.utils.CustomResponse;
import com.samsungconek.utils.exception.BusinessAssert;
import com.samsungconek.utils.exception.BusinessExceptionCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SpecService implements ISpecService {
    @Autowired
    private ISpecRepository specRepository;

    @Override
    public List<Spec> findAll() {
        return specRepository.findAll();
    }

    @Override
    public Spec findById(Long id) {
        Optional<Spec> specOptional = specRepository.findById(id);
        BusinessAssert.isTrue(specOptional.isPresent(), BusinessExceptionCode.NOT_EXIST, "Không tồn tại");
        return specOptional.get();
    }

    @Override
    public Spec save(Spec spec) {
        return specRepository.save(spec);
    }

    @Override
    public CustomResponse deleteById(Long id) {
        Optional<Spec> specOptional = specRepository.findById(id);
        BusinessAssert.isTrue(specOptional.isPresent(), BusinessExceptionCode.NOT_EXIST, "Không tồn tại");
        specRepository.deleteById(id);
        return new CustomResponse("Thành công", 1);
    }

    @Override
    public Spec update(Long id, Spec newSpec) {
        Optional<Spec> specOptional = specRepository.findById(id);
        BusinessAssert.isTrue(specOptional.isPresent(), BusinessExceptionCode.NOT_EXIST, "Không tồn tại");
        Spec spec = new Spec();
        spec.setId(id);
        spec.setName(newSpec.getName());
        spec.setStatus(newSpec.isStatus());
        return spec;
    }
}
