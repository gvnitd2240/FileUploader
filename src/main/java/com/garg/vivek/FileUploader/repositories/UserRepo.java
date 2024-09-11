package com.garg.vivek.FileUploader.repositories;

import com.garg.vivek.FileUploader.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepo  extends JpaRepository<User, Integer> {
    Optional<User> findByEmail(String email);
}
