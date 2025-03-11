package com.example.houseservice.city.application.services.impl;


import com.example.houseservice.city.application.dto.request.SaveCityRequest;
import com.example.houseservice.city.application.dto.response.CityResponse;
import com.example.houseservice.city.application.dto.response.SaveCityResponse;
import com.example.houseservice.city.application.mappers.CityDtoMapper;
import com.example.houseservice.city.application.services.CityService;
import com.example.houseservice.city.domain.ports.in.CityServicePort;
import com.example.houseservice.commons_configuration.utils.Constants;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CityServiceImpl implements CityService{
    private final CityServicePort cityServicePort;
    private final CityDtoMapper cityDtoMapper;

    @Override
    public SaveCityResponse save(SaveCityRequest request) {
        cityServicePort.SaveCity(cityDtoMapper.requestToModel(request));
        return new SaveCityResponse(Constants.SAVE_CITY_RESPONSE_MESSAGE, LocalDateTime.now());
    }

    @Override
    public List<CityResponse> getCities(Integer page, Integer size, boolean orderAsc) {
        return cityDtoMapper.modelListToResponseList(cityServicePort.getCities(page, size, orderAsc));
    }

}
