package com.garg.vivek.FileUploader.models.requests;

import lombok.Builder;
import lombok.Data;
import software.amazon.awssdk.services.s3.endpoints.internal.Value;

import java.io.File;
import java.util.UUID;

@Data
@Builder
public class FileUploadRequest {
    private File file;
    private String email;
    private String alias;
}
