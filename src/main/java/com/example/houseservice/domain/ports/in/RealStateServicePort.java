package com.example.houseservice.domain.ports.in;

import com.example.houseservice.domain.model.RealStateModel;

public interface RealStateServicePort {
    void saveRealState(RealStateModel realStateModel);
}
