package com.samsungconek.service.phase;

import com.samsungconek.model.entity.Phase;
import com.samsungconek.service.IGeneralService;

import java.util.List;

public interface IPhaseService extends IGeneralService<Phase> {
    public Phase update(Long id, Phase phase);
}
