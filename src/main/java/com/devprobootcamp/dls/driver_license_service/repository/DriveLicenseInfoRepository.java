package com.devprobootcamp.dls.driver_license_service.repository;

import com.devprobootcamp.dls.driver_license_service.model.DriverLicenseInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface DriveLicenseInfoRepository extends JpaRepository<DriverLicenseInfo, String> {

    Optional<DriverLicenseInfo> findByLicenseNumber(String licenseNumber);
    List<DriverLicenseInfo> findByFirstNameLikeOrLastNameLike(String firstName, String lastName);

}
