package com.rcm.sistemas.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rcm.sistemas.api.client.CarPostStoreClient;
import com.rcm.sistemas.api.dto.CarPostDTO;

@Service
public class CarPostStoreServiceImpl implements CarPostStoreService {

	@Autowired
	private CarPostStoreClient carPoststoreClient;

	@Override
	public List<CarPostDTO> getCarForSales() {
		return carPoststoreClient.carPostSaleClient();
	}

	@Override
	public void changeCarForSales(CarPostDTO carPostDTO, String id) {
		carPoststoreClient.changeCarForSaleClient(carPostDTO, id);
	}

	@Override
	public void removeCarForSales(String id) {
		carPoststoreClient.deleteCarForSaleClient(id);
	}

}
