package com.busticket.busticket_bookingsystem.dto.response;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;
import java.util.Map;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = false)
public class ReportResponse {
     Map<String, ? extends Object> reportData;
}
