package com.garg.vivek.FileUploader.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/demo")
@RequiredArgsConstructor
public class DemoController {
    public ResponseEntity<String> sayHello(){
        return ResponseEntity.ok("hello world!");
    }
}
