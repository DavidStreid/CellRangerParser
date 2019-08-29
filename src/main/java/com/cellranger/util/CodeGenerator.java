package com.cellranger.util;

import java.util.List;
import java.util.Map;
import java.util.HashMap;

import com.cellranger.util.model.CellRangerSummaryCountModel;
import com.cellranger.util.model.FieldMapper;

import java.io.IOException;



public class CodeGenerator {
    private static Map<String, List<FieldMapper>> daoFileMap = new HashMap<String, List<FieldMapper>>();

    static {
        daoFileMap.put("CellRangerSummaryCountDao", CellRangerSummaryCountModel.getFieldMapperList());
    }

    public static void main(String[] args){
        for (Map.Entry<String,List<FieldMapper>> entry : daoFileMap.entrySet()) {
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