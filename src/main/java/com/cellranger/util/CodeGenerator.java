package com.cellranger.util;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

import java.io.BufferedWriter;
import java.io.FileWriter;

import com.cellranger.util.model.CellRangerSummaryCountModel;
import com.cellranger.util.model.CellRangerSummaryVDJModel;
import com.cellranger.util.model.FieldMapper;
import com.cellranger.util.model.FieldMapperModel;

import java.io.IOException;



public class CodeGenerator {
    private static Map<String, FieldMapperModel> daoFileMap = new HashMap<String, FieldMapperModel>();
    private static String SCHEMA_FILE = "/PATH/TO/cell-ranger-util/src/main/java/com/cellranger/util/dao/README.md";

    static {
        /* The key is the name of the table, i.e. "CellRangerSummary" -> "cellrangersummary" table */
        daoFileMap.put("CellRangerSummaryCount", new CellRangerSummaryCountModel());
        daoFileMap.put("CellRangerSummaryVdj", new CellRangerSummaryVDJModel());
    }

    public static void main(String[] args){
        MarkdownGenerator.removeMarkdownFile(SCHEMA_FILE);
        for (Map.Entry<String,FieldMapperModel> entry : daoFileMap.entrySet()) {
            // TODO - Generate the markdown for each DAO file
            try {
                DaoCodeGenerator.generateDaoFile(entry.getKey(), entry.getValue());
                MarkdownGenerator.writeMarkdown(SCHEMA_FILE, entry.getKey(), entry.getValue());
            } catch (IOException e) {
                System.out.println("ERROR: Failed to generate code");
                System.out.println(e);
            }
        }
    }
}