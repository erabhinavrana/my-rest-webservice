package com.abhi.webservices.myrestwebservice.dao;

import com.abhi.webservices.myrestwebservice.model.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleDAO extends JpaRepository<Vehicle, Integer> {

}
