package com.rcm.sistemas.api.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rcm.sistemas.api.dto.OwnerPostDTO;
import com.rcm.sistemas.api.service.OwnerPostService;

@RestController
@RequestMapping("/owner")
public class OwnerPostController {
	
	private final Logger LOG = LoggerFactory.getLogger(OwnerPostController.class);

	@Autowired
	private OwnerPostService ownerPostService;

	@PostMapping
	public ResponseEntity<?> createOwner(@RequestBody OwnerPostDTO ownerPostDTO) {
		
		LOG.info("USANDO API REST - Criando Novo Usuário: {}", ownerPostDTO);
		
		ownerPostService.createOwnerCar(ownerPostDTO);
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
