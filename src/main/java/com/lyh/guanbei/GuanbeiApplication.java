package com.lyh.guanbei;

import com.lyh.guanbei.service.UserService;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;

@SpringBootApplication
@MapperScan("com.lyh.guanbei.mapper")
public class GuanbeiApplication {
	public static void main(String[] args) {
		SpringApplication.run(GuanbeiApplication.class, args);
	}
}
