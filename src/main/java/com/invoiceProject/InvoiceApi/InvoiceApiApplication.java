package com.invoiceProject.InvoiceApi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class InvoiceApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(InvoiceApiApplication.class, args);
	}

}
