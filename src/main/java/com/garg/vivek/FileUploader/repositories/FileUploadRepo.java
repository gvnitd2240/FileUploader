package com.garg.vivek.FileUploader.repositories;

import com.garg.vivek.FileUploader.entities.Uploads;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FileUploadRepo extends JpaRepository<Uploads, Integer> {
}
