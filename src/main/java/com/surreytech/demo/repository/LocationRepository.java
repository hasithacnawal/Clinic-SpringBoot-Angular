package com.surreytech.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.surreytech.demo.entity.Location;

public interface LocationRepository extends JpaRepository<Location, Integer>{

	
}
