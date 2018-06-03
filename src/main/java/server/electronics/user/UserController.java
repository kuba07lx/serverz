package server.electronics.user;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import server.electronics.user.domain.UserFacade;
import server.electronics.user.dto.UserDto;

import javax.xml.ws.Response;

@RestController
@RequestMapping("/user")
class UserController {

    private UserFacade userFacade;

    public UserController(UserFacade userFacade) {
        this.userFacade = userFacade;
    }

    @PostMapping("/add")
    public ResponseEntity createUser(@RequestBody UserDto userDto) throws Exception{

        userFacade.add(userDto);

        return new ResponseEntity("User created", HttpStatus.OK);
    }

    @PostMapping("/passwordRecovery")
    public ResponseEntity recoverPassword(@RequestBody String email){

       // userFacade.recoverPassword(email);

        return new ResponseEntity("Email sent", HttpStatus.OK);
    }
}
