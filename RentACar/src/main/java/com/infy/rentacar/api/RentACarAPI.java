package com.infy.rentacar.api;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.infy.rentacar.dto.RentalDTO;
import com.infy.rentacar.exception.RentACarException;
import com.infy.rentacar.service.RentACarSevice;

public class RentACarAPI {
	private RentACarSevice rentACarSevice;
	public ResponseEntity<RentalDTO>rentACar(RentalDTO rentalDTO) throws RentACarException
	{
		return null;
		
	}

	public ResponseEntity<List<RentalDTO>>getRentals(String carType) throws RentACarException
	{
		return null;
		
	}
}
