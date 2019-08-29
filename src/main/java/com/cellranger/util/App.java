package com.cellranger.util;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

import java.io.IOException;

import com.cellranger.util.model.FieldMapper;
import com.cellranger.util.controller.CellRangerDatabaseApi;

import com.cellranger.util.model.CellRangerSummaryCountModel;

public class App {
    public static void main(String[] args){
        String fileName = "/Users/streidd/code/playground/cell-ranger-util/src/main/java/com/cellranger/util/web_summary_count.html";

        try {
            CellRangerDatabaseApi.createSummaryRow(fileName, CellRangerSummaryCountModel.getFieldMapperList());
        } catch(IOException e) {
            System.out.println("ERROR: CellRangerDatabaseApi.createSummaryRow");
            System.out.println(e);
        }

    }
}