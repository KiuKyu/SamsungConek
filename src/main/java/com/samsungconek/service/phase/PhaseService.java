package com.samsungconek.service.phase;

import com.samsungconek.model.entity.Phase;
import com.samsungconek.repository.IPhaseRepository;
import com.samsungconek.utils.CustomResponse;
import com.samsungconek.utils.exception.BusinessAssert;
import com.samsungconek.utils.exception.BusinessExceptionCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PhaseService implements IPhaseService{
    @Autowired
    private IPhaseRepository phaseRepository;

    @Override
    public Phase findById(Long id) {
        Optional<Phase> phaseOptional = phaseRepository.findById(id);
        BusinessAssert.isTrue(phaseOptional.isPresent(), BusinessExceptionCode.NOT_EXIST, "Không tồn tại");
        return phaseOptional.get();
    }

    @Override
    public Phase save(Phase phase) {
        return phaseRepository.save(phase);
    }

    @Override
    public CustomResponse deleteById(Long id) {
        Optional<Phase> phaseOptional = phaseRepository.findById(id);
        BusinessAssert.isTrue(phaseOptional.isPresent(), BusinessExceptionCode.NOT_EXIST, "Không tồn tại");
        phaseRepository.deleteById(id);
        return new CustomResponse("Thành công", 1);
    }

    @Override
    public Phase update(Long id, Phase newPhase) {
        Optional<Phase> phaseOptional = phaseRepository.findById(id);
        BusinessAssert.isTrue(phaseOptional.isPresent(), BusinessExceptionCode.NOT_EXIST, "Không tồn tại");
        phaseRepository.save(newPhase);
        return newPhase;
    }

    @Override
    public List<Phase> findAll() {
        List<Phase> phaseList = phaseRepository.findAll();
        BusinessAssert.isTrue(phaseList.size() > 0, BusinessExceptionCode.EMPTY_LIST, "Danh sách rỗng") ;
        return phaseList;
    }
}
