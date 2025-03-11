package com.flight.model;

public class CancellationResponse {
    private boolean success;
    private String message;
    private String refundAmount;

    public CancellationResponse(boolean success, String message, String refundAmount) {
        this.success = success;
        this.message = message;
        this.refundAmount = refundAmount;
    }

    // Getters and Setters
    // ... 添加所有字段的getter和setter方法
} 