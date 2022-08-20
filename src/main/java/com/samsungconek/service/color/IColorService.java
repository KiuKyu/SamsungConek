package com.samsungconek.service.color;

import com.samsungconek.model.entity.Color;
import com.samsungconek.service.IGeneralService;

public interface IColorService extends IGeneralService<Color> {
    Color update (Long id, Color newColor);
}
