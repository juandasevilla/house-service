package com.example.houseservice.domain.ports.in;


import com.example.houseservice.domain.model.LocationModel;
import com.example.houseservice.domain.utils.MyPage;

public interface LocationServicePort {
    void saveLocation(LocationModel locationModel);
    MyPage<LocationModel> getLocationsByName(int page, int size, boolean orderAsc, String name);
}
