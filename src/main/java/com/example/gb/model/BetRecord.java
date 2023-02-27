package com.example.gb.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name="bet_record")
public class BetRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "bet_id")
    private String betId;
    @Column(name = "trans_id")
    private String transId;
    @Column(name = "api_id")
    private Integer apiId;
    @Column(name = "api_admin_id")
    private Integer apiAdminId;
    @Column(name = "admin_id")
    private Integer adminId;
    @Column(name = "amount")
    private Double amount;
    @Column(name = "currency")
    private String currency;
    @Column(name = "bet_time")
    private Date betTime;
    @Column(name = "end_time")
    private Date endTime;
    @Column(name = "update_time")
    private Date updateTime;
    @Column(name = "status")
    private String status;
    @Column(name = "ext_josn")
    private String extJosn;

    public Integer getId() {return id;}
    public void setId(Integer id) {this.id = id;}
    public String getBetId() {return betId;}
    public void setBetId(String betId) {this.betId = betId;}
    public String getTransId() {return transId;}
    public void setTransId(String transId) {this.transId = transId;}
    public Integer getApiId() {return apiId;}
    public void setApiId(Integer apiId) {this.apiId = apiId;}
    public Integer getApiAdminId() {return apiAdminId;}
    public void setApiAdminId(Integer apiAdminId) {this.apiAdminId = apiAdminId;}
    public Integer getAdminId() {return adminId;}
    public void setAdminId(Integer adminId) {this.adminId = adminId;}
    public Double getAmount() {return amount;}
    public void setAmount(Double amount) {this.amount = amount;}
    public String getCurrency() {return currency;}
    public void setCurrency(String currency) {this.currency = currency;}
    public Date getBetTime() {return betTime;}
    public void setBetTime(Date betTime) {this.betTime = betTime;}
    public Date getEndTime() {return endTime;}
    public void setEndTime(Date endTime) {this.endTime = endTime;}
    public Date getUpdateTime() {return updateTime;}
    public void setUpdateTime(Date updateTime) {this.updateTime = updateTime;}
    public String getStatus() {return status;}
    public void setStatus(String status) {this.status = status;}
    public String getExtJosn() {return extJosn;}
    public void setExtJosn(String extJosn) {this.extJosn = extJosn;}
}