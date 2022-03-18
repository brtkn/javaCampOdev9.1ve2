package kodlamaio.hrms.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

import kodlamaio.hrms.core.utilities.adapters.abstracts.CloudinaryService;
import kodlamaio.hrms.core.utilities.adapters.concretes.CloudinaryManager;

@Configuration
public class CloudinaryConfig {
	
	
	@Bean
	public Cloudinary cloudinaryAccount() {
		
		 return new Cloudinary(ObjectUtils.asMap(
				 "cloud_name", "dzptxumto",
				 "api_key", "658317198628792",
				 "api_secret", "LUg3ozS5xlDe-LlgODha_Gqnodg"
				));
	}
	
	//CloudinaryManager i consturcterina yollayip yapmis, icinde yazmaya gerek kalmiyor boylece manager da.
	@Bean
	public CloudinaryService cloudinaryService() {
		return new CloudinaryManager(cloudinaryAccount());
	}
}
