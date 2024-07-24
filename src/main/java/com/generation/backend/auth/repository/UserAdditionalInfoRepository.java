package com.generation.backend.auth.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.generation.backend.auth.model.UserAdditionalInfo;

public interface UserAdditionalInfoRepository extends JpaRepository<UserAdditionalInfo, Integer>{
    public Optional<UserAdditionalInfo> findByUserId(Integer user_id);
}
