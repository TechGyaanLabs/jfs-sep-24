package com.careerit.hw;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class MessageController {

        @GetMapping("/greet")
        public ResponseEntity<String> greet(){
            return ResponseEntity.ok("Hello World");
        }

        @GetMapping("/message")
        public ResponseEntity<String> message(){
            return ResponseEntity.ok("Welcome to Spring Boot");
        }

}
