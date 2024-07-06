package com.devprobootcamp.dls.driver_license_service.controller;

import com.devprobootcamp.dls.driver_license_service.dto.DriveLicenseInfoDTO;
import com.devprobootcamp.dls.driver_license_service.service.DriverLicenseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/license/api")
@RequiredArgsConstructor
public class DriverLicenseController {

    private final DriverLicenseService driverLicenseService;

    @PostMapping("/create")
    public ResponseEntity<Void> createLicense(@RequestBody @Validated DriveLicenseInfoDTO driveLicenseInfoDTO) {
        driverLicenseService.createDriveLicenseInfo(driveLicenseInfoDTO);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/search")
    public ResponseEntity<List<DriveLicenseInfoDTO>> createLicense(@RequestParam(value = "fn", required = false) String firstName, @RequestParam(value = "ln", required = false) String lastName) {
        return ResponseEntity.ok(driverLicenseService.searchByName(firstName, lastName));
    }
}
