package com.firstspring.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.firstspring.entities.CityDetails;
import com.firstspring.repo.CityRepo;import jakarta.security.auth.message.callback.PrivateKeyCallback.Request;

@RestController
public class CityController {
	
	@Autowired
	private CityRepo cityrepo;
	
	@GetMapping("/getallcity")
	public List<CityDetails> getAllCity(){
		return cityrepo.findAll();
	}
	
	@GetMapping("/getcitybyid/{id}")
	public Optional<CityDetails> getCityById(@PathVariable ("id") int id) {
		return cityrepo.findById(id);	
	}
	
	@PostMapping("/createcity")
	public String addCity(@RequestBody CityDetails city) {
		cityrepo.save(city);
		return "Successfully Store Data";
	}
	
	@PutMapping("/updatecity")
	public String updateCity(@RequestBody CityDetails city) {
		cityrepo.save(city);
		return "Update Successfully Data";
	}
	
	@DeleteMapping("/deletcity/{id}")
	public String deleteCityById(@PathVariable ("id") int id) {
		cityrepo.deleteById(id);
		return "Delete Data Successfully";
	}
}
