package com.samsungconek.service;

import com.samsungconek.model.dto.base.ObjectResponse;
import com.samsungconek.utils.exception.CustomException;

import java.util.List;
import java.util.Optional;

public interface IGeneralService<T> {
    List<T> findAll();

    T findById(Long id);

    T save(T t);

    ObjectResponse deleteById(Long id);

//    Nếu k sửa được Sequence + Trigger :
//    => Tạo thêm 2 phương thức chung
//    => Phương thức checkRow() : Check xem có bản ghi nào trong bảng k ?
//    ===> nếu không thì : cho ID start từ 1
//    ===> nếu có thì : chạy phương thức findLatest() để lấy ra ID của bản ghi cuối rồi +1 cho những row mới

//    Optional<T> findLatest();
//
//    int checkRow();
}
