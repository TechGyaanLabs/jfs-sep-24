package com.careerit.cbook;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

@SpringBootApplication
public class CbookWithSpringbootJdbcApplication implements CommandLineRunner {

	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	public static void main(String[] args) {
		SpringApplication.run(CbookWithSpringbootJdbcApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {

	}
}
