package com.minfromexcel.service;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.PriorityQueue;

@Service
public class NumberServiceImpl implements NumberService {
    @Override
    public int getNthMin(String filePath, int n) throws IOException {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>((a, b) -> b - a);

        try (FileInputStream file = new FileInputStream(new File(filePath));
             Workbook workbook = new XSSFWorkbook(file)) {
            Sheet sheet = workbook.getSheetAt(0);
            for (Row row : sheet) {
                for (Cell cell : row) {
                    if (cell.getCellType() == CellType.NUMERIC) {
                        minHeap.offer((int) cell.getNumericCellValue());
                        if (minHeap.size() > n) {
                            minHeap.poll();
                        }
                    }
                }
            }
        }
        if (minHeap.size() < n) {
            throw new IllegalArgumentException("Недостаточно уникальных чисел в файле.");
        }
        return minHeap.peek();
    }
}
