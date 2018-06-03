package server.electronics.user.domain;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import server.electronics.user.dto.EmailExistException;
import server.electronics.user.dto.UserDto;
import server.electronics.user.dto.UsernameExistException;

@NoArgsConstructor
@AllArgsConstructor
class UserCreator {

    private Validator validator;
    private RoleRepository roleRepository;
    private PasswordEncoder passwordEncoder;


    User from(UserDto userDto)  {

        if(validator.usernameExists(userDto)){
            throw new UsernameExistException();
        }

        if (validator.emailExists(userDto)){
            throw new EmailExistException();
        }

        Role role = Role.builder()
                .roleId(2)
                .name("ROLE_USER")
                .build();

        User user = new User(userDto.getId(),userDto.getUsername(),
                passwordEncoder.encode(userDto.getPassword()), userDto.getEmail());

        user.getUserRoles().add(new UserRole(user, role));

        roleRepository.save(role);

        return user;
    }
}
