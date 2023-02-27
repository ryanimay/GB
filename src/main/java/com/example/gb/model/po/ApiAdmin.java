package com.example.gb.model.po;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name="api_admin")
public class ApiAdmin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "account")
    private String account;
    @Column(name = "password")
    private String password;
    @Column(name = "last_login_time")
    private Date lastLoginTime;
    @Column(name = "create_time")
    private Date createTime;
    @Column(name = "balance")
    private Double balance;
    @Column(name = "admin_id")
    private Integer adminId;
    @Column(name = "api_id")
    private Integer apiId;

    public Integer getId() {return id;}
    public void setId(Integer id) {this.id = id;}
    public String getAccount() {return account;}
    public void setAccount(String account) {this.account = account;}
    public String getPassword() {return password;}
    public void setPassword(String password) {this.password = password;}
    public Date getLastLoginTime() {return lastLoginTime;}
    public void setLastLoginTime(Date lastLoginTime) {this.lastLoginTime = lastLoginTime;}
    public Date getCreateTime() {return createTime;}
    public void setCreateTime(Date createTime) {this.createTime = createTime;}
    public Double getBalance() {return balance;}
    public void setBalance(Double balance) {this.balance = balance;}
    public Integer getAdminId() {return adminId;}
    public void setAdminId(Integer adminId) {this.adminId = adminId;}
    public Integer getApiId() {return apiId;}
    public void setApiId(Integer apiId) {this.apiId = apiId;}
}