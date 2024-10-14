package com.garg.vivek.FileUploader.controllers;

import com.garg.vivek.FileUploader.Utilities.Utils;
import com.garg.vivek.FileUploader.models.requests.FileUploadRequest;
import com.garg.vivek.FileUploader.services.interfaces.FileUploaderService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/upload")
@RequiredArgsConstructor
@Tag(name = "File Merger", description = "Controller to upload files and get URLs")
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
