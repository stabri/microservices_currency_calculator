package com.paul.currencyconversionserviece;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients("com.paul.currencyconversionserviece")
public class CurrencyConversionServieceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CurrencyConversionServieceApplication.class, args);
	}
}
