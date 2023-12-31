package com.alibou.oauth2.landleasing.login;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableAutoConfiguration
@EnableJpaRepositories(basePackages="com.alibou.oauth2.landleasing.dbtest")
@EntityScan(basePackages="com.alibou.oauth2.landleasing.dbtest")
public class LandLeasingApplication {

	public static void main(String[] args) {
		SpringApplication.run(LandLeasingApplication.class, args);
	}

}
