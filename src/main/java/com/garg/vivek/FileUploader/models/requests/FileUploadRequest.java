package com.garg.vivek.FileUploader.models.requests;

import lombok.Builder;
import lombok.Data;

import java.io.File;

@Data
@Builder
public class FileUploadRequest {
  private File file;
  private String email;
  private String alias;
}
