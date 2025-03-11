package com.flight.model;

import java.time.LocalDate;

/**
 * 乘客信息实体类
 * 包含乘客的个人信息和证件信息
 */
public class Passenger {
    private String name;            // 乘客姓名
    private String documentType;    // 证件类型
    private String documentNumber;  // 证件号码
    private LocalDate birthDate;    // 出生日期
    private String nationality;     // 国籍
    private String gender;          // 性别
    private String contactPhone;    // 联系电话
    private String email;           // 电子邮件
    
    public Passenger(String name, String documentType, String documentNumber, 
                    String birthDate, String nationality, String gender, 
                    String contactPhone, String email) {
        this.name = name;
        this.documentType = documentType;
        this.documentNumber = documentNumber;
        this.birthDate = LocalDate.parse(birthDate);
        this.nationality = nationality;
        this.gender = gender;
        this.contactPhone = contactPhone;
        this.email = email;
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDocumentType() {
        return documentType;
    }

    public void setDocumentType(String documentType) {
        this.documentType = documentType;
    }

    public String getDocumentNumber() {
        return documentNumber;
    }

    public void setDocumentNumber(String documentNumber) {
        this.documentNumber = documentNumber;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getContactPhone() {
        return contactPhone;
    }

    public void setContactPhone(String contactPhone) {
        this.contactPhone = contactPhone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
} 