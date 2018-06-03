package server.electronics.user.domain

import org.springframework.context.annotation.Bean
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import server.electronics.user.dto.EmailExistException
import server.electronics.user.dto.UserDto
import server.electronics.user.dto.UsernameExistException
import spock.lang.Specification

class UserSpec extends Specification implements SampleUsers{

    UserFacade userFacade = new UserConfiguration().userFacade()

    def "Should create account and save it do database" () {
        given:"We have user's data"
            UserDto mark = UserDto.builder()
                    .id(1l)
                    .password(passwordEncoder.encode("pass"))
                    .username("user")
                    .email("email")
                    .build()

        when:"We add user to system"
            userFacade.add(mark)
            List<UserDto> users = userFacade.findAll();

        then:"Saved data equals to created user's data"
            users.get(0).username == mark.username
            users.get(0).email == mark.email
            passwordEncoder.matches(mark.password, users.get(0).password)
    }

    def "Should throw UsernameExistsExpression" () {

        given:"We add one user to system"
            userFacade.add(mark)

        when:"We try to add another with same username"
            userFacade.add(markSameUsername)

        then:"We get an exception"
            thrown UsernameExistException
    }

    def "Should throw EmailExistsExpression" () {

        given:"We add one user to system"
            userFacade.add(mark)

        when:"We try to add another with same email"
             userFacade.add(markSameEmail)

        then:"We get an exception"
            thrown EmailExistException
    }


}
