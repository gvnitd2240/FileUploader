package com.garg.vivek.FileUploader.services.interfaces;

import com.garg.vivek.FileUploader.models.requests.FileUploadRequest;
import org.springframework.http.ResponseEntity;

public interface FileUploaderService {

    String getPreSignedUrl(String fileName, String email);
    String getUrl(String fileName);

    String uploadFile(FileUploadRequest request);
}
