package com.samsungconek.service.color;

import com.samsungconek.model.entity.Color;
import com.samsungconek.repository.IColorRepository;
import com.samsungconek.utils.CustomResponse;
import com.samsungconek.utils.exception.BusinessAssert;
import com.samsungconek.utils.exception.BusinessExceptionCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ColorService implements IColorService{
    @Autowired
    private IColorRepository colorRepository;

    @Override
    public List<Color> findAll() {
        List<Color> colors = colorRepository.findAll();
        BusinessAssert.isTrue(colors.size() > 0, BusinessExceptionCode.EMPTY_LIST, "Danh sách rỗng");
        return colors;
    }

    @Override
    public Color findById(Long id) {
        Optional<Color> colorOptional = colorRepository.findById(id);
        BusinessAssert.isTrue(colorOptional.isPresent(), BusinessExceptionCode.NOT_EXIST, "Không tồn tại");
        return colorOptional.get();
    }

    @Override
    public Color save(Color color) {
        return colorRepository.save(color);
    }

    @Override
    public CustomResponse deleteById(Long id) {
        Optional<Color> colorOptional = colorRepository.findById(id);
        BusinessAssert.isTrue(colorOptional.isPresent(), BusinessExceptionCode.NOT_EXIST, "Không tồn tại");
        colorRepository.deleteById(id);
        return new CustomResponse("Thành công", 1);
    }

    @Override
    public Color update(Long id, Color newColor) {
        Optional<Color> colorOptional = colorRepository.findById(id);
        BusinessAssert.isTrue(colorOptional.isPresent(), BusinessExceptionCode.NOT_EXIST, "Không tồn tại");
        return colorRepository.save(newColor);
    }
}
