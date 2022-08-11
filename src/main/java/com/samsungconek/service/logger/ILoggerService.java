package com.samsungconek.service.logger;

import com.samsungconek.model.entity.Logger;
import com.samsungconek.service.IGeneralService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ILoggerService extends IGeneralService<Logger> {
    Page<Logger> findAll(Pageable pageable);

//    Page<Logger> findAllByUser(Pageable pageable, User user);
}
