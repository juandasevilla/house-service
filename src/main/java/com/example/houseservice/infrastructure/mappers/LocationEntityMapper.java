package com.example.houseservice.infrastructure.mappers;

import com.example.houseservice.domain.model.LocationModel;
import com.example.houseservice.infrastructure.entities.LocationEntity;
import org.mapstruct.Mapper;
import java.util.List;

@Mapper(componentModel = "spring", uses = {DepartmentEntityMapper.class, CityEntityMapper.class})
public interface LocationEntityMapper {
    LocationEntity modelToEntity(LocationModel locationModel);
    LocationModel entityToModel(LocationEntity locationEntity);
    List<LocationModel> entityListToModelList(List<LocationEntity> locations);
}
