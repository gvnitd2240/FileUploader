package com.garg.vivek.FileUploader.services.implementations;

import com.garg.vivek.FileUploader.Utilities.S3Service;
import com.garg.vivek.FileUploader.entities.Uploads;
import com.garg.vivek.FileUploader.models.requests.FileUploadRequest;
import com.garg.vivek.FileUploader.repositories.FileUploadRepo;
import com.garg.vivek.FileUploader.repositories.UserRepo;
import com.garg.vivek.FileUploader.services.interfaces.FileUploaderService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class FileUplaoderServiceImpl implements FileUploaderService {

    @Autowired private final S3Service s3Service;
    @Autowired private final UserRepo userRepo;

    @Autowired private final FileUploadRepo fileUploadRepo;

    @Override
    public String getPreSignedUrl(String fileName, String email) {
        return s3Service.generatePresignedUrl(fileName);
    }

    @Override
    public String getUrl(String fileName) {
        return s3Service.getUrl(fileName);
    }

    @Override
    public String uploadFile(FileUploadRequest request) {
       try{
           //check if user is valid
           var user = userRepo.findByEmail(request.getEmail())
                   .orElseThrow(() -> new UsernameNotFoundException("user not found."));

           //check for user has space available. //check for plan
           var file = request.getFile();
           if (!file.exists() || file.isDirectory()) {
               return "Invalid file path or file is a directory";
           }

           String fileName = file.getName();

           s3Service.putObject(file);
           var fileUrl = s3Service.getUrl(fileName);

           var uploadFile = Uploads.builder().fileUrl(fileUrl)
                   .fileName(fileName)
                   .id(null)
                   .alias(request.getAlias())
                   .user(user)
                   .uploadTime(LocalDateTime.now())
                   .size(file.length() / 1024)
                           .build();

           fileUploadRepo.save(uploadFile);

           return fileUrl;
       } catch (Exception e){
           throw e;
       }
    }
}
