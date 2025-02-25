package com.transportdataexchange.bogdan.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class BusData {

    @Id
    private Integer idTrim;
    private String make;
    private String model;
    private String series;
    private String classBus;
    private String appointment;
    private String totalSeats;
    private Integer doorWidth;
    private Double materialCost;
    private String engineType;
    private Integer numberOfCylinders;
    private Integer amountOfGear;


    public Integer getIdTrim() {
        return idTrim;
    }

    public void setIdTrim(Integer idTrim) {
        this.idTrim = idTrim;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getSeries() {
        return series;
    }

    public void setSeries(String series) {
        this.series = series;
    }

    public String getClassBus() {
        return classBus;
    }

    public void setClassBus(String classBus) {
        this.classBus = classBus;
    }

    public String getAppointment() {
        return appointment;
    }

    public void setAppointment(String appointment) {
        this.appointment = appointment;
    }

    public String getTotalSeats() {
        return totalSeats;
    }

    public void setTotalSeats(String totalSeats) {
        this.totalSeats = totalSeats;
    }

    public Integer getDoorWidth() {
        return doorWidth;
    }

    public void setDoorWidth(Integer doorWidth) {
        this.doorWidth = doorWidth;
    }

    public Double getMaterialCost() {
        return materialCost;
    }

    public void setMaterialCost(Double materialCost) {
        this.materialCost = materialCost;
    }

    public String getEngineType() {
        return engineType;
    }

    public void setEngineType(String engineType) {
        this.engineType = engineType;
    }

    public Integer getNumberOfCylinders() {
        return numberOfCylinders;
    }

    public void setNumberOfCylinders(Integer numberOfCylinders) {
        this.numberOfCylinders = numberOfCylinders;
    }

    public Integer getAmountOfGear() {
        return amountOfGear;
    }

    public void setAmountOfGear(Integer amountOfGear) {
        this.amountOfGear = amountOfGear;
    }
}
