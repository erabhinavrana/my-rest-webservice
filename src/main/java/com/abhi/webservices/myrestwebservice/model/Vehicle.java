package com.abhi.webservices.myrestwebservice.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.List;

@Entity
@ApiModel(description = "It contains information about vehicles.")
public class Vehicle {

    @Id
    @GeneratedValue
    private Integer id;

    @NotNull
    @Size(min = 3)
    @ApiModelProperty(notes = "Name should contains at least 3 characters.")
    private String name;

    @NotNull
    @Size(max = 15)
    @ApiModelProperty(notes = "Type should not contains more than 15 characters.")
    private String type;

    @NotNull
    @Past
    @ApiModelProperty(notes = "Manufacture date should not be in the future.")
    private LocalDate dateOfManufacture;

    @OneToMany(mappedBy = "vehicle")
    private List<VehicleFeatures> vehicleFeatures;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public LocalDate getDateOfManufacture() {
        return dateOfManufacture;
    }

    public void setDateOfManufacture(LocalDate dateOfManufacture) {
        this.dateOfManufacture = dateOfManufacture;
    }

    public List<VehicleFeatures> getVehicleFeatures() {
        return vehicleFeatures;
    }

    public void setVehicleFeatures(List<VehicleFeatures> vehicleFeatures) {
        this.vehicleFeatures = vehicleFeatures;
    }
}
