package com.cellranger.util;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import javax.script.*;

import java.io.IOException;

/**
 * Hello world!
 *
 */
public class App
{
    public static void main( String[] args ) throws IOException
    {
        // Requires full path
        File input = new File("/Users/streidd/code/playground/cell-ranger-util/src/main/java/com/cellranger/util/web_summary.html");

        Document doc = Jsoup.parse(input, "UTF-8", "");

        Elements scripts = doc.select("script");
        for (Element script : scripts) {
            // TODO
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
