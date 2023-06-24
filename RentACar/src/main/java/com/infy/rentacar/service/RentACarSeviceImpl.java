package com.infy.rentacar.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infy.rentacar.dto.RentalDTO;
import com.infy.rentacar.entity.Rental;
import com.infy.rentacar.exception.RentACarException;
import com.infy.rentacar.repository.RentalRepository;
import com.infy.rentacar.validator.Validator;
@Service(value = "rentACarService")
@Transactional

public class RentACarSeviceImpl implements RentACarSevice{
	@Autowired

	private RentalRepository  rentalRepository;
	@Override
	public RentalDTO rentACar(RentalDTO rentalDTO) throws RentACarException {
		Validator.validate(rentalDTO);
		Rental rental= new Rental();
		rental.setBookingStartDate(rentalDTO.getBookingStartDate());
		rental.setCarType(rentalDTO.getCarType());
		rental.setCustomerName(rentalDTO.getCustomerName());
		rental.setDuration(rentalDTO.getDuration());
		rental.setMobileNumber(rentalDTO.getMobileNumber());
		rental.setRentalId(rentalDTO.getRentalId());
		rental=rentalRepository.save(rental);
		
		return rentalDTO;
	}

	@Override
	public List<RentalDTO> getRentalByCarType(String carType) throws RentACarException {
		// TODO Auto-generated method stub
		List<Rental> rentals=rentalRepository.findByCarType(carType);
		if(rentals.isEmpty()) {
			throw new RentACarException("Service.NO_RENTALS_FOUND");
		}
		List<RentalDTO> rentalDTOs =new ArrayList<RentalDTO>();
		for(Rental rental:rentals) {
			RentalDTO rentalDTO=new RentalDTO();
			rentalDTO.setBookingStartDate(rental.getBookingStartDate());
			rentalDTO.setCarType(rental.getCarType());
			rentalDTO.setCustomerName(rental.getCustomerName());
			rentalDTO.setDuration(rental.getDuration());
			rentalDTO.setMobileNumber(rental.getMobileNumber());
			rentalDTO.setRentalId(rental.getRentalId());
			rentalDTOs.add(rentalDTO);
			
		}
		return rentalDTOs;
	}

}