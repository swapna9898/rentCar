package com.infy.rentacar.service;

import java.util.List;

import com.infy.rentacar.dto.RentalDTO;
import com.infy.rentacar.exception.RentACarException;
import com.infy.rentacar.repository.RentalRepository;

public class RentACarSeviceImpl implements RentACarSevice{

	private RentalRepository  rentalRepository;
	@Override
	public RentalDTO rentACar(RentalDTO rentalDTO) throws RentACarException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<RentalDTO> getRentalByCarType(String carType) throws RentACarException {
		// TODO Auto-generated method stub
		return null;
	}

}
