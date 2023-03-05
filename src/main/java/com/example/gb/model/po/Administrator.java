package com.example.gb.model.po;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.Date;

@Entity
@Table(name = "administrator")
public class Administrator {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "account")
    @NotBlank(message = "用户名不能為空")
    private String account;
    @Column(name = "password")
    @NotBlank(message = "密碼不能為空")
    @Size(min = 8, max = 16, message = "密碼長度必須在8到16之間")
    private String password;
    @Column(name = "last_login_time")
    private Date lastLoginTime;
    @Column(name = "create_time")
    private Date createTime;
    @Column(name = "create_user")
    private String createUser;
    @Column(name = "salt")
    private String salt;

    public Administrator() {
    }

    public Administrator(String account, String password) {
        this.account = account;
        this.password = password;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }
}