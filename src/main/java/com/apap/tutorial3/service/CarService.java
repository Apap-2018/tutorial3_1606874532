package com.apap.tutorial3.service;

import java.util.List;

import com.apap.tutorial3.model.CarModel;

//Car Service
public interface CarService {
	void AddCar(CarModel car);
	
	List<CarModel> getCarList();
	
	CarModel getCarDetail(String id);

}
