package com.transportdataexchange.bogdan.controller;

import com.transportdataexchange.bogdan.model.BusData;
import com.transportdataexchange.bogdan.service.BusDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class BovaController {
    @Autowired
    BusDataService bovaservice;

    @ResponseBody
    @GetMapping("/getData")
    public List<BusData> getBusData(){
        return  bovaservice.getExceldata();

    }
    @ResponseBody
    @PostMapping("/updateMaterialCost")
    public ResponseEntity<String> updateMaterialCost(@RequestBody List<BusData> busOperations) {
        bovaservice.updateMaterialCosts(busOperations);
        return ResponseEntity.ok("Material costs updated successfully.");
    }
}
