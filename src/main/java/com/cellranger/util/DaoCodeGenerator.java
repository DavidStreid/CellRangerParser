package com.cellranger.util;

import java.util.List;

import com.squareup.javapoet.ClassName;
import com.squareup.javapoet.CodeBlock;
import com.squareup.javapoet.FieldSpec;
import com.squareup.javapoet.JavaFile;
import com.squareup.javapoet.MethodSpec;
import com.squareup.javapoet.ParameterSpec;
import com.squareup.javapoet.ParameterizedTypeName;
import com.squareup.javapoet.TypeName;
import com.squareup.javapoet.TypeSpec;
import com.squareup.javapoet.TypeSpec.Builder;
import com.squareup.javapoet.FieldSpec;
import com.squareup.javapoet.AnnotationSpec;

import javax.lang.model.element.Modifier;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.IntStream;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;

import com.cellranger.util.model.FieldMapper;
import com.cellranger.util.model.CellRangerSummaryCountModel;

public class DaoCodeGenerator {
    private static String WARNING =
    "******************************************************************************\n" +
    "******************************** DO NOT EDIT *********************************\n" +
    "******************************************************************************";

    private static File outputFile = new File(getOutputPath().toUri());
    private static final String FOUR_WHITESPACES = "    ";
    private static final String DAO_PACKAGE_NAME = "com.cellranger.util.dao";

    public static String getPersonPackageName() {
        return DAO_PACKAGE_NAME;
    }

    public static Path getOutputPath() {
        return Paths.get(new File(".").getAbsolutePath() + "/src/main/java");
    }

    private static TypeSpec createTypeSpec(String fileName, List<FieldMapper> fieldMappers) {
        Builder builder = TypeSpec
                .classBuilder(fileName)
                .addJavadoc(WARNING)
                .addAnnotation(Entity.class)
                .addModifiers(Modifier.PUBLIC);

        for(FieldMapper fm : fieldMappers)
            builder.addField(getFieldSpec(fm));

        return builder.build();
    }

    private static FieldSpec getFieldSpec(FieldMapper fieldMapper){
        final Class type = fieldMapper.getType();

        com.squareup.javapoet.FieldSpec.Builder fieldBuilder = FieldSpec
                .builder(fieldMapper.getType(), fieldMapper.getTableField())
                .addModifiers(Modifier.PUBLIC);

        // No string field should exceed 64 characters
        if(type == String.class){
            fieldBuilder.addAnnotation(AnnotationSpec.builder(Column.class)
                    .addMember("length", "64")
                    .build());
        }

        return fieldBuilder.build();
    }

    public static void generateDaoFile(String fileName, List<FieldMapper> fieldMapperList) throws IOException {
        TypeSpec typeSpec = createTypeSpec(fileName, fieldMapperList);
        writeToOutputFile(getPersonPackageName(), typeSpec);
    }

    private static void writeToOutputFile(String packageName, TypeSpec typeSpec) throws IOException {
        JavaFile javaFile = JavaFile
                .builder(packageName, typeSpec)
                .indent(FOUR_WHITESPACES)
                .build();
        javaFile.writeTo(outputFile);
    }
}