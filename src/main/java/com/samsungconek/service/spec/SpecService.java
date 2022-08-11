package com.samsungconek.service.spec;

import com.samsungconek.model.entity.Spec;
import com.samsungconek.repository.ISpecRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SpecService implements ISpecService {
    @Autowired
    private ISpecRepository specRepository;

    @Override
    public Iterable<Spec> findAll() {
        return specRepository.findAll();
    }

    @Override
    public Optional<Spec> findById(Long id) {
        return specRepository.findById(id);
    }

    @Override
    public Spec save(Spec spec) {
        return specRepository.save(spec);
    }

    @Override
    public void deleteById(Long id) {
        specRepository.deleteById(id);
    }
}
