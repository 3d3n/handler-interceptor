package com.example.httphandler.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @PostMapping("hello")
    public ResponseEntity<?> test(@RequestParam("name") String name) {

        return new ResponseEntity<>("Hello " + name, HttpStatus.OK);

    }
}
