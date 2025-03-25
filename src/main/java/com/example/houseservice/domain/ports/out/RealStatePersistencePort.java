package com.example.houseservice.domain.ports.out;

import com.example.houseservice.domain.model.RealStateModel;

public interface RealStatePersistencePort {
    void saveRealState(RealStateModel realStateModel);
}
