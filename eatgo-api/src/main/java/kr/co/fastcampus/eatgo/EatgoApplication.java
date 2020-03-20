package kr.co.fastcampus.eatgo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"kr.co.fastcampus.eatgo.*"})
public class EatgoApplication {

	public static void main(String[] args) {
		SpringApplication.run(EatgoApplication.class, args);
	}

}
