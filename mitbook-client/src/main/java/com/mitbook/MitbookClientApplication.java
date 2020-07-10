package com.mitbook;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
@MapperScan("com.mitbook.mapper")
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class MitbookClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(MitbookClientApplication.class, args);
    }

}
