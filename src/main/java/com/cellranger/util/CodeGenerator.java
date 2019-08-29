package com.cellranger.util;

import java.io.IOException;

public class CodeGenerator {
    public static void main(String[] args){
        try {
            DaoCodeGenerator.generateDao();
        } catch(IOException e) {
            System.out.println("ERROR: Failed to generate code");
            System.out.println(e);
        }

    }
}