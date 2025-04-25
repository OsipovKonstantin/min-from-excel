package com.minfromexcel.service;

import java.io.IOException;

public interface NumberService {
    int getNthMin(String filePath, int n) throws IOException;
}
