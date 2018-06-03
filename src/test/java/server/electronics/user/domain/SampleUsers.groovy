package server.electronics.user.domain

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import server.electronics.user.dto.UserDto

trait SampleUsers {
    static PasswordEncoder passwordEncoder = new BCryptPasswordEncoder()

    UserDto mark = createUserDto(1l, "mark123", "password123", "mark123@gmail.com")
    UserDto markSameEmail = createUserDto(2l, "marko", "password123", "mark123@gmail.com")
    UserDto markSameUsername = createUserDto(3l, "mark123", "password123", "mark12345@gmail.com")
    UserDto tony = createUserDto(4l, "tony123", "password123", "tony123@gmail.com")

    static private UserDto createUserDto(Long id, String username, String password, String email){
        return UserDto.builder()
                .id(id)
                .username(username)
                .password(passwordEncoder.encode(password))
                .email(email)
                .build()
    }

}