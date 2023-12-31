package co.odin.senapi.exception;

import co.odin.senapi.base.BaseError;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ApiException {
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(ResponseStatusException.class)
    public BaseError<?> handleServiceException(ResponseStatusException e){

        return BaseError.builder()
                .status(false)
                .code(e.getStatusCode().value())
                .timestamp(LocalDateTime.now())
                .message("sth went wrong...!, please check")
                .errors(e.getReason())
                .build();
    }


    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public BaseError<Object> handleValidationException(MethodArgumentNotValidException e){
        var errors  = new ArrayList<>();
//        var errorDetails = new HashMap<>();
//        Map<String, String> errorDetails = new HashMap<>();
        for (FieldError error : e.getFieldErrors()){
            Map<String ,String> errorDetails = new HashMap<>();
            errorDetails.put("name", error.getField());
            errorDetails.put("message", error.getDefaultMessage());
            errors.add(errorDetails);
        }
        return BaseError.builder()
                .status(false)
                .code(HttpStatus.BAD_REQUEST.value())
                .timestamp(LocalDateTime.now())
                .message("Validation is error, please check detail messages!")
                .errors(errors)
                .build();
    }
}
