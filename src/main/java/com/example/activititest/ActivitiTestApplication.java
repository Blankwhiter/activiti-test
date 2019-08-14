package com.example.activititest;

import org.activiti.spring.boot.SecurityAutoConfiguration;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 配置mybatis扫描包 去除exclude = SecurityAutoConfiguration.class ，
 * org.activiti.spring.boot.SecurityAutoConfiguration会导致
 * Invocation of init method failed; nested exception is java.lang.ArrayStoreException: sun.reflect.annotation.TypeNotPresentExceptionProxy
 */
@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
@MapperScan(basePackages = "com.example.activititest.dao")
public class ActivitiTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(ActivitiTestApplication.class, args);
    }

}
