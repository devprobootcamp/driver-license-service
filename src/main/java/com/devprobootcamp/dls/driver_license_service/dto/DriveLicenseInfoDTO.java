package com.devprobootcamp.dls.driver_license_service.dto;

import com.devprobootcamp.dls.driver_license_service.constant.LicenseTypes;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;

@Data
public class DriveLicenseInfoDTO {

    @NotBlank(message = "License number required")
    private String licenseNumber;

    @NotBlank(message = "First name required")
    private String firstName;

    @NotBlank(message = "Last name required")
    private String lastName;

    @NotBlank(message = "Street Address required")
    private String streetAddress;

    @NotBlank(message = "Address Line required")
    private String addressLine;

    @NotBlank(message = "City required")
    private String city;

    @NotBlank(message = "State required")
    private String state;

    @NotBlank(message = "State required")
    private String zipCode;

    @NotNull(message = "issuedDate is required")
    private LocalDate issuedDate;

    @NotNull(message = "expirationDate is required")
    private LocalDate expirationDate;

    @NotNull(message = "licenseType is required")
    private LicenseTypes licenseType;
}
