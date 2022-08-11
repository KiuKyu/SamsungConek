package com.samsungconek.model.dto;

import java.util.Collections;
import java.util.List;

public class ListDto<T> {
    @SuppressWarnings({"rawtypes"})
    private static final ListDto EMPTY_LIST = new ListDto<>(Collections.emptyList(), 0l);

    @SuppressWarnings("unchecked")
    public static final <T> ListDto<T> emptyList() {
        return EMPTY_LIST;
    }

    private List<T> list;

    private Long count;

    public ListDto(List<T> list) {
        this.list = list;
        this.count = (long) list.size();
    }

    public ListDto(List<T> list, Long count) {
        this.list = list;
        this.count = count;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }
}
