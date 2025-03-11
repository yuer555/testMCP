package com.flight.model;

import java.util.List;

public class FlightSearchResponse {
    private List<Flight> flights;

    public FlightSearchResponse(List<Flight> flights) {
        this.flights = flights;
    }

    public List<Flight> getFlights() {
        return flights;
    }

    public void setFlights(List<Flight> flights) {
        this.flights = flights;
    }

    @Override
    public String toString() {
        return "FlightSearchResponse{" +
                "flights=" + flights +
                '}';
    }

    // Getters and Setters
} 