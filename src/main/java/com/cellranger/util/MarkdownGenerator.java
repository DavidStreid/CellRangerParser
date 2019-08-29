package com.cellranger.util;

import com.cellranger.util.model.FieldMapper;
import com.cellranger.util.model.FieldMapperModel;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class MarkdownGenerator {
    private static File outputFile = new File(getOutputPath().toUri());

    public static boolean removeMarkdownFile(String schemaFile) {
        File file = new File(schemaFile);
        if(file.delete())
        {
            System.out.println("File deleted successfully");
            return true;
        }
        System.out.println("Failed to delete the file");
        return false;
    }

    private static Path getOutputPath() {
        return Paths.get(new File(".").getAbsolutePath() + "/src/main/java");
    }
    private static String generateMarkDownTable(String daoName, FieldMapperModel fieldMapperModel){
        List<FieldMapper> fieldMapperList = fieldMapperModel.getFieldMapperList();
        String markdownTable = String.format(   "#%s\n" +
                "| Html Element | Html Label | Table Field | Table Type |\n" +
                "| ------------ | ---------- | ----------- | ---------- |\n", daoName);
        for(FieldMapper fm : fieldMapperList){
            markdownTable = String.format("%s| %s | %s | %s | %s |\n", markdownTable, fm.getHtmlElement(), fm.getHtmlField(), fm.getTableField(), fm.getType());
        }
        return markdownTable;
    }

    public static void writeMarkdown(String markdownFileName, String daoName, FieldMapperModel fieldMapperModel){
        String markDownTable = generateMarkDownTable(daoName, fieldMapperModel);
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(markdownFileName, true));
            writer.write(markDownTable);
            writer.close();
        } catch(IOException e) {
            System.out.println(e);
        }
    }
}
