package com.cellranger.util.controller;

import java.util.List;
import java.io.File;
import java.io.IOException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.cellranger.util.model.FieldMapper;
import com.cellranger.util.model.FieldMapperModel;

public class CellRangerDatabaseApi {
    public static void createSummaryRow(String fileName, FieldMapperModel fieldMapperModel) throws IOException {
        // Requires full path
        File input = new File(fileName);
        Document doc = Jsoup.parse(input, "UTF-8", ""); // TODO - throws warning

        Element value;
        String identifier;
        List<FieldMapper> fieldMapperList = fieldMapperModel.getFieldMapperList();
        for(FieldMapper fm : fieldMapperList){
            identifier = String.format("%s:contains(%s)",fm.getHtmlElement(),fm.getHtmlField());
            Elements matches = doc.select(identifier);
            // TODO - error checking for multiple matches
            for (Element label : matches) {
                value = label.nextElementSibling​();  // value follows field in html document
                print(" * a: <%s>  (%s)", value.attr("class"), trim(value.text(), 35));
            }
        }
    }

    private static void print(String msg, Object... args) {
        System.out.println(String.format(msg, args));
    }

    private static String trim(String s, int width) {
        if (s.length() > width)
            return s.substring(0, width-1) + ".";
        else
            return s;
    }
}