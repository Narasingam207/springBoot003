package springBoot.springBoot003;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class SpringBoot003Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringBoot003Application.class, args);
	}
	@Bean
	public RestTemplate restTemplate()
	{
		return new RestTemplate();
	}

}
