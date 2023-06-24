package com.infy.rentacar.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.infy.rentacar.entity.Rental;

public interface RentalRepository extends CrudRepository<Rental, Integer>{
	List<Rental> findByCarType(String carType);

}
