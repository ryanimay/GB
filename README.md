# Introduction

練習用的小專案  
內容主要是遊戲平台，串接三方遊戲API，  
實作登入註冊，轉帳，驗證等功能，  
包含平台的後台廠商遊戲、會員管理、轉帳紀錄等。  
  
主要想練習的部分是  
不同的資料庫、docker的使用、緩存、權限控管  
和練習前端Vue.js框架，  
並遵循TDD的流程開發，  
最後練習使用JMeter/K6做壓測  

Its a little project for practice.

The content is about a gaming platform that integrates game interfaces provided by three parties, and has a transfer function, as well as a platform backend member management system.

Expected to be completed using the following technologies:  
Mariadb(using docker)  
HikariCP(connectionPool)  
JPA  
auth(SpringSecurity or Shiro)  
SpringBoot(API)  
Redis(cache)  
Vue.js(front-end)  

---
### Update log

20230226 - docker起mariadb，完成db結構創建  
20230228 - 完成簡易Entity創建工具，並建完相關bean/service  
