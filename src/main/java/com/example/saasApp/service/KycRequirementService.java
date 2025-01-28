package com.example.saasApp.service;

import com.example.saasApp.dto.Mapper;
import com.example.saasApp.dto.kycRequirementDTO.KycRequirementRequest;
import com.example.saasApp.dto.kycRequirementDTO.KycRequirementResponse;
import com.example.saasApp.model.KycLevel;
import com.example.saasApp.model.KycRequirement;
import com.example.saasApp.repo.KycLevelRepo;
import com.example.saasApp.repo.KycReqRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class KycRequirementService {

    private final KycReqRepo kycReqRepo;
    private final Mapper mapper;
    private final KycLevelRepo kycLevelRepo;

    /**
     * Creates a new KYC Requirement and associates it with a KYC Level.
     */
    public KycRequirementResponse create(KycRequirementRequest kycRequirementRequest) {
        KycLevel level = kycLevelRepo.findById(kycRequirementRequest.getKycLevelId())
                .orElseThrow(() -> new RuntimeException("KYC level not found"));

        KycRequirement kycRequirement = new KycRequirement();
        kycRequirement.setKycLevel(level);
        kycRequirement.setFieldName(kycRequirementRequest.getFieldName());
        kycRequirement.setValidityPeriod(kycRequirementRequest.getValidityPeriod());
        kycRequirement.setMandatory(kycRequirementRequest.getIsMandatory());
        kycRequirement.setFieldType(kycRequirementRequest.getFieldType());

        kycReqRepo.save(kycRequirement);

        return mapper.mapKycRequirementToResponse(kycRequirement);
    }

    /**
     * Retrieves all KYC Requirements.
     *
     * @return List of KYC Requirement response DTOs.
     */
    public List<KycRequirementResponse> getAll() {
        return kycReqRepo.findAll()
                .stream()
                .map(mapper::mapKycRequirementToResponse)
                .collect(Collectors.toList());
    }

    /**
     * Retrieves a KYC Requirement by its ID.
     *
     * @param id The ID of the KYC Requirement.
     * @return The KYC Requirement as a response DTO.
     */
    public KycRequirementResponse getById(Integer id) {
        KycRequirement kycRequirement = kycReqRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("KYC Requirement not found with ID: " + id));
        return mapper.mapKycRequirementToResponse(kycRequirement);
    }

    /**
     * Updates an existing KYC Requirement.
     *
     * @param kycRequirementRequest Request containing updated KYC Requirement details.
     * @return The updated KYC Requirement as a response DTO.
     */
    public KycRequirementResponse update(KycRequirementRequest kycRequirementRequest) {
        KycRequirement existingKycRequirement = kycReqRepo.findById(kycRequirementRequest.getId())
                .orElseThrow(() -> new RuntimeException("KYC Requirement not found with ID: " + kycRequirementRequest.getId()));

        existingKycRequirement.setFieldName(kycRequirementRequest.getFieldName());
        existingKycRequirement.setValidityPeriod(kycRequirementRequest.getValidityPeriod());
        existingKycRequirement.setMandatory(kycRequirementRequest.getIsMandatory());
        existingKycRequirement.setFieldType(kycRequirementRequest.getFieldType());

        kycReqRepo.save(existingKycRequirement);

        return mapper.mapKycRequirementToResponse(existingKycRequirement);
    }

    /**
     * Deletes a KYC Requirement by its ID.
     *
     * @param id The ID of the KYC Requirement to delete.
     * @return A success message upon deletion.
     */
    public String delete(Integer id) {
        if (!kycReqRepo.existsById(id)) {
            throw new RuntimeException("KYC Requirement not found with ID: " + id);
        }
        kycReqRepo.deleteById(id);
        return "KYC Requirement deleted successfully.";
    }
}
