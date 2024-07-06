package com.devprobootcamp.dls.driver_license_service.model;

import com.devprobootcamp.dls.driver_license_service.constant.LicenseTypes;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
@Table(name = "driver_licenses")
public class DriverLicenseInfo {
    @Id
    private String licenseNumber;
    private String firstName;
    private String lastName;
    private String streetAddress;
    private String addressLine;
    private String city;
    private String state;
    private String zipCode;
    private LocalDate issuedDate;
    private LocalDate expirationDate;

    @Enumerated(EnumType.STRING)
    private LicenseTypes licenseType;
}
