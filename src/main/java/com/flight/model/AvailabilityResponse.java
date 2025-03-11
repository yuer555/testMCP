package com.flight.model;

import java.math.BigDecimal;

public class AvailabilityResponse {
    private boolean available;
    private int remainingSeats;
    private String cabinClass;
    private BigDecimal price;

    public AvailabilityResponse(boolean available, int remainingSeats, String cabinClass, BigDecimal price) {
        this.available = available;
        this.remainingSeats = remainingSeats;
        this.cabinClass = cabinClass;
        this.price = price;
    }

    // Getters and Setters
    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public int getRemainingSeats() {
        return remainingSeats;
    }

    public void setRemainingSeats(int remainingSeats) {
        this.remainingSeats = remainingSeats;
    }

    public String getCabinClass() {
        return cabinClass;
    }

    public void setCabinClass(String cabinClass) {
        this.cabinClass = cabinClass;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
} 