package com.abhi.webservices.myrestwebservice.dao;

import com.abhi.webservices.myrestwebservice.model.VehicleFeatures;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Abhinav on 3/3/2019.
 */
@Repository
public interface VehicleFeaturesDAO extends JpaRepository<VehicleFeatures, Integer> {
}
