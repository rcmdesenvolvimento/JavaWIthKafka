package com.rcm.sistemas.api.service;

import org.springframework.stereotype.Service;

import com.rcm.sistemas.api.dto.OwnerPostDTO;

@Service
public interface OwnerPostService {

	void createOwnerCar(OwnerPostDTO ownerPostDTO);

}
