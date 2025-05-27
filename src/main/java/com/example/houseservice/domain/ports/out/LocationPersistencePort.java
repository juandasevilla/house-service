package com.example.houseservice.domain.ports.out;

import com.example.houseservice.domain.model.LocationModel;
import com.example.houseservice.domain.utils.MyPage;

import java.util.Optional;

public interface LocationPersistencePort {
    void saveLocation(LocationModel locationModel);
    MyPage<LocationModel> getLocationsByName(int page, int size, boolean orderAsc, String name);
    Optional<LocationModel> findById(Long id);
    LocationModel findByNameAndCityId(String name, Long cityId);
}
