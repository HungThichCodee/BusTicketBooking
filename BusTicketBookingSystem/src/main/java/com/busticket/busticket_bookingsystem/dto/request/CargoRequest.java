package com.busticket.busticket_bookingsystem.dto.request;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = false)
public class CargoRequest {
    Long cargoId;
    int quantity;

    @Override
    public String toString() {
        return "CargoRequest{" +
                "cargoId=" + cargoId +
                ", quantity=" + quantity +
                '}';
    }
}
