package server.electronics.user;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Collections;
import java.util.Map;

@RestController
class LoginController {

    @GetMapping("/admin/token")
    public Map<String, String> tokenAdmin(HttpSession session, HttpServletRequest request) {

        if (request.isUserInRole("ROLE_ADMIN")) {
            return Collections.singletonMap("token", session.getId());
        }
        return (Map<String, String>) new ResponseEntity(HttpStatus.UNAUTHORIZED);
    }

    @RequestMapping("/user/token")
    public Map<String, String> token(HttpSession session, HttpServletRequest request) {

        if (request.isUserInRole("ROLE_USER")) {
            return Collections.singletonMap("token", session.getId());
        }
        return (Map<String, String>) new ResponseEntity(HttpStatus.UNAUTHORIZED);
    }


    @GetMapping("admin/verifySession")
    public ResponseEntity checkSession() {
        return new ResponseEntity("Session Active!", HttpStatus.OK);
    }

    @PostMapping(value="/admin/logout")
    public ResponseEntity logout(){
        SecurityContextHolder.clearContext();
        return new ResponseEntity("Logout Successfully!", HttpStatus.OK);
    }
}