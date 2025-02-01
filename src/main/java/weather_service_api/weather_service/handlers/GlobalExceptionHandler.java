package weather_service_api.weather_service.handlers;

import jakarta.persistence.EntityNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.server.ResponseStatusException;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {
    @ExceptionHandler(EntityNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorMessage handleEntityNotFound(EntityNotFoundException e) {
        log.error("Entity Not Found", e);
        return new ErrorMessage("Entity Not Found", e.getMessage());
    }

    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorMessage handleVacancyCreation(IllegalArgumentException exception) {
        log.error("Illegal Argument Error: {}", exception.getMessage());
        return new ErrorMessage("Illegal Argument Error: {}", exception.getMessage());
    }

    @ExceptionHandler(ResponseStatusException.class)
    public ResponseEntity<Map<String, String>> handleResponseStatusException(ResponseStatusException ex) {
        Map<String, String> errorResponse = new HashMap<>();
        errorResponse.put("message", ex.getReason());
        return new ResponseEntity<>(errorResponse, ex.getStatusCode());
    }

    @ExceptionHandler(UsernameNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorMessage handleUsernameNotFoundException(UsernameNotFoundException exception) {
        log.error("Username not found Error: {}", exception.getMessage());
        return new ErrorMessage("Username not found Error: {}", exception.getMessage());
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorMessage handleException(Exception exception) {
        log.error("Global Exception Error: {}", exception.getMessage());
        return new ErrorMessage("Global Exception Error: {}", exception.getMessage());
    }

    @ExceptionHandler(InterruptedException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorMessage handleInterruptedException(InterruptedException exception) {
        log.error("Global Exception Error: {}", exception.getMessage());
        return new ErrorMessage("Global Exception Error: {}", exception.getMessage());
    }
}