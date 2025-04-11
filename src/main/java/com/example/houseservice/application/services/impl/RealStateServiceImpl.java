package com.example.houseservice.application.services.impl;
import com.example.houseservice.application.dto.request.SaveRealStateRequest;
import com.example.houseservice.application.dto.response.RealStateResponse;
import com.example.houseservice.application.dto.response.SaveRealStateResponse;
import com.example.houseservice.application.mappers.RealStateDtoMapper;
import com.example.houseservice.application.services.RealStateService;
import com.example.houseservice.commons_configuration.utils.Constants;
import com.example.houseservice.domain.exceptions.CategoryIsRequiredException;
import com.example.houseservice.domain.exceptions.LocationIsRequiredException;
import com.example.houseservice.domain.filters.RealStateFilter;
import com.example.houseservice.domain.model.CategoryModel;
import com.example.houseservice.domain.model.LocationModel;
import com.example.houseservice.domain.model.RealStateModel;
import com.example.houseservice.domain.ports.in.RealStateServicePort;
import com.example.houseservice.domain.ports.out.CategoryPersistencePort;
import com.example.houseservice.domain.ports.out.LocationPersistencePort;
import com.example.houseservice.domain.ports.out.RealStatePersistencePort;
import com.example.houseservice.domain.utils.MyPage;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RealStateServiceImpl implements RealStateService {
    private final RealStateServicePort realStateServicePort;
    private final RealStateDtoMapper realStateDtoMapper;
    private final CategoryPersistencePort categoryPersistencePort;
    private final LocationPersistencePort locationPersistencePort;

    @Override
    public SaveRealStateResponse save(SaveRealStateRequest request){
        RealStateModel realStateModel = realStateDtoMapper.requestToModel(request);

        CategoryModel categoryModel = categoryPersistencePort.findById(request.getCategoryId())
                .orElseThrow(() -> new CategoryIsRequiredException());

        realStateModel.setCategory(categoryModel);

        LocationModel locationModel = locationPersistencePort.findById(request.getLocationId())
                .orElseThrow(() -> new LocationIsRequiredException());

        realStateModel.setLocation(locationModel);
        realStateServicePort.saveRealState(realStateModel);
        return new SaveRealStateResponse(Constants.SAVE_REAL_STATE_RESPONSE_MESSAGE, LocalDateTime.now());
    }

    @Override
    public MyPage<RealStateResponse> getRealStatesByFilter(RealStateFilter filter, Integer page, Integer size, boolean orderAsc) {
        MyPage<RealStateModel> realStateModelPage = realStateServicePort.getRealStatesByFilter(filter, page, size, orderAsc);
        List<RealStateResponse> realStateResponseList = realStateDtoMapper.modelListToResponseList(realStateModelPage.getContent());
        return new MyPage<>(realStateResponseList, page, size, orderAsc, realStateModelPage.getTotalObjects());
    }






}
