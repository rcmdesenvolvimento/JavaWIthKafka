package com.rcm.sistemas.car.service;

import org.springframework.stereotype.Service;

import com.rcm.sistemas.car.dto.OwnerPostDTO;

@Service
public interface OwnerPostService {

	void createOwnerPost(OwnerPostDTO ownerPostDTO);

}
