package com.careerit.sbc;

import com.careerit.sbc.web.ProjectConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;

@SpringBootApplication
public class HelloWorldApplication implements CommandLineRunner {

	@Autowired
	private Environment env;
	@Autowired
	ProjectConfiguration projectConfiguration;

	@Value("${app.evn.message}")
	private String message;
	public static void main(String[] args) {
		SpringApplication.run(HelloWorldApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

			String message = env.getProperty("app.greet.message");
		System.out.println(message);
		System.out.println(projectConfiguration.getName());
		System.out.println(projectConfiguration.getDescription());
		System.out.println(projectConfiguration.getVersion());
		System.out.println(this.message);
	}
}
