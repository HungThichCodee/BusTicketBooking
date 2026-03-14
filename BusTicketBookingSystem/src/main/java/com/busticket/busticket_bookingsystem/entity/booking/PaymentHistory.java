package com.busticket.busticket_bookingsystem.entity.booking;

import com.busticket.busticket_bookingsystem.enums.PaymentStatus;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = false)
public class PaymentHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @ManyToOne
    @JoinColumn(name = "booking_id")
    @JsonIgnore
    Booking booking;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    LocalDateTime statusChangeDateTime;

    @Enumerated(EnumType.STRING)
    PaymentStatus oldStatus;

    @Enumerated(EnumType.STRING)
    PaymentStatus newStatus;
}
