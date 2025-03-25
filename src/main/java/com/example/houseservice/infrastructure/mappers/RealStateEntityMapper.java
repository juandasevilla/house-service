package com.example.houseservice.infrastructure.mappers;

import com.example.houseservice.domain.model.RealStateModel;
import com.example.houseservice.infrastructure.entities.RealStateEntity;
import java.util.List;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {LocationEntityMapper.class, CategoryEntityMapper.class})
public interface RealStateEntityMapper {
    RealStateEntity modelToEntity(RealStateModel realStateModel);
    RealStateModel entityToModel(RealStateEntity realStateEntity);
    List<RealStateModel> entityListToModelList(List<RealStateEntity> realStates);
}
