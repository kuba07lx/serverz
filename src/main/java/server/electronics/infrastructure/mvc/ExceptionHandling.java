package server.electronics.infrastructure.mvc;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import server.electronics.product.dto.ProductNotFoundException;
import server.electronics.user.dto.EmailExistException;
import server.electronics.user.dto.UsernameExistException;

import javax.validation.constraints.Email;

@ControllerAdvice
class ExceptionHandling {

    @ExceptionHandler(ProductNotFoundException.class)
    ResponseEntity handleNotFoundProduct(ProductNotFoundException ex){
        return new ResponseEntity(ex.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(UsernameExistException.class)
    ResponseEntity handleUsernameExist(UsernameExistException ex){
        return new ResponseEntity(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(EmailExistException.class)
    ResponseEntity handleEmailExist(EmailExistException ex) {
        return new ResponseEntity(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }
}
