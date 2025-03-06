package com.sm.vidyut_nigam.service.consumer.excel;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import com.sm.vidyut_nigam.dto.consumer.ConsumerRequestDTO;

import jakarta.persistence.criteria.CriteriaBuilder.In;

import java.io.InputStream;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ConsumerExcelHelper {

    public static String EXCEL_TYPE = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";

    public static boolean hasExcelFormat(MultipartFile file) {
        return EXCEL_TYPE.equals(file.getContentType());
    }

    public static List<ConsumerRequestDTO> excelToConsumers(InputStream is) {
        try {
            Workbook workbook = new XSSFWorkbook(is);
            Sheet sheet = workbook.getSheetAt(0);
            Iterator<Row> rows = sheet.iterator();
            List<ConsumerRequestDTO> consumers = new ArrayList<>();

            boolean firstRow = true;

            while (rows.hasNext()) {
                Row currentRow = rows.next();

                // Skip the header row
                if (firstRow) {
                    firstRow = false;
                    continue;
                }

                ConsumerRequestDTO consumer = new ConsumerRequestDTO();

                // consumer.setConsumerId(getStringCellValue(currentRow, 0));
                // consumer.setConsumerAccountNo(getStringCellValue(currentRow, 1));
                consumer.setType(getStringCellValue(currentRow, 2));
                consumer.setConsumerConnectionType(getStringCellValue(currentRow, 3));
                consumer.setLegacyConsumerNo(getStringCellValue(currentRow, 4));
                consumer.setConsumerName(getStringCellValue(currentRow, 5));
                consumer.setConsumerContactNo(getStringCellValue(currentRow, 6));
                consumer.setConsumerEmail(getStringCellValue(currentRow, 7));
                consumer.setConsumerCommunicationPreference(getStringCellValue(currentRow, 8));
                consumer.setConsumerConnectionPhase(getStringCellValue(currentRow, 9));
                consumer.setConsumerIndustryName(getStringCellValue(currentRow, 10));
                consumer.setConsumerPaymentMode(getStringCellValue(currentRow, 11));
                consumer.setConsumerType(getStringCellValue(currentRow, 12));
                consumer.setConsumerCategory(getStringCellValue(currentRow, 13));
                consumer.setConsumerPurpose(getStringCellValue(currentRow, 14));
                consumer.setConsumerTariff(getStringCellValue(currentRow, 15));
                consumer.setConsumerMetering(getStringCellValue(currentRow, 16));

                consumer.setConsumerContractDemand(getNumericCellValue(currentRow, 17));
                consumer.setConsumerContractDemandUOM(getStringCellValue(currentRow, 18));
                consumer.setConsumerSanctionLoad(getNumericCellValue(currentRow, 19));
                consumer.setConsumerSanctionLoadUOM(getStringCellValue(currentRow, 20));
                consumer.setConsumerSupplyVoltageKV(getNumericCellValue(currentRow, 21));

                consumer.setConsumerConnectionDate(getDateCellValue(currentRow, 22));
                consumer.setConsumerConnectionStatus(getStringCellValue(currentRow, 23));
                consumer.setConsumerLastDisconnectedDate(getDateCellValue(currentRow, 24));
                consumer.setConsumerLastReconnectedDate(getDateCellValue(currentRow, 25));
                consumer.setConsumerConnectionClosedDate(getDateCellValue(currentRow, 26));

                consumer.setConsumerTemporary(getBooleanCellValue(currentRow, 27));
                consumer.setConsumerMinBillDemand(getNumericCellValue(currentRow, 28));
                consumer.setConsumerBillingId(getStringCellValue(currentRow, 29));
                consumer.setConsumerMeterDevices(getStringCellValue(currentRow, 30));
                consumer.setConsumerSearchLocation(getStringCellValue(currentRow, 31));
                consumer.setConsumerLongitude(getNumericCellValue(currentRow, 32));
                consumer.setConsumerLatitude(getNumericCellValue(currentRow, 33));

                consumer.setConsumerSiteAddress(getStringCellValue(currentRow, 34));
                consumer.setConsumerSiteState(getStringCellValue(currentRow, 35));
                consumer.setConsumerSiteCity(getStringCellValue(currentRow, 36));
                consumer.setConsumerSitePinCode(getStringCellValue(currentRow, 37));
                consumer.setConsumerSiteEmail(getStringCellValue(currentRow, 38));
                consumer.setConsumerSiteContactNo(getStringCellValue(currentRow, 39));

                consumer.setConsumerBillAddress(getStringCellValue(currentRow, 40));
                consumer.setConsumerBillState(getStringCellValue(currentRow, 41));
                consumer.setConsumerBillCity(getStringCellValue(currentRow, 42));
                consumer.setConsumerBillPinCode(getStringCellValue(currentRow, 43));
                consumer.setConsumerBillEmail(getStringCellValue(currentRow, 44));
                consumer.setConsumerBillContactNo(getStringCellValue(currentRow, 45));

                consumer.setConsumerExistingMeterNo(getStringCellValue(currentRow, 46));
                consumer.setConsumerExistingMeterType(getStringCellValue(currentRow, 47));
                consumer.setConsumerExistingMeterMF(getNumericCellValue(currentRow, 48));
                consumer.setConsumerExistingMeterSealStatus(getStringCellValue(currentRow, 49));
                consumer.setConsumerExistingLoad(getNumericCellValue(currentRow, 50));
                consumer.setConsumerLastMeterReading(getNumericCellValue(currentRow, 51));
                consumer.setConsumerLineLTCTRatio(getStringCellValue(currentRow, 52));
                consumer.setConsumerExistingMeterLocation(getStringCellValue(currentRow, 53));
                consumer.setConsumerChangeOfMeterLocationEnvisaged(getBooleanCellValue(currentRow, 54));
                consumer.setConsumerMeterBoxDimensions(getStringCellValue(currentRow, 55));
                consumer.setConsumerNoOfMetersAtSingleLocation((int) getNumericCellValue(currentRow, 56));
                consumer.setConsumerMeterLegalStatus(getStringCellValue(currentRow, 57));
                consumer.setConsumerClubbingOfMeters(getBooleanCellValue(currentRow, 58));

                consumer.setConsumerDateOfConnection(getDateCellValue(currentRow, 59));
                consumer.setConsumerRemarks(getStringCellValue(currentRow, 60));

                Cell cell = currentRow.getCell(61);

                if (cell.getCellType() == CellType.STRING) {
                    String sectionValue = getStringCellValue(currentRow, 61);
                    consumer.setSection(Integer.parseInt(sectionValue));
                } else {
                    double sectionValue = getNumericCellValue(currentRow, 61);
                    consumer.setSection((int) sectionValue);
                }

                Cell cell1 = currentRow.getCell(62);

                if (cell1.getCellType() == CellType.STRING) {
                    String transformerValue = getStringCellValue(currentRow, 62);
                    consumer.setTransformer(Integer.parseInt(transformerValue));
                } else {
                    double transformerValue = getNumericCellValue(currentRow, 62);
                    consumer.setTransformer((int) transformerValue);

                }

                consumers.add(consumer);
            }

            workbook.close();
            return consumers;
        } catch (Exception e) {
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

    private static Boolean getBooleanCellValue(Row row, int columnIndex) {
        Cell cell = row.getCell(columnIndex);
        return (cell != null && cell.getCellType() == CellType.BOOLEAN) ? cell.getBooleanCellValue() : false;
    }
}
