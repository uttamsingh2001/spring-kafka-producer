package com.kafka.apachekafkaconsumerdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;

@EnableKafka
@SpringBootApplication
public class ApacheKafkaConsumerDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApacheKafkaConsumerDemoApplication.class, args);
	}

}
