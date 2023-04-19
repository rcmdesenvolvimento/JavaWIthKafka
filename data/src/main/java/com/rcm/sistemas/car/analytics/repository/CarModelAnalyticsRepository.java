package com.rcm.sistemas.car.analytics.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rcm.sistemas.car.analytics.entity.CarModelAnalyticsEntity;

@Repository
public interface CarModelAnalyticsRepository extends JpaRepository<CarModelAnalyticsEntity, Long>{
	
	Optional<CarModelAnalyticsEntity> findByModel(String model);

}
