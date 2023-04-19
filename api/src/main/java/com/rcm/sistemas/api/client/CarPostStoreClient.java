package com.rcm.sistemas.api.client;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.rcm.sistemas.api.dto.CarPostDTO;
import com.rcm.sistemas.api.dto.OwnerPostDTO;

@Component
public class CarPostStoreClient {

	private final String USER_STORE_SERVICE_URI = "http://localhost:8080/user";
	private final String POST_STORE_SERVICE_URI = "http://localhost:8080/sales";

	@Autowired
	RestTemplate restTemplate;

	public List<CarPostDTO> carPostSaleClient() {
		ResponseEntity<CarPostDTO[]> responseEntity = restTemplate.getForEntity(POST_STORE_SERVICE_URI + "/cars",
				CarPostDTO[].class);
		return Arrays.asList(Objects.requireNonNull(responseEntity.getBody()));
	}

	public void ownerPostClient(OwnerPostDTO newUser) {
		restTemplate.postForEntity(USER_STORE_SERVICE_URI, newUser, OwnerPostDTO.class);
	}

	public void changeCarForSaleClient(CarPostDTO carPostDTO, String id) {
		restTemplate.put(POST_STORE_SERVICE_URI + "/cars" + id, OwnerPostDTO.class);
	}
	
	public void deleteCarForSaleClient(String id) {
		restTemplate.delete(POST_STORE_SERVICE_URI + "/cars" + id);
	}

}
