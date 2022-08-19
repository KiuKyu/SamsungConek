package com.samsungconek.service.shipping;

import com.samsungconek.model.entity.Shipping;
import com.samsungconek.repository.IShippingRepository;
import com.samsungconek.utils.CustomResponse;
import com.samsungconek.utils.exception.BusinessAssert;
import com.samsungconek.utils.exception.BusinessExceptionCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ShippingService implements IShippingService {
    @Autowired
    private IShippingRepository shippingRepository;

    @Override
    public List<Shipping> findAll() {
        return null;
    }

    @Override
    public Shipping findById(Long id) {
        Optional<Shipping> shippingOptional = shippingRepository.findById(id);
        BusinessAssert.isTrue(shippingOptional.isPresent(), BusinessExceptionCode.NOT_EXIST, "Không tồn tại");
        return shippingOptional.get();
    }

    @Override
    public Shipping save(Shipping shipping) {
        return shippingRepository.save(shipping);
    }

    @Override
    public CustomResponse deleteById(Long id) {
        Optional<Shipping> shippingOptional = shippingRepository.findById(id);
        BusinessAssert.isTrue(shippingOptional.isPresent(), BusinessExceptionCode.NOT_EXIST, "Không tồn tại");
        shippingRepository.deleteById(id);
        return new CustomResponse("Thành công", 200);
    }
}
