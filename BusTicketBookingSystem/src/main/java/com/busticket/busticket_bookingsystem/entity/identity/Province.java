package com.busticket.busticket_bookingsystem.entity.identity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = false)
public class Province {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String name; // eg: 'Gia Lai'

    String codeName; // eg: 'gia_lai'
}