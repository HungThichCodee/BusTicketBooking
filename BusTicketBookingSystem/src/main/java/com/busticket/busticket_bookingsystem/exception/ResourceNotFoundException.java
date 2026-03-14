package com.busticket.busticket_bookingsystem.exception;

import lombok.Data;

@Data
public class ResourceNotFoundException extends RuntimeException{
   private final String errorMessage;
}
