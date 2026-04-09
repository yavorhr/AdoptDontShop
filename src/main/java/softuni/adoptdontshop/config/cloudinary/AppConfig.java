package softuni.adoptdontshop.config.cloudinary;

import com.cloudinary.Cloudinary;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import softuni.adoptdontshop.config.CloudinaryConfig;

import java.util.Map;

@Configuration
@EnableTransactionManagement
public class AppConfig {
  private final CloudinaryConfig config;

  public AppConfig(CloudinaryConfig config) {
    this.config = config;
  }

  @Bean
  public Cloudinary cloudinary() {
    return new Cloudinary(
            Map.of(
                    "cloud_name", config.getCloudName(),
                    "api_key", config.getApiKey(),
                    "api_secret", config.getApiSecret()
            )
    );
  }
}