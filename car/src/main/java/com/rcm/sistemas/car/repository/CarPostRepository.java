package com.rcm.sistemas.car.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rcm.sistemas.car.entity.CarPostEntity;

@Repository
public interface CarPostRepository extends JpaRepository<CarPostEntity, Long> {

}
