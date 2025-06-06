package com.example.houseservice.domain.ports.out;

import com.example.houseservice.domain.filters.RealStateFilter;
import com.example.houseservice.domain.model.RealStateModel;
import com.example.houseservice.domain.utils.MyPage;

public interface RealStatePersistencePort {
    void saveRealState(RealStateModel realStateModel);
    MyPage<RealStateModel> getRealStatesByFilter(RealStateFilter filter,Integer page, Integer size, boolean orderAsc);
    boolean existsRealStateWithId(Long id);
}
