package com.example.houseservice.application.services;

import com.example.houseservice.application.dto.request.SaveRealStateRequest;
import com.example.houseservice.application.dto.response.RealStateResponse;
import com.example.houseservice.application.dto.response.SaveRealStateResponse;
import com.example.houseservice.domain.filters.RealStateFilter;
import com.example.houseservice.domain.utils.MyPage;

public interface RealStateService {
    SaveRealStateResponse save(SaveRealStateRequest request);
    MyPage<RealStateResponse> getRealStatesByFilter(RealStateFilter filter, Integer page, Integer size, boolean orderAsc);
}
