package com.infy.rentacar.validator;

import com.infy.rentacar.dto.RentalDTO;
import com.infy.rentacar.exception.RentACarException;

public class Validator {
	public Validator() {
		super();
		// TODO Auto-generated constructor stub
	}
	public static void validate(RentalDTO rentalDTO) throws RentACarException{
	if(isValidContactNumber(rentalDTO.getMobileNumber())==false)
	{
		throw new RentACarException("Validator.INVALID_CONTACT");
	}	
	}
	public static Boolean isValidContactNumber(Long mobileNumber)
	{
		String regex="[1-9]{1}+[0-9]{9}";
		if(mobileNumber.toString().matches(regex)) {
			return true;
		}
		return false;
		
	}
	
}
