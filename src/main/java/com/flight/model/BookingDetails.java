package com.flight.model;

import java.time.LocalDateTime;
import java.util.List;

public class BookingDetails {
    private String bookingNumber;
    private Flight flight;
    private List<Passenger> passengers;
    private String cabinClass;
    private LocalDateTime bookingTime;
    private String status;

    public BookingDetails(String bookingNumber, Flight flight, List<Passenger> passengers, 
                         String cabinClass, LocalDateTime bookingTime, String status) {
        this.bookingNumber = bookingNumber;
        this.flight = flight;
        this.passengers = passengers;
        this.cabinClass = cabinClass;
        this.bookingTime = bookingTime;
        this.status = status;
    }

    // Getters and Setters
    // ... 添加所有字段的getter和setter方法
} 