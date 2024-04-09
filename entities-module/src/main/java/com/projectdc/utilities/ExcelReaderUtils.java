package com.projectdc.utilities;

import com.projectdc.entities.Address;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;

import com.projectdc.request.PostAddressRequest;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReaderUtils {

    public static List<Address> getExcelAddress(PostAddressRequest request) {
        List<Address> excelAddress = new ArrayList<>();
        int limit = request.getLimit();

        String[] columnName = request.columnName.replaceAll("\\s*,\\s*", ",").split(",");

        try (FileInputStream file = new FileInputStream(request.path);
             Workbook workbook = new XSSFWorkbook(file)) {
            Sheet sheet = workbook.getSheet(request.sheet);

            Map<String, Integer> headerName = columnIndexes(sheet.getRow(0));

            for (Row row : sheet) {
                if (row.getRowNum() == 0) {
                    continue;
                } else if (limit != 0 & row.getRowNum() == limit + 1) {
                    break;
                }

                excelAddress.add(Address.builder()
                        .code(
                                parseString(row.getCell(headerName.get(columnName[0])), 10))
                        .name(
                                parseString(row.getCell(headerName.get(columnName[1])), 50))
                        .correspondenceCode(
                                parseString(row.getCell(headerName.get(columnName[2])), 10))
                        .geographicLevel(
                                parseString(row.getCell(headerName.get(columnName[3])), 10))
                        .oldName(
                                parseString(row.getCell(headerName.get(columnName[4])), 50))
                        .cityClass(
                                parseString(row.getCell(headerName.get(columnName[5])), 5))
                        .incomeClass(
                                parseString(row.getCell(headerName.get(columnName[6])), 3))
                        .urbanRural(
                                parseString(row.getCell(headerName.get(columnName[7])), 1))
                        .population(
                                parsePopulation(row.getCell(headerName.get(columnName[8]))))
                        .status(
                                parseString(row.getCell(headerName.get(columnName[9])), 10))
                        .build());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return excelAddress;
    }

    /**
     * return the map row index and header name
     *
     * @param rowHeader row
     * @return Map&lt;String, Integer&gt;
     */
    private static Map<String, Integer> columnIndexes(Row rowHeader) {
        Map<String, Integer> headerName = new HashMap<>();
        short columnCount = rowHeader.getLastCellNum();

        for (int i = 0; i < columnCount; i++) {
            headerName.put(rowHeader.getCell(i).toString(), i);
        }

        return headerName;
    }

    /**
     * Parse the Population of Excel data
     *
     * @param cell
     * @return
     */
    private static int parsePopulation(Cell cell) {
        int cellPopulation = 0;
        try {
            cellPopulation = Integer.parseInt(
                    cell.toString()
                            .replaceAll("\\.0*$", "")
                            .replaceAll("[^0-9]", "")
            );
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        return cellPopulation;
    }

    /**
     * @param cell Cell
     * @param maxLength int    --Max length of database column
     * @return String
     */
    private static String parseString(Cell cell, int maxLength){
        if(cell == null){
            return "";
        }
        return cell.toString().substring(
                0, Math.min(maxLength, cell.toString().length())
        );
    }
}
