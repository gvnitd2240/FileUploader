package com.garg.vivek.FileUploader.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tokens", schema = "file_uploads")
public class Token {
  @Id
  @GeneratedValue
  private Integer id;
  private String token;
  private LocalDateTime createdAt;
  private LocalDateTime expiresAt;
  private LocalDateTime validatedAt;

  @ManyToOne
  @JoinColumn(name = "userId", nullable = false)
  private User user;
}

