package nl.spaan.demo_springjpa.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class MainController {


        @GetMapping(value = "/")
        public ResponseEntity<Object> sayHello() {
            return new ResponseEntity<>("Hello from demo_spring_jpa", HttpStatus.OK);
        }

}
