## Springboot 项目

## 社区网站搭建

## 所使用到的资料网站
https://spring.io/guides/gs/serving-web-content/
https://v3.bootcss.com/
https://developer.github.com/apps/building-oauth-apps/creating-an-oauth-app/
http://www.h2database.com/html/main.html
http://mybatis.org/spring-boot-starter/mybatis-spring-boot-autoconfigure/

## sql脚本
```
-- auto-generated definition
create table USER
(
    ID           INT auto_increment
        primary key,
    ACCOUNT_ID   VARCHAR(100),
    NAME         VARCHAR(50),
    TOKEN        CHAR(36),
    GMT_CREATE   BIGINT,
    GMT_MODIFIED BIGINT
);


```

 H2用户名和密码:phl 123456
