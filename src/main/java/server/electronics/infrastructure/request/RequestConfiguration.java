package server.electronics.infrastructure.request;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class RequestConfiguration {

    @Bean
    RequestFilter requestFilter(){
        return new RequestFilter();
    }
}
