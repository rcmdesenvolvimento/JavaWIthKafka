package com.rcm.sistemas.car.analytics.service;

import org.springframework.stereotype.Service;

import com.rcm.sistemas.car.analytics.dto.CarPostDTO;

@Service
public interface PostAnalyticsService {

	void saveDataAnalytics(CarPostDTO carPostDTO);
}
