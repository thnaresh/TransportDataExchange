package com.transportdataexchange.bogdan.controller;

import com.transportdataexchange.bogdan.model.BusData;
import com.transportdataexchange.bogdan.model.TrailerData;
import com.transportdataexchange.bogdan.service.BusDataService;
import com.transportdataexchange.bogdan.service.TrailerDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class BristolController {
    @Autowired
    private TrailerDataService tdataService;

    @PostMapping("/Savetdata")
    public ResponseEntity<?> uploadtrailerData(@RequestBody List<TrailerData> updatedData) {
        for (TrailerData ts : updatedData) {
            tdataService.savedata(ts);
        }
        return ResponseEntity.ok().build();
    }
}

