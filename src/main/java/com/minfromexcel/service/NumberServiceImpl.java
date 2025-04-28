package com.minfromexcel.service;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class NumberServiceImpl implements NumberService {
    @Override
    public int getNthMin(String filePath, int n) throws IOException {
        if (n < 1) {
            throw new IllegalArgumentException("Укажите положительное N");
        }
        MaxHeap maxHeap = new MaxHeap(n);

        try (FileInputStream file = new FileInputStream(new File(filePath));
             Workbook workbook = new XSSFWorkbook(file)) {
            Sheet sheet = workbook.getSheetAt(0);
            for (Row row : sheet) {
                Cell cell = row.getCell(0);
                if (cell == null) break;
                maxHeap.add((int) cell.getNumericCellValue());
            }
        }
        if (maxHeap.size() < n) {
            throw new IllegalArgumentException("Недостаточно уникальных чисел в файле.");
        }
        return maxHeap.getAndRemoveMax();
    }
}

class MaxHeap {
    private final List<Integer> heap;
    private final int maxSize;

    public MaxHeap(int n) {
        this.heap = new ArrayList<>();
        maxSize = n;
    }

    public void add(int num) {
        heap.add(num);
        int size = heap.size();
        int cur = size - 1;

        while (cur != 0 && heap.get(cur) > heap.get((cur - 1) / 2)) {
            swapByIndexes(cur, (cur - 1) / 2);
            cur = (cur - 1) / 2;
        }
        if (size > maxSize) {
            getAndRemoveMax();
        }
    }

    private void swapByIndexes(int first, int second) {
        int temp = heap.get(first);
        heap.set(first, heap.get(second));
        heap.set(second, temp);
    }

    public int getAndRemoveMax() {
        int max = heap.get(0);
        int size = heap.size() - 1;
        swapByIndexes(size, 0);
        heap.remove(size);

        int top = 0;
        while ((top * 2 + 1 < size && heap.get(top) < heap.get(top * 2 + 1))
                || (top * 2 + 2 < size && heap.get(top) < heap.get(top * 2 + 2))) {
            if (top * 2 + 2 == size || heap.get(top * 2 + 1) > heap.get(top * 2 + 2)) {
                swapByIndexes(top, top * 2 + 1);
                top = top * 2 + 1;
            } else {
                swapByIndexes(top, top * 2 + 2);
                top = top * 2 + 2;
            }
        }
        return max;
    }

    public int size() {
        return heap.size();
    }
}