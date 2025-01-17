package com.example.saasApp.repo;

import com.example.saasApp.model.KycRequirement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KycReqRepo extends JpaRepository<KycRequirement,Integer> {
}
