package com.example.houseservice.infrastructure.adapters.persistence;

import com.example.houseservice.domain.model.RealStateModel;
import com.example.houseservice.domain.ports.out.RealStatePersistencePort;
import com.example.houseservice.infrastructure.mappers.RealStateEntityMapper;
import com.example.houseservice.infrastructure.repositories.mysql.RealStateRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class RealStatePersistenceAdapter implements RealStatePersistencePort {
    private final RealStateRepository realStateRepository;
    private final RealStateEntityMapper realStateEntityMapper;

    @Override
    public void saveRealState(RealStateModel realStateModel) {
        realStateRepository.save(realStateEntityMapper.modelToEntity(realStateModel));
    }


}
