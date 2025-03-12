package com.example.houseservice.location.application.mappers;

import com.example.houseservice.location.application.dto.request.SaveLocationRequest;
import com.example.houseservice.location.application.dto.response.LocationResponse;
import com.example.houseservice.location.domain.model.LocationModel;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface LocationDtoMapper {
    LocationModel requestToModel(SaveLocationRequest saveLocationRequest);
    LocationResponse modelToResponse(LocationModel locationModel);
}
