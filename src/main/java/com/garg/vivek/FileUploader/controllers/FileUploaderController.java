package com.garg.vivek.FileUploader.controllers;

import com.garg.vivek.FileUploader.Utilities.Utils;
import com.garg.vivek.FileUploader.services.interfaces.FileUploaderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/upload")
public class FileUploaderController {

    private final FileUploaderService fileUploaderService;

    public FileUploaderController(FileUploaderService fileUploaderService) {
        this.fileUploaderService = fileUploaderService;
    }

    @GetMapping("/get-presigned-url")
    public ResponseEntity<String> getPreSignedUrl(@RequestParam String fileName) {
        var email = Utils.getEmailFromAuth();
        return fileUploaderService.getPreSignedUrl(fileName, email);
    }

    @GetMapping("/get-url")
    public ResponseEntity<String> getUrl(@RequestParam String fileName) {
        return fileUploaderService.getUrl(fileName);
    }

}
