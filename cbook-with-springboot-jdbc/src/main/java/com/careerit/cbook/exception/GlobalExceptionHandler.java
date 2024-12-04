package com.careerit.cbook.exception;

import com.careerit.cbook.response.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ContactAlreadyExistsException.class)
    public ResponseEntity<ApiResponse<String>> handleContactAlreadyExistsException(ContactAlreadyExistsException ex){
        ApiResponse<String> apiResponse = new ApiResponse<>();
        apiResponse.addError(ex.getMessage());
        return ResponseEntity.status(HttpStatus.CONFLICT).body(apiResponse);
    }
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiResponse<String>> handleException(Exception ex){
        ApiResponse<String> apiResponse = new ApiResponse<>();
        apiResponse.addError(ex.getMessage());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(apiResponse);
    }

    @ExceptionHandler(ContactNotFoundException.class)
    public ResponseEntity<ApiResponse<String>> handleContactNotFoundException(ContactNotFoundException ex){
        ApiResponse<String> apiResponse = new ApiResponse<>();
        apiResponse.addError(ex.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(apiResponse);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ApiResponse<String>> handleIllegalArgumentException(IllegalArgumentException ex){
        ApiResponse<String> apiResponse = new ApiResponse<>();
        apiResponse.addError(ex.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(apiResponse);
    }





}
