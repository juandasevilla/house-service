package com.example.houseservice.domain.usecases;

import com.example.houseservice.domain.exceptions.CategoryIsRequiredException;
import com.example.houseservice.domain.exceptions.LocationIsRequiredException;
import com.example.houseservice.domain.model.RealStateModel;
import com.example.houseservice.domain.ports.in.RealStateServicePort;
import com.example.houseservice.domain.ports.out.CategoryPersistencePort;
import com.example.houseservice.domain.ports.out.LocationPersistencePort;
import com.example.houseservice.domain.ports.out.RealStatePersistencePort;

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
}
