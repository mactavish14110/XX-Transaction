package com.jzh.xx.transaction;

import com.jzh.xx.transaction.utils.IdWorker;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;


@SpringBootApplication
@MapperScan(basePackages = "com.jzh.xx.transaction.mapper")
public class XxTransactionApplication {

    @Value("${workerId}")
    private Integer workerId;

    @Value("${datacenterId}")
    private Integer datacenterId;

    public IdWorker idWorker(){
        return new IdWorker(workerId,datacenterId);
    }

    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(XxTransactionApplication.class, args);
    }

}
