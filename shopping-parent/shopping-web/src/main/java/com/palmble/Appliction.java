package com.palmble;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.transaction.annotation.EnableTransactionManagement;



@SpringBootApplication(scanBasePackages= {"com.palmble.sp.manger.*"})
@MapperScan({"com.palmble.sp.manger.dao"})
@ServletComponentScan
@EnableAspectJAutoProxy(exposeProxy=true)
@EnableTransactionManagement
public class Appliction {
	public static void main(String[] args) throws Exception {
		SpringApplication.run(Appliction.class, args);
	}
}