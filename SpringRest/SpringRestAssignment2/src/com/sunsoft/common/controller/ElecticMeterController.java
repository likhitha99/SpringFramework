package com.sunsoft.common.controller;

import java.util.HashMap;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.sunsoft.common.model.ElectricMeter;


@RestController
@RequestMapping("/details")
public class ElecticMeterController {
	@RequestMapping(method = RequestMethod.GET)
	public String getDetails(@RequestParam("id1") int id1)
	{
		HashMap<Integer, ElectricMeter> hml = new HashMap<Integer, ElectricMeter>();

		hml.put(1, new ElectricMeter(1, 60, 40, 2400, "20/1/2021"));
		hml.put(2, new ElectricMeter(2, 70, 40, 2800, "20/1/2021"));
		hml.put(3, new ElectricMeter(3, 80, 40, 3200, "20/1/2021"));

		ElectricMeter em = null;
		if (hml.containsKey(id1)) {
			em = hml.get(id1);
		}
		
		return new Gson().toJson(em);
		
	}
	

}
