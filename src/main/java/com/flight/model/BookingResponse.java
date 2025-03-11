package com.flight.model;

/**
 * 航班预订响应实体类
 * 包含预订结果信息
 */
public class BookingResponse {
    private boolean success;        // 是否预订成功
    private String message;         // 预订结果消息
    private String bookingNumber;   // 订单号

    public BookingResponse(boolean success, String message, String bookingNumber) {
        this.success = success;
        this.message = message;
        this.bookingNumber = bookingNumber;
    }

    // Getters and Setters
    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getBookingNumber() {
        return bookingNumber;
    }

    public void setBookingNumber(String bookingNumber) {
        this.bookingNumber = bookingNumber;
    }

    @Override
    public String toString() {
        return "BookingResponse{" +
                "success=" + success +
                ", message='" + message + '\'' +
                ", bookingNumber='" + bookingNumber + '\'' +
                '}';
    }
} 