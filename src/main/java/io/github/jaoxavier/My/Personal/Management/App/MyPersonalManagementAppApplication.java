package io.github.jaoxavier.My.Personal.Management.App;

import io.github.jaoxavier.My.Personal.Management.App.domain.entity.Client;
import io.github.jaoxavier.My.Personal.Management.App.domain.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MyPersonalManagementAppApplication {

	@Bean
	public CommandLineRunner init(@Autowired ClientRepository clientRepository){
		return args -> {
			clientRepository.save(new Client("chico"));
		};
	}

	public static void main(String[] args) {
		SpringApplication.run(MyPersonalManagementAppApplication.class, args);
	}

}
