package com.example.houseservice.application.mappers;

import com.example.houseservice.application.dto.request.SaveCityRequest;
import com.example.houseservice.application.dto.response.CityResponse;
import com.example.houseservice.domain.model.CityModel;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CityDtoMapper {
    CityModel requestToModel(SaveCityRequest saveCityRequest);
    CityResponse modelToResponse(CityModel cityModel);
    List<CityResponse> modelListToResponseList(List<CityModel> cities);
}
