package br.com.itau.password.api;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.Environment;

@Slf4j
@SpringBootApplication
public class App {

	public static void main(String[] args) {

		SpringApplication application = new SpringApplication(App.class);
		Environment env = application.run(args).getEnvironment();

		String port = env.getProperty("server.port");

		log.info("\n\n\t Swagger: http://localhost:{}/swagger-ui/index.html\n", port);
	}

}
