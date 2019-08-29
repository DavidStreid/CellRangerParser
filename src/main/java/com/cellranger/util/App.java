package com.cellranger.util;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

import java.io.IOException;

import com.cellranger.util.model.FieldMapper;
import com.cellranger.util.controller.CellRangerDatabaseApi;

import com.cellranger.util.model.CountWebSummary;

public class App {
    public static void main(String[] args){
        String fileName = "/PATH/TO/web_summary_count.html";
        try {
            CellRangerDatabaseApi.createSummaryRow(fileName, CountWebSummary.getFieldMapperList());
        } catch(IOException e) {
            System.out.println("ERROR: CellRangerDatabaseApi.createSummaryRow");
            System.out.println(e);
        }

    }
}