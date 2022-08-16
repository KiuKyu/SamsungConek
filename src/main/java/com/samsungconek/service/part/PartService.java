package com.samsungconek.service.part;

import com.samsungconek.model.entity.Part;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class PartService implements IPartService {
    @Autowired
    private IPartService partService;

    @Override
    public Iterable<Part> findAll() {
        return null;
    }

    @Override
    public Optional<Part> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public Part save(Part part) {
        return null;
    }

    @Override
    public void deleteById(Long id) {

    }
}
