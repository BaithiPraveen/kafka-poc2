package pbaithi.poc.branch_three;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication(scanBasePackages = {
		"pbaithi.poc.branch_three",
		"pabaithi.poc.base_domain" // <-- include base-domain
})
public class BranchOfficeThreeApplication {

	public static void main(String[] args) {
		SpringApplication.run(BranchOfficeThreeApplication.class, args);
	}

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}
}
