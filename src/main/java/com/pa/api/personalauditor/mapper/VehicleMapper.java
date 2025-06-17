package com.pa.api.personalauditor.mapper;

import com.pa.api.personalauditor.dto.AccountDTO;
import com.pa.api.personalauditor.dto.VehicleDTO;
import com.pa.api.personalauditor.entity.Account;
import com.pa.api.personalauditor.entity.Vehicle;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface VehicleMapper {

    @Mapping(target = "vehicleId", source = "entity.vehicleId")
    VehicleDTO vehicleEntityToVehicleDto(Vehicle entity);

    @Mapping(target = "vehicleId", source = "dto.vehicleId")
    Vehicle vehicleDTOToVehicleEntity(VehicleDTO dto);
}
