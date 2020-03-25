package it.dstech.scheduled;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class RunnerScheduledApplication {
	public static void main(String[] args) {
		SpringApplication.run(RunnerScheduledApplication.class, args);
	}

}
