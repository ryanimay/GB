package com.example.gb.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.Date;


@Entity
@Table(name="trans_record")
public class TransRecord {
    @Id
    @Column(name = "id")
    private String id;
    @Column(name = "api_id")
    private Integer apiId;
    @Column(name = "admin_id")
    private Integer adminId;
    @Column(name = "amount")
    private Double amount;
    @Column(name = "currency")
    private String currency;
    @Column(name = "trans_time")
    private Date transTime;
    @Column(name = "status")
    private String status;

    public String getId() {return id;}
    public void setId(String id) {this.id = id;}
    public Integer getApiId() {return apiId;}
    public void setApiId(Integer apiId) {this.apiId = apiId;}
    public Integer getAdminId() {return adminId;}
    public void setAdminId(Integer adminId) {this.adminId = adminId;}
    public Double getAmount() {return amount;}
    public void setAmount(Double amount) {this.amount = amount;}
    public String getCurrency() {return currency;}
    public void setCurrency(String currency) {this.currency = currency;}
    public Date getTransTime() {return transTime;}
    public void setTransTime(Date transTime) {this.transTime = transTime;}
    public String getStatus() {return status;}
    public void setStatus(String status) {this.status = status;}
}