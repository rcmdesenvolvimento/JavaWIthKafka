package com.rcm.sistemas.api.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rcm.sistemas.api.dto.CarPostDTO;
import com.rcm.sistemas.api.message.KafkaProducerMessage;
import com.rcm.sistemas.api.service.CarPostStoreService;

@RestController
@RequestMapping("/api/car")
public class CarPostController {
	
	private final Logger LOG = LoggerFactory.getLogger(CarPostController.class);

	@Autowired
	private CarPostStoreService carPostStoreService;
	
	@Autowired
	private KafkaProducerMessage kafkaProducerMessage; 
	
	@PostMapping("/post")
	public ResponseEntity<?> postCarForSale(@RequestBody CarPostDTO carPostDTO){
		
		LOG.info("USANDO EVENTOS/MENSAGENS KAFKA - Producer Car Post information: {}", carPostDTO);
		
		kafkaProducerMessage.sendMessage(carPostDTO);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@GetMapping("/posts")
	public ResponseEntity<List<CarPostDTO>> getCarSales() {
		return ResponseEntity.status(HttpStatus.FOUND).body(carPostStoreService.getCarForSales());
	}

	@PutMapping("/{id}")
	public ResponseEntity<?> changeCarForSale(@RequestBody CarPostDTO carPostDTO, @PathVariable("id") String id) {
		carPostStoreService.changeCarForSales(carPostDTO, id);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteCarForSale(@PathVariable("id") String id) {
		carPostStoreService.removeCarForSales(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
