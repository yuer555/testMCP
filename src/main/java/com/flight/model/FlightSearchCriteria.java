package com.flight.model;

import java.time.LocalDate;
import java.util.List;

/**
 * 航班搜索条件实体类
 * 封装航班搜索的各项参数
 */
public class FlightSearchCriteria {
    private String departure;          // 出发城市
    private String arrival;            // 到达城市
    private LocalDate departureDate;   // 出发日期
    private LocalDate returnDate;      // 返回日期（往返航班）
    private int passengerCount;        // 乘客数量
    private List<String> cabinClasses; // 舱位等级
    private boolean directFlightOnly;  // 是否只查询直飞航班
    private String airline;            // 指定航空公司

    public FlightSearchCriteria(String departure, String arrival, String departureDate) {
        this.departure = departure;
        this.arrival = arrival;
        this.departureDate = LocalDate.parse(departureDate);
        this.passengerCount = 1;
        this.directFlightOnly = false;
    }

    // Getters and Setters
    public String getDeparture() {
        return departure;
    }

    public void setDeparture(String departure) {
        this.departure = departure;
    }

    public String getArrival() {
        return arrival;
    }

    public void setArrival(String arrival) {
        this.arrival = arrival;
    }

    public LocalDate getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(LocalDate departureDate) {
        this.departureDate = departureDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }

    public int getPassengerCount() {
        return passengerCount;
    }

    public void setPassengerCount(int passengerCount) {
        this.passengerCount = passengerCount;
    }

    public List<String> getCabinClasses() {
        return cabinClasses;
    }

    public void setCabinClasses(List<String> cabinClasses) {
        this.cabinClasses = cabinClasses;
    }

    public boolean isDirectFlightOnly() {
        return directFlightOnly;
    }

    public void setDirectFlightOnly(boolean directFlightOnly) {
        this.directFlightOnly = directFlightOnly;
    }

    public String getAirline() {
        return airline;
    }

    public void setAirline(String airline) {
        this.airline = airline;
    }
} 