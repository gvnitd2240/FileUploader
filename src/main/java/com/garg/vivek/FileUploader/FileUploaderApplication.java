package com.garg.vivek.FileUploader;

import com.garg.vivek.FileUploader.entities.Role;
import com.garg.vivek.FileUploader.entities.User;
import com.garg.vivek.FileUploader.models.requests.FileUploadRequest;
import com.garg.vivek.FileUploader.repositories.RoleRepository;
import com.garg.vivek.FileUploader.repositories.UserRepo;
import com.garg.vivek.FileUploader.services.interfaces.FileUploaderService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.scheduling.annotation.EnableAsync;

import java.io.File;
import java.time.LocalDateTime;
import java.util.UUID;

@SpringBootApplication
@EnableJpaAuditing
@EnableAsync
public class FileUploaderApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(FileUploaderApplication.class, args);
	}

	@Bean
	public CommandLineRunner runner(RoleRepository roleRepository, FileUploaderService fileUploaderService, UserRepo userRepo){
		return args -> {
			if(roleRepository.findByName("USER").isEmpty()){
				roleRepository.save(
						Role.builder().name("USER").build()
				);
			}

			String filePath = "stree.mkv";
			File file = new File(filePath);

			var user = User.builder().
					id(null)
					.firstName("vivek")
					.dateOfBirth(LocalDateTime.now())
					.lastName("garg")
					.email("vgarg7900@gmail.com")
					.password("vgarg@123")
					.build();

			userRepo.save(user);

			var request = FileUploadRequest.builder()
					.file(file).email("vgarg7900@gmail.com")
					.alias("vayus1")
					.build();

			var resp = fileUploaderService.uploadFile(request);
			System.out.println(resp);
		};
	}

}
