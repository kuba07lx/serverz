package server.electronics.user.dto;

public class UsernameExistException extends RuntimeException {
    public UsernameExistException() {
        super("Username exist", null,false,false);
    }
}
