package com.transportdataexchange.bogdan.model;

import javax.persistence.Entity;
import javax.persistence.Id;
@Entity
public class TrailerData {
    @Id
    private Integer idTrim;
    private String make;
    private String model;
    private String series;
    private String typeOfTrailer;
    private Integer payloadKg;
    private String usefulVolume;
    private String lengthOfPlatform;
    private String heightWithAwning;
    private String loadingHeight;
    private String numberOfWheelsSpare;



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

    public String getTypeOfTrailer() {
        return typeOfTrailer;
    }

    public void setTypeOfTrailer(String typeOfTrailer) {
        this.typeOfTrailer = typeOfTrailer;
    }

    public Integer getPayloadKg() {
        return payloadKg;
    }

    public void setPayloadKg(Integer payloadKg) {
        this.payloadKg = payloadKg;
    }

    public String getUsefulVolume() {
        return usefulVolume;
    }

    public void setUsefulVolume(String usefulVolume) {
        this.usefulVolume = usefulVolume;
    }

    public String getLengthOfPlatform() {
        return lengthOfPlatform;
    }

    public void setLengthOfPlatform(String lengthOfPlatform) {
        this.lengthOfPlatform = lengthOfPlatform;
    }

    public String getHeightWithAwning() {
        return heightWithAwning;
    }

    public void setHeightWithAwning(String heightWithAwning) {
        this.heightWithAwning = heightWithAwning;
    }

    public String getLoadingHeight() {
        return loadingHeight;
    }

    public void setLoadingHeight(String loadingHeight) {
        this.loadingHeight = loadingHeight;
    }

    public String getNumberOfWheelsSpare() {
        return numberOfWheelsSpare;
    }

    public void setNumberOfWheelsSpare(String numberOfWheelsSpare) {
        this.numberOfWheelsSpare = numberOfWheelsSpare;
    }




}
