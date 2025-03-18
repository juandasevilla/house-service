package com.example.houseservice.infrastructure.mappers;


import com.example.houseservice.domain.model.CityModel;
import com.example.houseservice.infrastructure.entities.CityEntity;
import org.mapstruct.Mapper;
import java.util.List;

@Mapper(componentModel = "spring")
public interface CityEntityMapper {
    CityEntity modelToEntity(CityModel cityModel);
    CityModel entityToModel(CityEntity cityEntity);
    List<CityModel> entityListToModelList(List<CityEntity> cities);
}
