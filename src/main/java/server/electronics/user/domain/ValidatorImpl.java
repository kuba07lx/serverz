package server.electronics.user.domain;

import lombok.NoArgsConstructor;
import server.electronics.user.dto.UserDto;

@NoArgsConstructor
class ValidatorImpl implements Validator<UserDto>{

    private UserRepository userRepository;

    public ValidatorImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public boolean usernameExists(UserDto userDto) {
        return userRepository.existsByUsername(userDto.getUsername());
    }

    @Override
    public boolean emailExists(UserDto userDto) {
        return userRepository.existsByEmail(userDto.getEmail());
    }
}
