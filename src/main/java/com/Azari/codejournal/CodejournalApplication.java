package com.Azari.codejournal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class CodejournalApplication {

	public static void main(String[] args) {
		SpringApplication.run(CodejournalApplication.class, args);
		System.out.println("Finished Building, Connection to server established ");

	}

}

