package com.sm.vidyut_nigam.service.meter.excel;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import com.sm.vidyut_nigam.dto.meter.MeterRequestDTO;

import java.io.InputStream;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MeterExcelHelper {

    public static String EXCEL_TYPE = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";

    public static boolean hasExcelFormat(MultipartFile file) {
        return EXCEL_TYPE.equals(file.getContentType());
    }

    public static List<MeterRequestDTO> excelToMeters(InputStream is) {
        try {
            Workbook workbook = new XSSFWorkbook(is);
            Sheet sheet = workbook.getSheetAt(0);
            Iterator<Row> rows = sheet.iterator();
            List<MeterRequestDTO> meters = new ArrayList<>();

            boolean firstRow = true;

            while (rows.hasNext()) {
                Row currentRow = rows.next();

                if (firstRow) {
                    firstRow = false;
                    continue; // Skip the header row
                }

                MeterRequestDTO meter = new MeterRequestDTO();

                meter.setMeterName(getStringCellValue(currentRow, 0));
                meter.setMeterAssetId(getStringCellValue(currentRow, 1));
                meter.setMeterSerialNumber(getStringCellValue(currentRow, 2));
                meter.setMeterSystemTitle(getStringCellValue(currentRow, 3));
                meter.setMeterSubscriptionMode(getStringCellValue(currentRow, 4));
                meter.setMeterState(getStringCellValue(currentRow, 5));
                meter.setMeterProtocol(getStringCellValue(currentRow, 6));
                meter.setMeterInstallationDate(getDateCellValue(currentRow, 7));
                meter.setMeterTestingDate(getDateCellValue(currentRow, 8));
                meter.setMeterManufacturer(getStringCellValue(currentRow, 9));
                meter.setMeterType(getStringCellValue(currentRow, 10));
                meter.setMeterCommunicationType(getStringCellValue(currentRow, 11));
                meter.setMeterHost(getStringCellValue(currentRow, 12));
                meter.setMeterPort((int) getNumericCellValue(currentRow, 13));
                meter.setMeterSecurity(getStringCellValue(currentRow, 14));
                meter.setMeterAuthenticationKey(getStringCellValue(currentRow, 15));
                meter.setMeterBlockCipherKey(getStringCellValue(currentRow, 16));
                meter.setMeterDedicatedKey(getStringCellValue(currentRow, 17));
                meter.setMeterReaderPassword(getStringCellValue(currentRow, 18));
                meter.setMeterUtilityPassword(getStringCellValue(currentRow, 19));
                meter.setMeterFirmwarePassword(getStringCellValue(currentRow, 20));
                meter.setMeterSimNumber(getStringCellValue(currentRow, 21));
                meter.setMeterMobileNumber(getStringCellValue(currentRow, 22));
                meter.setMeterNetworkProvider(getStringCellValue(currentRow, 23));
                meter.setMeterIpAddress(getStringCellValue(currentRow, 24));
                meter.setMeterModemNumber(getStringCellValue(currentRow, 25));
                meter.setMeterModemManufacturer(getStringCellValue(currentRow, 26));
                meter.setMeterModemIMEINumber(getStringCellValue(currentRow, 27));
                meter.setMeterModemInstallationDate(getDateCellValue(currentRow, 28));
                meter.setMeterMCTR(getNumericCellValue(currentRow, 29));
                meter.setMeterMPTR(getNumericCellValue(currentRow, 30));
                meter.setMeterLCTR(getNumericCellValue(currentRow, 31));
                meter.setMeterLPTR(getNumericCellValue(currentRow, 32));
                meter.setMeterMultiplicationFactor(getNumericCellValue(currentRow, 33));
                meter.setMeterPulseRate((int) getNumericCellValue(currentRow, 34));
                meter.setMeterLoad(getNumericCellValue(currentRow, 35));
                meter.setMeterAccuracyClass(getStringCellValue(currentRow, 36));
                meter.setMeterNumberOfDigits((int) getNumericCellValue(currentRow, 37));
                meter.setMeterImportReadingKWH(getNumericCellValue(currentRow, 38));
                meter.setMeterImportReadingKVAH(getNumericCellValue(currentRow, 39));
                String consumerId = getStringCellValue(currentRow, 40);
                meter.setMeterConsumerId(consumerId != null && !consumerId.trim().isEmpty() ? consumerId : null);

                meters.add(meter);
            }

            workbook.close();
            return meters;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to parse Excel file: " + e.getMessage());
        }
    }

    private static String getStringCellValue(Row row, int columnIndex) {
        Cell cell = row.getCell(columnIndex);
        return (cell != null && cell.getCellType() == CellType.STRING) ? cell.getStringCellValue() : "";
    }

    private static double getNumericCellValue(Row row, int columnIndex) {
        Cell cell = row.getCell(columnIndex);
        return (cell != null && cell.getCellType() == CellType.NUMERIC) ? cell.getNumericCellValue() : 0.0;
    }

    private static LocalDateTime getDateCellValue(Row row, int columnIndex) {
        Cell cell = row.getCell(columnIndex);
        return (cell != null && cell.getCellType() == CellType.NUMERIC) ? cell.getLocalDateTimeCellValue() : null;
    }
}
