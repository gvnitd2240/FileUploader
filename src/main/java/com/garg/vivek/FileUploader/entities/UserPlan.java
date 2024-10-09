package com.garg.vivek.FileUploader.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Data;

@Entity
@Table(name = "user_plans", schema = "file_uploads")
@Builder
@Data
public class UserPlan {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

//    @OneToOne
//    @JoinColumn(name = "user_id", unique = true)
//    private User user;
}
