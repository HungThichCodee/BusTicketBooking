package com.busticket.busticket_bookingsystem.dto.response;

import lombok.Data;

import java.util.List;

@Data
public class PageResponse<T> {
    private List<T> dataList;
    private Integer pageCount;
    private Long totalElements;
}
