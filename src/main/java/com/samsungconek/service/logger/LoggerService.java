package com.samsungconek.service.logger;

import com.samsungconek.model.entity.Logger;
import com.samsungconek.repository.ILoggerRepository;
import com.samsungconek.utils.exception.BusinessAssert;
import com.samsungconek.utils.exception.BusinessExceptionCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LoggerService implements ILoggerService {
    @Autowired
    private ILoggerRepository loggerRepository;

    @Override
    public List<Logger> findAll() {
        List<Logger> loggers = loggerRepository.findAll();
        BusinessAssert.isTrue(loggers.size() > 0, BusinessExceptionCode.EMPTY_LIST, "Danh sách rỗng");
        return loggers;
    }

    @Override
    public Logger findById(Long id) {
        Optional<Logger> loggerOptional = loggerRepository.findById(id);
        BusinessAssert.isTrue(loggerOptional.isPresent(), BusinessExceptionCode.NOT_EXIST, "Không tồn tại");
        return loggerOptional.get();
    }

    @Override
    public Logger save(Logger logger) {
        return loggerRepository.save(logger);
    }

    @Override
    public void deleteById(Long id) {
        Optional<Logger> loggerOptional = loggerRepository.findById(id);
        BusinessAssert.isTrue(loggerOptional.isPresent(), BusinessExceptionCode.NOT_EXIST, "Không tồn tại");
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
