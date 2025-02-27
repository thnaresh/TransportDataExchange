package com.transportdataexchange.bogdan.service;

import com.transportdataexchange.bogdan.model.BusData;
import com.transportdataexchange.bogdan.repository.BusDataRepository;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class BusDataService {

    @Autowired
    private BusDataRepository busDataRepository;
/*
 @Transactional
    public void uploadBusData(MultipartFile file) throws IOException {
        // Read Excel File
        Workbook workbook = new XSSFWorkbook(file.getInputStream());
        Sheet sheet = workbook.getSheetAt(0);

        List<BusData> busDataList = new ArrayList<>();

        // Skip header row (Assuming first row is header)
        for (int i = 1; i <= sheet.getLastRowNum(); i++) {
            Row row = sheet.getRow(i);

            if (row == null) continue;  // Skip empty rows

            BusData busData = new BusData();

            // Safely retrieve and set each field
            busData.setIdTrim((int) getNumericValue(row.getCell(0)));  // Numeric
            busData.setMake(getStringValue(row.getCell(1)));            // Text
            busData.setModel(getStringValue(row.getCell(2)));           // Text
            busData.setSeries(getStringValue(row.getCell(3)));          // Text
            busData.setClassBus(getStringValue(row.getCell(4)));        // Text
            busData.setAppointment(getStringValue(row.getCell(5)));     // Text
            busData.setTotalSeats(getStringValue(row.getCell(6)));      // Text (since it can be like "33 (19)")
            busData.setDoorWidth( getIntegerValue(row.getCell(7)));
            busData.setMaterialCost(getNumericValue(row.getCell(8)));   // Numeric
            busData.setEngineType(getStringValue(row.getCell(9)));     // Text
            busData.setNumberOfCylinders( getIntegerValue(row.getCell(10)));
            busData.setAmountOfGear(getIntegerValue(row.getCell(11)));

            // Add the filled object to the list
            busDataList.add(busData);
        }

        // Save all data to the database
        if (!busDataList.isEmpty()) {
            busDataRepository.saveAll(busDataList);
        }

        workbook.close();
    }

    // Improved getNumericValue Method
    private double getNumericValue(Cell cell) {
        if (cell == null) {
            return 0;
        }
        if (cell.getCellType() == CellType.NUMERIC) {
            return cell.getNumericCellValue();
        } else if (cell.getCellType() == CellType.STRING) {
            String value = cell.getStringCellValue().trim();
            // Extract number, ignoring text in parentheses
            value = value.replaceAll("\\(.*?\\)", "").trim();
            if (!value.isEmpty() && value.matches("-?\\d+(\\.\\d+)?")) {
                return Double.parseDouble(value);
            }
        }
        return 0;
    }

    // Improved getStringValue Method
    private String getStringValue(Cell cell) {
        if (cell == null) {
            return "";
        }
        StringBuilder value = new StringBuilder();
        switch (cell.getCellType()) {
            case STRING:
                value.append(cell.getStringCellValue().trim());
                break;
            case NUMERIC:
                value.append(cell.getNumericCellValue());
                break;
            case BOOLEAN:
                value.append(cell.getBooleanCellValue());
                break;
            default:
                value.append("");
        }
        return value.toString();
    }
    private Integer getIntegerValue(Cell cell) {
        if (cell == null) {
            return 0;
        }
        if (cell.getCellType() == CellType.NUMERIC) {
            return (int) cell.getNumericCellValue();
        } else if (cell.getCellType() == CellType.STRING) {
            String value = cell.getStringCellValue().trim();
            // Check if the string is numeric
            if (!value.isEmpty() && value.matches("-?\\d+")) {
                return Integer.parseInt(value);
            }
        }
        return 0;
    }

*/

    public void save(BusData bus) {
     busDataRepository.save( bus);
    }

    public List<BusData> getExceldata() {
      return   busDataRepository.findAll();
    }
    public void updateMaterialCosts(List<BusData> busOperations) {
        for (BusData operation : busOperations) {
            busDataRepository.findById(operation.getIdTrim()).ifPresent(existing -> {
                existing.setMaterialCost(operation.getMaterialCost());
                busDataRepository.save(existing);
            });
        }
    }
}