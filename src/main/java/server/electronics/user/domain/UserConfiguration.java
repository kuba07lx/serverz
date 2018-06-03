package server.electronics.user.domain;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
class UserConfiguration {

    UserFacade userFacade(){
        return userFacade(new InMemoryUserRepository(),new InMemoryRoleRepository());
    }

    @Bean
    UserFacade userFacade(UserRepository userRepository , RoleRepository roleRepository){

        Validator validator = new ValidatorImpl(userRepository);
        UserCreator userCreator = new UserCreator(validator, roleRepository, passwordEncoder());
        return new UserFacade(userRepository, userCreator,roleRepository);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

}
