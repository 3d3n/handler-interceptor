package com.example.httphandler.controller;

import org.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @PostMapping("hello")
    public ResponseEntity<?> test(@RequestParam("name") String name) {

        return new ResponseEntity<>("Hello " + name, HttpStatus.OK);

    }

    @PostMapping("json")
    public ResponseEntity<?> test2(@RequestBody String request) {

        System.out.println(request);

        JSONObject jsonObject = new JSONObject(request);
        jsonObject.put("status", "Done");

        System.out.println(jsonObject);

        return new ResponseEntity<>(jsonObject, HttpStatus.OK);

    }
}
