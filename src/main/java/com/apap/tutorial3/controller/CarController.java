package com.apap.tutorial3.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.apap.tutorial3.model.CarModel;
import com.apap.tutorial3.service.CarService;

@Controller
public class CarController {
	@Autowired
	private CarService mobilService;
	
	@RequestMapping("/car/add")
	public String add(@RequestParam(value="id", required=true) String id,
			@RequestParam(value="brand", required=true) String brand,
			@RequestParam(value="type", required=true) String type,
			@RequestParam(value="price", required=true) Long price,
			@RequestParam(value="amount", required=true) Integer amount) {
		CarModel car = new CarModel(id, brand, type, price, amount);
		mobilService.AddCar(car);
		return "add";	
	}
	
	@RequestMapping("/car/view")
	public String view(@RequestParam("id") String id, Model model) {
		CarModel archive = mobilService.getCarDetail(id);
		
		model.addAttribute("car", archive);
		return "view-car";
	}
	
	@RequestMapping("/car/viewall")
	public String viewall(Model model) {
		List<CarModel> archive = mobilService.getCarList();
		model.addAttribute("listCar", archive);
		return "viewall-car";
	}

	@RequestMapping("/car/view/{id}")
	public String viewId(@PathVariable String id, Model model) {
		CarModel archive = mobilService.getCarDetail(id);
		if(archive == null) {
			return "error-noID";
		}
		else {
			model.addAttribute("CarByID", archive);
			return "viewId";
		}
	}

	@RequestMapping("/car/update/{id}/amount/{NewAmount}")
	public String updateAmount(@PathVariable String id,@PathVariable String NewAmount, Model model) {
		CarModel archive = mobilService.getCarDetail(id);
		if(archive == null) {
			return "error-noID";
		}
		else {
			archive.setAmount(Integer.parseInt(NewAmount));
			model.addAttribute("CarByID", archive);
			return "viewUpdatedAmount";
		}
	}
	
	@RequestMapping("/car/delete/{id}")
	public String delete(@PathVariable String id, Model model) {
		CarModel archive = mobilService.getCarDetail(id);
		if(archive == null) {
			return "error-noID";
		}
		else {
			mobilService.getCarList().remove(archive);
			return "Deleted";
		}
	}

	
}
