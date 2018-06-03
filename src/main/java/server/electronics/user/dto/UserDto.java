package server.electronics.user.dto;

import lombok.*;
@AllArgsConstructor
@Builder
@Getter
@NoArgsConstructor
@EqualsAndHashCode
public class UserDto {

    private Long id;
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
}
