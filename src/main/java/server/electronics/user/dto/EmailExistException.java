package server.electronics.user.dto;

public class EmailExistException extends RuntimeException {
    public EmailExistException() {
        super("Email exist", null,false,false);
    }
}
