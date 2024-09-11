package com.garg.vivek.FileUploader.services.interfaces;

import com.garg.vivek.FileUploader.Utilities.S3Service;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FileUploaderService {
    private final S3Service s3Service;

    @Value("${aws.s3.bucket}")
    private String bucketName;
    @Value("${aws.region}")
    private String region;

    public ResponseEntity<String> getPreSignedUrl(String fileName, String email) {
        //check if he has limit to upload file and then if he has then let him upload else redirect for paid plans.
        return ResponseEntity.ok(s3Service.generatePresignedUrl(fileName));
    }
    public ResponseEntity<String> getUrl(String fileName) {
        return ResponseEntity.ok(String.format("https://%s.s3.%s.amazonaws.com/%s", bucketName, region, fileName));
    }
}
