package com.samsungconek.service.color;

import com.samsungconek.model.entity.Color;
import com.samsungconek.repository.IColorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ColorService implements IColorService{
    @Autowired
    private IColorRepository colorRepository;

    @Override
    public Iterable<Color> findAll() {
        return colorRepository.findAll();
    }

    @Override
    public Optional<Color> findById(Long id) {
        return colorRepository.findById(id);
    }

    @Override
    public Color save(Color color) {
        return colorRepository.save(color);
    }

    @Override
    public void deleteById(Long id) {
        colorRepository.deleteById(id);
    }
}
