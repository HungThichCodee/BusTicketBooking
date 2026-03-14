package com.busticket.busticket_bookingsystem.entity.entityUser;

import com.busticket.busticket_bookingsystem.enums.TokenType;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = false)
public class Token {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String token;

    @Enumerated(EnumType.STRING)
    TokenType tokenType;

    boolean expired;

    boolean revoked;

    @ManyToOne
    @JoinColumn(name = "username")
    User user;
}
