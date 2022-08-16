package com.samsungconek.service.shipping;

import com.samsungconek.model.entity.Shipping;
import com.samsungconek.repository.IShippingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ShippingService implements IShippingService {
    @Autowired
    private IShippingRepository shippingRepository;

    @Override
    public Iterable<Shipping> findAll() {
        return null;
    }

    @Override
    public Optional<Shipping> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public Shipping save(Shipping shipping) {
        return null;
    }

    @Override
    public void deleteById(Long id) {

    }
}
