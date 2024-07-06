package com.devprobootcamp.dls.driver_license_service.service;

import com.devprobootcamp.dls.driver_license_service.dto.DriveLicenseInfoDTO;

import java.util.List;

public interface DriverLicenseService {

    void createDriveLicenseInfo(DriveLicenseInfoDTO driveLicenseInfoDTO);
    List<DriveLicenseInfoDTO> searchByName(String firstName, String lastName);
}
