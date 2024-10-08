package com.garg.vivek.FileUploader.entities;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(name = "uploads", schema = "file_uploads")
@Builder
@Data
public class Uploads {
    @Id
    @GeneratedValue
    private Integer id;
    private String fileName;
    private Long size;
    private String alias;
    private String fileUrl;
    private LocalDateTime uploadTime;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
