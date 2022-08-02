package ucuenca.microservice.suenio.sonido;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class SonidoServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SonidoServiceApplication.class, args);
	}

}
