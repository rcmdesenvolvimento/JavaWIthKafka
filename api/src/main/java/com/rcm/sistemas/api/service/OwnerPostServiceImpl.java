package com.rcm.sistemas.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rcm.sistemas.api.client.CarPostStoreClient;
import com.rcm.sistemas.api.dto.OwnerPostDTO;

@Service
public class OwnerPostServiceImpl implements OwnerPostService {

	@Autowired
	private CarPostStoreClient carPostStoreClient;

	@Override
	public void createOwnerCar(OwnerPostDTO ownerPostDTO) {
		carPostStoreClient.ownerPostClient(ownerPostDTO);
	}

}
