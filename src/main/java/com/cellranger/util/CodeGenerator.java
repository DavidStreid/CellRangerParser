package com.cellranger.util;

import java.util.List;
import java.util.Map;
import java.util.HashMap;

import com.cellranger.util.model.CellRangerSummaryCountModel;
import com.cellranger.util.model.CellRangerSummaryVDJModel;
import com.cellranger.util.model.FieldMapper;
import com.cellranger.util.model.FieldMapperModel;

import java.io.IOException;



public class CodeGenerator {
    private static Map<String, FieldMapperModel> daoFileMap = new HashMap<String, FieldMapperModel>();

    static {
        daoFileMap.put("CellRangerSummaryCountDao", new CellRangerSummaryCountModel());
        daoFileMap.put("CellRangerSummaryVDJDao", new CellRangerSummaryVDJModel());
    }

    public static void main(String[] args){
        for (Map.Entry<String,FieldMapperModel> entry : daoFileMap.entrySet()) {
            // TODO - Generate the markdown for each DAO file
            try {
                DaoCodeGenerator.generateDaoFile(entry.getKey(), entry.getValue());
            } catch (IOException e) {
                System.out.println("ERROR: Failed to generate code");
                System.out.println(e);
            }
        }
    }
}