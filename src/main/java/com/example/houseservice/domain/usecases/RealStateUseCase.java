package com.example.houseservice.domain.usecases;

import com.example.houseservice.domain.exceptions.CategoryIsRequiredException;
import com.example.houseservice.domain.exceptions.LocationIsRequiredException;
import com.example.houseservice.domain.filters.RealStateFilter;
import com.example.houseservice.domain.model.RealStateModel;
import com.example.houseservice.domain.ports.in.RealStateServicePort;
import com.example.houseservice.domain.ports.out.CategoryPersistencePort;
import com.example.houseservice.domain.ports.out.LocationPersistencePort;
import com.example.houseservice.domain.ports.out.RealStatePersistencePort;
import com.example.houseservice.domain.utils.MyPage;

public class RealStateUseCase implements RealStateServicePort {
    private final RealStatePersistencePort realStatePersistencePort;
    private final CategoryPersistencePort categoryPersistencePort;
    private final LocationPersistencePort locationPersistencePort;

    public RealStateUseCase(RealStatePersistencePort realStatePersistencePort, CategoryPersistencePort categoryPersistencePort, LocationPersistencePort locationPersistencePort) {
        this.realStatePersistencePort = realStatePersistencePort;
        this.categoryPersistencePort = categoryPersistencePort;
        this.locationPersistencePort = locationPersistencePort;
    }

    @Override
    public void saveRealState(RealStateModel realStateModel) {
        if(!categoryPersistencePort.findById(realStateModel.getCategory().getId()).isPresent()) {
            throw new CategoryIsRequiredException();
        }
        if (!locationPersistencePort.findById(realStateModel.getLocation().getId()).isPresent()) {
            throw new LocationIsRequiredException();
        }
        realStatePersistencePort.saveRealState(realStateModel);
    }

    @Override
    public MyPage<RealStateModel> getRealStatesByFilter(RealStateFilter filter, Integer page, Integer size, boolean orderAsc) {
        return realStatePersistencePort.getRealStatesByFilter(filter,page, size, orderAsc);
    }

    @Override
    public boolean existsRealStateWithId(Long id) {
        return realStatePersistencePort.existsRealStateWithId(id);
    }
}
