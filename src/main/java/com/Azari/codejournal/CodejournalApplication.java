package com.Azari.codejournal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CodejournalApplication {

	public static void main(String[] args) {
		SpringApplication.run(CodejournalApplication.class, args);
		System.out.println("Finished Building, Connection to server established ");

	}

}
