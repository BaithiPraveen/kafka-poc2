package pbaithi.poc.branch_two;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

//@SpringBootApplication
@SpringBootApplication(scanBasePackages = {
		"pbaithi.poc.branch_two",
		"pabaithi.poc.base_domain" // <-- include base-domain
})
public class BranchOfficeTwoApplication {

	public static void main(String[] args) {
		SpringApplication.run(BranchOfficeTwoApplication.class, args);
	}

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}
}
