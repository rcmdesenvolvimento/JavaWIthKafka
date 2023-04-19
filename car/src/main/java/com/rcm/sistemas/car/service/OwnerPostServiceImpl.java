package com.rcm.sistemas.car.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rcm.sistemas.car.dto.OwnerPostDTO;
import com.rcm.sistemas.car.entity.OwnerPostEntity;
import com.rcm.sistemas.car.repository.OwnerPostRepository;

@Service
public class OwnerPostServiceImpl implements OwnerPostService {

	@Autowired
	private OwnerPostRepository ownerPostRepository;

	@Override
	public void createOwnerPost(OwnerPostDTO ownerPostDTO) {

		OwnerPostEntity ownerPost = new OwnerPostEntity();
		ownerPost.setName(ownerPostDTO.getName());
		ownerPost.setType(ownerPostDTO.getType());
		ownerPost.setContactNumber(ownerPostDTO.getContactNumber());

		ownerPostRepository.save(ownerPost);

	}

}
