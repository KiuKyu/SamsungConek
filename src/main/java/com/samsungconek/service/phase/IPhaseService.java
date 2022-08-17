package com.samsungconek.service.phase;

import com.samsungconek.model.entity.Phase;

import java.util.List;

public interface IPhaseService {
    public List<Phase> phaseList();

    public Phase getOne(Long id);

    public void delete(Long id);

    public Phase update(Long id, Phase phase);
}
