package com.example.gb.model.po;

import jakarta.persistence.*;

@Entity
@Table(name="api")
public class Api {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "url")
    private String url;
    @Column(name = "merchant")
    private String merchant;
    @Column(name = "ext_json")
    private String extJson;
    @Column(name = "currency")
    private String currency;

    public Integer getId() {return id;}
    public void setId(Integer id) {this.id = id;}
    public String getUrl() {return url;}
    public void setUrl(String url) {this.url = url;}
    public String getMerchant() {return merchant;}
    public void setMerchant(String merchant) {this.merchant = merchant;}
    public String getExtJson() {return extJson;}
    public void setExtJson(String extJson) {this.extJson = extJson;}
    public String getCurrency() {return currency;}
    public void setCurrency(String currency) {this.currency = currency;}
}