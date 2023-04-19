package com.rcm.sistemas.api.service;

import java.util.List;

import com.rcm.sistemas.api.dto.CarPostDTO;

//@Service
public interface CarPostStoreService {

	List<CarPostDTO> getCarForSales();
	
	void changeCarForSales(CarPostDTO carPostDTO, String id);
	
	void removeCarForSales(String id);
}
