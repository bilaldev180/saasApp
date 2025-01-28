package com.example.saasApp.service;

import com.example.saasApp.model.Customer;
import com.example.saasApp.model.KycLevel;
import com.example.saasApp.model.KycRequirement;
import com.example.saasApp.repo.CustomerRepo;
import com.example.saasApp.repo.KycLevelRepo;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class KycService {

    private final CustomerRepo customerRepository;
    private final KycLevelRepo kycLevelRepo;

    /**
     * Validates if a customer satisfies all the requirements of their assigned KYC level.
     *
     * @param customerId the ID of the customer to validate.
     * @return a ValidationResult containing validation status and details.
     */
    public ValidationResult validateCustomerKyc(long customerId) {
        Customer customer = customerRepository.findById(customerId)
                .orElseThrow(() -> new IllegalArgumentException("Customer not found"));

        // Check if the customer has an assigned KYC level
        if (customer.getKycLevel() == null) {
            return new ValidationResult(false, "No KYC level assigned to the customer.");
        }

        List<KycRequirement> requirements = customer.getKycLevel().getRequirements();

        // Validate requirements
        List<String> missingRequirements = requirements.stream()
                .filter(KycRequirement::isMandatory)
                .map(KycRequirement::getFieldName)
                .filter(requirement -> !isRequirementSatisfied(customer, requirement))
                .toList();

        if (!missingRequirements.isEmpty()) {
            return new ValidationResult(false, "Missing requirements: " + missingRequirements);
        }

        return new ValidationResult(true, "All requirements satisfied.");
    }

    /**
     * Checks if a specific requirement is satisfied for the given customer.
     *
     * @param customer    the customer to check.
     * @param requirement the name of the requirement to validate.
     * @return true if the requirement is satisfied, false otherwise.
     */
    private boolean isRequirementSatisfied(Customer customer, String requirement) {
        // Example validation logic, update this as per the actual requirement.
        return switch (requirement.toLowerCase()) {
            case "email" -> customer.getEmail() != null && !customer.getEmail().isEmpty();
            case "phone" -> customer.getPhone() > 0;
            case "address" -> customer.getAddress() != null && !customer.getAddress().isEmpty();
            default -> false; // Requirement not satisfied
        };
    }

    /**
         * Represents the result of a KYC validation operation.
         */
        public record ValidationResult(boolean isValid, @Getter String message) {

    }

    public Customer assignKycLevelToCustomer(long customerId, int kycLevelId) {
        // Fetch the customer
        Customer customer = customerRepository.findById(customerId)
                .orElseThrow(() -> new IllegalArgumentException("Customer not found"));

        // Fetch the KYC level
        KycLevel kycLevel = kycLevelRepo.findById(kycLevelId)
                .orElseThrow(() -> new IllegalArgumentException("KYC Level not found"));

        // Assign the KYC level to the customer
        customer.setKycLevel(kycLevel);

        // Save and return the updated customer
        return customerRepository.save(customer);
    }
}
