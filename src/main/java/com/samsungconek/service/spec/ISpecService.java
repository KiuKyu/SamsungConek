package com.samsungconek.service.spec;

import com.samsungconek.model.entity.Spec;
import com.samsungconek.service.IGeneralService;

public interface ISpecService extends IGeneralService<Spec> {
    Spec update(Long id, Spec newSpec);
}
