package com.example.houseservice.infrastructure.adapters.persistence;

import com.example.houseservice.domain.model.CityModel;
import com.example.houseservice.domain.ports.out.CityPersistencePort;
import com.example.houseservice.infrastructure.mappers.CityEntityMapper;
import com.example.houseservice.infrastructure.repositories.mysql.CityRepository;
import com.example.houseservice.commons_configuration.utils.Constants;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class CityPersistenceAdapter implements CityPersistencePort {
    private final CityRepository cityRepository;
    private final CityEntityMapper cityEntityMapper;

    @Override
    public void saveCity(CityModel cityModel) {
        cityRepository.save(cityEntityMapper.modelToEntity(cityModel));
    }

    @Override
    public CityModel getCityByName(String cityName) {
        return cityEntityMapper.entityToModel(cityRepository.findByName(cityName).orElse(null));
    }

    @Override
    public List <CityModel> getCities(Integer page, Integer size, boolean orderAsc) {
        Pageable pagination;
        if (orderAsc) pagination = PageRequest.of(page, size, Sort.by(Constants.PAGEABLE_FIELD_NAME).ascending());
        else pagination = PageRequest.of(page, size, Sort.by(Constants.PAGEABLE_FIELD_NAME).descending());
        return cityEntityMapper.entityListToModelList(cityRepository.findAll(pagination).getContent());
    }


}
