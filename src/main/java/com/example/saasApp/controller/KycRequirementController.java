package com.example.saasApp.controller;

import com.example.saasApp.dto.kycRequirementDTO.KycRequirementRequest;
import com.example.saasApp.dto.kycRequirementDTO.KycRequirementResponse;
import com.example.saasApp.service.KycRequirementService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/kyc-requirements")
@RequiredArgsConstructor
public class KycRequirementController {

    private final KycRequirementService kycRequirementService;

    /**
     * Create a new KYC Requirement and assign it to a KYC Level.
     *
     * @param kycRequirementRequest Request payload for creating a KYC Requirement.
     * @return The created KYC Requirement as a response DTO.
     */
    @PostMapping ("/create")
    public ResponseEntity<KycRequirementResponse> createRequirement(
            @RequestBody KycRequirementRequest kycRequirementRequest) {
        KycRequirementResponse response = kycRequirementService.create(kycRequirementRequest);
        return ResponseEntity.ok(response);
    }

    /**
     * Retrieve all KYC Requirements.
     *
     * @return A list of KYC Requirement response DTOs.
     */
    @GetMapping ("/")
    public ResponseEntity<List<KycRequirementResponse>> getAllRequirements() {
        List<KycRequirementResponse> responseList = kycRequirementService.getAll();
        return ResponseEntity.ok(responseList);
    }

    /**
     * Retrieve a KYC Requirement by its ID.
     *
     * @param id The ID of the KYC Requirement.
     * @return The KYC Requirement as a response DTO.
     */
    @GetMapping("/{id}")
    public ResponseEntity<KycRequirementResponse> getRequirementById(@PathVariable Integer id) {
        KycRequirementResponse response = kycRequirementService.getById(id);
        return ResponseEntity.ok(response);
    }

    /**
     * Update an existing KYC Requirement.
     *
     * @param kycRequirementRequest Request payload containing updated details.
     * @return The updated KYC Requirement as a response DTO.
     */
    @PutMapping ("/update")
    public ResponseEntity<KycRequirementResponse> updateRequirement(
            @RequestBody KycRequirementRequest kycRequirementRequest) {
        KycRequirementResponse response = kycRequirementService.update(kycRequirementRequest);
        return ResponseEntity.ok(response);
    }

    /**
     * Delete a KYC Requirement by its ID.
     *
     * @param id The ID of the KYC Requirement to delete.
     * @return A success message upon deletion.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteRequirement(@PathVariable Integer id) {
        String message = kycRequirementService.delete(id);
        return ResponseEntity.ok(message);
    }
}
