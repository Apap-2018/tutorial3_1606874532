package com.apap.tutorial3.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.apap.tutorial3.model.CarModel;

//Car In Memory Service
@Service
public class CarInMemoryService implements CarService{
	private List<CarModel> archiveCar;
	
	public CarInMemoryService() {
		archiveCar = new ArrayList<>();
	}
	
	@Override
	public List<CarModel> getCarList(){
		return archiveCar;
	}

	@Override
	public void AddCar(CarModel car) {
		archiveCar.add(car);
	}

	@Override
	public CarModel getCarDetail(String id) {
		CarModel cekCarModel = null;
		for(int i=0; i<archiveCar.size();i++) {
			cekCarModel = archiveCar.get(i);
			if(cekCarModel.getId().equals(id)){
				return cekCarModel;
				}
		}
		return cekCarModel;
	}

}










