package com.firstspring.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.firstspring.entities.CityDetails;


public interface CityRepo extends JpaRepository<CityDetails, Integer>{
}
