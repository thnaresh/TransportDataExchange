package com.transportdataexchange.bogdan.model;

import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@NoArgsConstructor
public class BusData {

    @Id
    private int idTrim;

    private String make;
    private String model;
    private String series;
    private String classBus;
    private String appointment;
    private int totalSeats;
    private int boardingSeats;
    private int doorWidth;
    private double materialCost;
    private String environmentalStandard;
    private String engineType;
    private int numberOfCylinders;
    private int gearAmount;
    private int length;

    public int getIdTrim() {
        return idTrim;
    }

    public void setIdTrim(int idTrim) {
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

    public int getTotalSeats() {
        return totalSeats;
    }

    public void setTotalSeats(int totalSeats) {
        this.totalSeats = totalSeats;
    }

    public int getBoardingSeats() {
        return boardingSeats;
    }

    public void setBoardingSeats(int boardingSeats) {
        this.boardingSeats = boardingSeats;
    }

    public int getDoorWidth() {
        return doorWidth;
    }

    public void setDoorWidth(int doorWidth) {
        this.doorWidth = doorWidth;
    }

    public double getMaterialCost() {
        return materialCost;
    }

    public void setMaterialCost(double materialCost) {
        this.materialCost = materialCost;
    }

    public String getEnvironmentalStandard() {
        return environmentalStandard;
    }

    public void setEnvironmentalStandard(String environmentalStandard) {
        this.environmentalStandard = environmentalStandard;
    }

    public String getEngineType() {
        return engineType;
    }

    public void setEngineType(String engineType) {
        this.engineType = engineType;
    }

    public int getNumberOfCylinders() {
        return numberOfCylinders;
    }

    public void setNumberOfCylinders(int numberOfCylinders) {
        this.numberOfCylinders = numberOfCylinders;
    }

    public int getGearAmount() {
        return gearAmount;
    }

    public void setGearAmount(int gearAmount) {
        this.gearAmount = gearAmount;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }
}
