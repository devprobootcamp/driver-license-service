package com.devprobootcamp.dls.driver_license_service.service;

import com.devprobootcamp.dls.driver_license_service.dto.DriveLicenseInfoDTO;
import com.devprobootcamp.dls.driver_license_service.exception.ResourceNotFoundException;
import com.devprobootcamp.dls.driver_license_service.model.DriverLicenseInfo;
import com.devprobootcamp.dls.driver_license_service.repository.DriveLicenseInfoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DriverLicenseServiceImpl implements DriverLicenseService {

    private final DriveLicenseInfoRepository driveLicenseInfoRepository;

//    @Autowired
//    public DriverLicenseServiceImpl(DriveLicenseInfoRepository driveLicenseInfoRepository) {
//        this.driveLicenseInfoRepository = driveLicenseInfoRepository;
//    }

    @Override
    public void createDriveLicenseInfo(DriveLicenseInfoDTO driveLicenseInfoDTO) {

        DriverLicenseInfo driverLicenseInfo = new DriverLicenseInfo();
        driverLicenseInfo.setLicenseNumber(driveLicenseInfoDTO.getLicenseNumber());
        driverLicenseInfo.setFirstName(driveLicenseInfoDTO.getFirstName());
        driverLicenseInfo.setLastName(driveLicenseInfoDTO.getLastName());
        driverLicenseInfo.setStreetAddress(driveLicenseInfoDTO.getStreetAddress());
        driverLicenseInfo.setAddressLine(driveLicenseInfoDTO.getAddressLine());
        driverLicenseInfo.setCity(driveLicenseInfoDTO.getCity());
        driverLicenseInfo.setState(driveLicenseInfoDTO.getState());
        driverLicenseInfo.setZipCode(driveLicenseInfoDTO.getZipCode());
        driverLicenseInfo.setIssuedDate(driveLicenseInfoDTO.getIssuedDate());
        driverLicenseInfo.setExpirationDate(driveLicenseInfoDTO.getExpirationDate());
        driverLicenseInfo.setLicenseType(driveLicenseInfoDTO.getLicenseType());

        driveLicenseInfoRepository.save(driverLicenseInfo);

    }

    @Override
    public List<DriveLicenseInfoDTO> searchByName(String firstName, String lastName) {
        List<DriverLicenseInfo> driverLicenses = driveLicenseInfoRepository.findByFirstNameLikeOrLastNameLike("%" + firstName + "%", "%" + lastName + "%");
        List<DriveLicenseInfoDTO> driveLicenseInfoDTOS = new ArrayList<>();
        for (DriverLicenseInfo dl : driverLicenses) {
            DriveLicenseInfoDTO driverLicenseInfoDTO = new DriveLicenseInfoDTO();
            driverLicenseInfoDTO.setLicenseNumber(dl.getLicenseNumber());
            driverLicenseInfoDTO.setFirstName(dl.getFirstName());
            driverLicenseInfoDTO.setLastName(dl.getLastName());
            driverLicenseInfoDTO.setStreetAddress(dl.getStreetAddress());
            driverLicenseInfoDTO.setAddressLine(dl.getAddressLine());
            driverLicenseInfoDTO.setCity(dl.getCity());
            driverLicenseInfoDTO.setState(dl.getState());
            driverLicenseInfoDTO.setZipCode(dl.getZipCode());
            driverLicenseInfoDTO.setIssuedDate(dl.getIssuedDate());
            driverLicenseInfoDTO.setExpirationDate(dl.getExpirationDate());
            driverLicenseInfoDTO.setLicenseType(dl.getLicenseType());
            driveLicenseInfoDTOS.add(driverLicenseInfoDTO);
        }
        return driveLicenseInfoDTOS;
    }

    @Override
    public DriveLicenseInfoDTO getLicenseNumber(String driverLicenseNumber) {
        Optional<DriverLicenseInfo> licenseInfoOptional = driveLicenseInfoRepository.findByLicenseNumber(driverLicenseNumber);
        if(licenseInfoOptional.isEmpty()){
            throw new ResourceNotFoundException("No License number");
        }

        DriverLicenseInfo driverLicenseInfo = licenseInfoOptional.get();

        DriveLicenseInfoDTO driverLicenseInfoDTO = new DriveLicenseInfoDTO();
        driverLicenseInfoDTO.setLicenseNumber(driverLicenseInfo.getLicenseNumber());
        driverLicenseInfoDTO.setFirstName(driverLicenseInfo.getFirstName());
        driverLicenseInfoDTO.setLastName(driverLicenseInfo.getLastName());
        driverLicenseInfoDTO.setStreetAddress(driverLicenseInfo.getStreetAddress());
        driverLicenseInfoDTO.setAddressLine(driverLicenseInfo.getAddressLine());
        driverLicenseInfoDTO.setCity(driverLicenseInfo.getCity());
        driverLicenseInfoDTO.setState(driverLicenseInfo.getState());
        driverLicenseInfoDTO.setZipCode(driverLicenseInfo.getZipCode());
        driverLicenseInfoDTO.setIssuedDate(driverLicenseInfo.getIssuedDate());
        driverLicenseInfoDTO.setExpirationDate(driverLicenseInfo.getExpirationDate());
        driverLicenseInfoDTO.setLicenseType(driverLicenseInfo.getLicenseType());

        return driverLicenseInfoDTO;

    }
}
