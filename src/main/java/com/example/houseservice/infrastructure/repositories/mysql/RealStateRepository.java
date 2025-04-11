package com.example.houseservice.infrastructure.repositories.mysql;

import com.example.houseservice.infrastructure.entities.RealStateEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface RealStateRepository extends JpaRepository<RealStateEntity, Long> {
    @Query("SELECT r FROM RealStateEntity r " +
            "WHERE r.status = 'PUBLICADA' " +
            "AND (:categoryName IS NULL OR r.category.name = :categoryName) " +
            "AND (:bathrooms IS NULL OR r.bathrooms = :bathrooms) " +
            "AND (:rooms IS NULL OR r.rooms = :rooms) " +
            "AND (:locationName IS NULL OR " +
            "     r.location.city.name LIKE %:locationName% OR " +
            "     r.location.department.name LIKE %:locationName%) " +
            "AND (:minPrice IS NULL OR r.price >= :minPrice) " +
            "AND (:maxPrice IS NULL OR r.price <= :maxPrice)")
    Page<RealStateEntity> findByFilters(String categoryName,
                                        Integer bathrooms,
                                        Integer rooms,
                                        String locationName,
                                        Float minPrice,
                                        Float maxPrice,
                                        Pageable pageable);
}
