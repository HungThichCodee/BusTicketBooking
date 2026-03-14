package com.busticket.busticket_bookingsystem.dto.request;

import com.busticket.busticket_bookingsystem.enums.RecipientType;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = false)
public class NotificationRequest {
      String title;
      String message;
      RecipientType recipientType;
      String senderUsername;
      List<String> recipientIdentifiers;
}
