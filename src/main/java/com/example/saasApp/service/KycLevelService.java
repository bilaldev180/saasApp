package com.example.saasApp.service;

import com.example.saasApp.dto.Mapper;
import com.example.saasApp.dto.kycLevelResponseDto.KycLevelRequest;
import com.example.saasApp.dto.kycLevelResponseDto.KycResponse;
import com.example.saasApp.enums.KycLevelName;
import com.example.saasApp.model.KycLevel;
import com.example.saasApp.repo.KycLevelRepo;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class KycLevelService {

    private final KycLevelRepo kycLevelRepo;
    private final Mapper mapper;

    public KycResponse createKycLevel(KycLevelRequest kycLevelRequest) {
        KycLevel kycLevel = new KycLevel();
        kycLevel.setKycLevelName(kycLevelRequest.getKycLevelName());
        kycLevel.setSequence(Integer.valueOf(kycLevelRequest.getSequence()));

        kycLevelRepo.save(kycLevel);
        return mapper.mapKycLevelToResponse(kycLevel);
    }

    public List<KycResponse> getAllKycLevel(){
        return kycLevelRepo.findAll()
                .stream()
                .map(mapper::mapKycLevelToResponse)
                .collect(Collectors.toList());
    }

    public KycResponse getKycLevelById(int id) {
        KycLevel findById =  kycLevelRepo.findById(id).orElseThrow(() -> new EntityNotFoundException("ID not found" + id));
        return mapper.mapKycLevelToResponse(findById);
    }
    public KycLevel updateKycLevel(KycLevelRequest kycLevelRequest) {

        KycLevelName kycLevelName = kycLevelRequest.getKycLevelName();
        Integer kycLevelId = kycLevelRequest.getId();
        Integer sequence = Integer.valueOf(kycLevelRequest.getSequence());

        KycLevel existingKycLevel = kycLevelRepo.findById(kycLevelId).orElseThrow(() -> new EntityNotFoundException("Not found."));

        existingKycLevel.setKycLevelName(kycLevelName);
        existingKycLevel.setSequence(sequence);
        kycLevelRepo.save(existingKycLevel);
        return existingKycLevel;
    }

    public void deleteKycLevel(Integer id) {
        kycLevelRepo.deleteById(id);
    }
}
