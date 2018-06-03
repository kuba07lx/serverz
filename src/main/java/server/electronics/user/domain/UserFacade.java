package server.electronics.user.domain;

import org.springframework.security.core.userdetails.UserDetailsService;
import server.electronics.user.dto.UserDto;
import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Objects.requireNonNull;

@Transactional
public class UserFacade {

    private UserRepository userRepository;
    private RoleRepository roleRepository;
    private UserCreator userCreator;

    public UserFacade(UserRepository userRepository, UserCreator userCreator, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.userCreator = userCreator;
    }

    public UserDto add(UserDto userDto) throws Exception{
        requireNonNull(userDto);
        User user = userCreator.from(userDto);
        userRepository.save(user);

        return user.dto();
    }

    public List<UserDto> findAll(){
        return userRepository.findAll().stream()
                .map(e -> e.dto())
                .collect(Collectors.toList());
    }
}
