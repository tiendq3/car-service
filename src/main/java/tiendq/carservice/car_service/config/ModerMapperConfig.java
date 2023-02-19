package tiendq.carservice.car_service.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModerMapperConfig {
    @Bean
    public ModelMapper moderMapper() {
        return new ModelMapper();
    }
}
