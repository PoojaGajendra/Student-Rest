package org.jsp.RestCrud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Student CRUD", version = "1.0", description = "Its a RESt API for performing CRUD operation in student record", contact = @Contact(name = "Pooja G", email = "poojapo3800@gmail.com",url="http://www.github.com/PoojaGajendra")))
public class RestCrudApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestCrudApplication.class, args);

	}
}
