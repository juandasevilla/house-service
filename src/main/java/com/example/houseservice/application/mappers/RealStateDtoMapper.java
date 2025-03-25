package com.example.houseservice.application.mappers;


import com.example.houseservice.application.dto.request.SaveRealStateRequest;
import com.example.houseservice.application.dto.response.RealStateResponse;
import com.example.houseservice.domain.model.RealStateModel;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface RealStateDtoMapper {
    RealStateModel requestToModel(SaveRealStateRequest saveRealStateRequest);
    RealStateResponse modelToResponse(RealStateModel realStateModel);
    List<RealStateResponse> modelListToResponseList(List<RealStateModel> realStates);
}
