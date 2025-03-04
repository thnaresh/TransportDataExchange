package com.transportdataexchange.bogdan.service;

import com.transportdataexchange.bogdan.model.BusData;
import com.transportdataexchange.bogdan.model.TrailerData;
import com.transportdataexchange.bogdan.repository.BusDataRepository;
import com.transportdataexchange.bogdan.repository.TrailerDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrailerDataService {
    @Autowired
    private TrailerDataRepository tdatarepo;

    public void savedata(TrailerData ts) {
        tdatarepo.save(ts);
    }

    public List<TrailerData> getExceldata() {
        return tdatarepo.findAll();
    }
}

