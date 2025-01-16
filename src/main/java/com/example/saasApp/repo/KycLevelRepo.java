package com.example.saasApp.repo;

import com.example.saasApp.model.KycLevel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KycLevelRepo extends JpaRepository<KycLevel,Integer> {
}
