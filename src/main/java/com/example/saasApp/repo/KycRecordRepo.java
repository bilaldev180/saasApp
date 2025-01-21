package com.example.saasApp.repo;

import com.example.saasApp.model.KycRecord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KycRecordRepo extends JpaRepository <KycRecord, Integer> {
}
