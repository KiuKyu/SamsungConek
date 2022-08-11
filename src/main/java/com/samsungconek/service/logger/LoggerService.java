package com.samsungconek.service.logger;

import com.samsungconek.model.entity.Logger;
import com.samsungconek.repository.ILoggerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LoggerService implements ILoggerService {
    @Autowired
    private ILoggerRepository loggerRepository;

    @Override
    public Iterable<Logger> findAll() {
        return null;
    }

    @Override
    public Optional<Logger> findById(Long id) {
        return loggerRepository.findById(id);
    }

    @Override
    public Logger save(Logger logger) {
        return loggerRepository.save(logger);
    }

    @Override
    public void deleteById(Long id) {
        loggerRepository.deleteById(id);
    }

    @Override
    public Page<Logger> findAll(Pageable pageable) {
        return loggerRepository.findAll(pageable);
    }

//    @Override
//    public Page<Logger> findAllByUser(Pageable pageable, User user) {
//        return loggerRepository.findAllByUser(pageable, user);
//    }
}
