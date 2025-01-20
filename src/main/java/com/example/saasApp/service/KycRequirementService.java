package com.example.saasApp.service;

import com.example.saasApp.dto.Mapper;
import com.example.saasApp.dto.kycRequirementDTO.KycRequirementRequest;
import com.example.saasApp.dto.kycRequirementDTO.KycRequirementResponse;
import com.example.saasApp.model.KycRequirement;
import com.example.saasApp.repo.KycReqRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class KycRequirementService {

    private final KycReqRepo kycReqRepo;
    private final Mapper mapper;

    public KycRequirementResponse create(KycRequirementRequest kycRequirementRequest) {
        KycRequirement kycRequirement = new KycRequirement();
        kycRequirement.setKycLevelID(kycRequirementRequest.getKycLevelID());
//        kycRequirement.setId(kycRequirementRequest.getId());
        kycRequirement.setSequence(kycRequirementRequest.getSequence());
        kycRequirement.setFieldName(kycRequirementRequest.getFieldName());
        kycRequirement.setValidityPeriod(kycRequirementRequest.getValidityPeriod());

        kycReqRepo.save(kycRequirement);
        return mapper.mapKycRequirementToResponse(kycRequirement);
    }

    public List<KycRequirementResponse> getAll() {
        return kycReqRepo.findAll()
                .stream()
                .map(mapper::mapKycRequirementToResponse)
                .collect(Collectors.toList());
    }

    public KycRequirementResponse getById (@PathVariable Integer id){
        KycRequirement reqById = kycReqRepo.findById(id).orElseThrow(() -> new RuntimeException("not found"));
        return mapper.mapKycRequirementToResponse(reqById);
    }
    public KycRequirement update (@RequestBody KycRequirementRequest kycRequirementRequest){
        Integer id = kycRequirementRequest.getId();
        Integer kycLevelId = kycRequirementRequest.getKycLevelID();
        Integer sequence = kycRequirementRequest.getSequence();
        String fieldName = kycRequirementRequest.getFieldName();
        Integer validityPeriod = kycRequirementRequest.getValidityPeriod();

        KycRequirement existingKycRequirement = kycReqRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("id not found " + id));
        existingKycRequirement.setKycLevelID(kycLevelId);
        existingKycRequirement.setSequence(sequence);
        existingKycRequirement.setFieldName(fieldName);
        existingKycRequirement.setValidityPeriod(validityPeriod);

        kycReqRepo.save(existingKycRequirement);
        return existingKycRequirement;
    }

    public String delete(Integer id) {
        kycReqRepo.deleteById(id);
        return "deleted Successfully";
    }
}
