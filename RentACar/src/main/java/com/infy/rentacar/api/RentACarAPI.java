package com.infy.rentacar.api;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.infy.rentacar.dto.RentalDTO;
import com.infy.rentacar.exception.RentACarException;
import com.infy.rentacar.service.RentACarSevice;
@RestController
@RequestMapping(value = "rentacar")
@Validated
public class RentACarAPI {
	@Autowired
	private RentACarSevice rentACarSevice;
	@PostMapping(value = "rent")
	public ResponseEntity<RentalDTO >rentACar(@RequestBody @Valid RentalDTO rentalDTO) throws RentACarException
	{
		RentalDTO dto=rentACarSevice.rentACar(rentalDTO);
		return new ResponseEntity<RentalDTO>(dto, HttpStatus.CREATED);
		
	}
@GetMapping(value = "customers/{carType}")
	public ResponseEntity<List<RentalDTO>>getRentals(@PathVariable @Valid String carType) throws RentACarException
	{
	List<RentalDTO> rentalDTOs=rentACarSevice.getRentalByCarType(carType);
	
		return new ResponseEntity<List<RentalDTO>>(rentalDTOs, HttpStatus.OK);
		
	}
}
