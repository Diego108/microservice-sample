package br.com.diego.sample.microsevicesample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"br.com.diego.sample.microsevicesample"})
public class MicroseviceSampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroseviceSampleApplication.class, args);
	}

}
