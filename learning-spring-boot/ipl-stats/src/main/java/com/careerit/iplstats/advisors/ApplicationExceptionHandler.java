package com.careerit.iplstats.advisors;

import com.careerit.iplstats.exception.TeamAlreadyExistsException;
import com.careerit.iplstats.util.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Set;

@ControllerAdvice
public class ApplicationExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler({TeamAlreadyExistsException.class})
    public ResponseEntity<ApiResponse<String>> handleException(TeamAlreadyExistsException e){
        String message = e.getMessage();
        ApiResponse<String> response = ApiResponse.failure(Set.of(message));
        return ResponseEntity.badRequest().body(response);
    }
}
