package com.garg.vivek.FileUploader.controllers;

import com.garg.vivek.FileUploader.Utilities.Utils;
import com.garg.vivek.FileUploader.models.requests.FileUploadRequest;
import com.garg.vivek.FileUploader.services.interfaces.FileUploaderService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/upload")
@RequiredArgsConstructor
public class FileUploaderController {

    @Autowired
    private final FileUploaderService fileUploaderService;

    @GetMapping("/get-presigned-url")
    public ResponseEntity<String> getPreSignedUrl(@RequestParam String fileName) {
        var email = Utils.getEmailFromAuth();
        return ResponseEntity.ok(fileUploaderService.getPreSignedUrl(fileName, email));
    }

    @GetMapping("/get-url")
    public ResponseEntity<String> getUrl(@RequestParam String fileName) {
        return ResponseEntity.ok(fileUploaderService.getUrl(fileName));
    }

    @PostMapping
    public ResponseEntity<String> uploadFile(@Valid @RequestBody FileUploadRequest request) {
        return ResponseEntity.ok(fileUploaderService.uploadFile(request));
    }

}
