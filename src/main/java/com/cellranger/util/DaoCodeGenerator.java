package com.cellranger.util;

import com.squareup.javapoet.ClassName;
import com.squareup.javapoet.CodeBlock;
import com.squareup.javapoet.FieldSpec;
import com.squareup.javapoet.JavaFile;
import com.squareup.javapoet.MethodSpec;
import com.squareup.javapoet.ParameterSpec;
import com.squareup.javapoet.ParameterizedTypeName;
import com.squareup.javapoet.TypeName;
import com.squareup.javapoet.TypeSpec;

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

public class DaoCodeGenerator {
    private static File outputFile = new File(getOutputPath().toUri());
    private static final String FOUR_WHITESPACES = "    ";
    private static final String PERSON_PACKAGE_NAME = "com.cellranger.util.dao";

    public static String getPersonPackageName() {
        return PERSON_PACKAGE_NAME;
    }

    public static Path getOutputPath() {
        return Paths.get(new File(".").getAbsolutePath() + "/src/main/java");
    }

    private static TypeSpec test() {
        return TypeSpec
                .classBuilder("Student")
                .addSuperinterface(ClassName.get(PERSON_PACKAGE_NAME, "Person"))
                .addModifiers(Modifier.PUBLIC)
                .addField(FieldSpec
                        .builder(String.class, "name")
                        .addModifiers(Modifier.PRIVATE)
                        .build())
                .addMethod(MethodSpec
                        .methodBuilder("getName")
                        .addAnnotation(Override.class)
                        .addModifiers(Modifier.PUBLIC)
                        .returns(String.class)
                        .addStatement("return this.name")
                        .build())
                .addMethod(MethodSpec
                        .methodBuilder("setName")
                        .addParameter(String.class, "name")
                        .addModifiers(Modifier.PUBLIC)
                        .addStatement("this.name = name")
                        .build())
                .addMethod(getSortByLengthMethod())
                .build();
    }

    public static MethodSpec getSortByLengthMethod() {
        return MethodSpec
                .methodBuilder("sortByLength")
                .addModifiers(Modifier.PUBLIC, Modifier.STATIC)
                .addParameter(ParameterSpec
                        .builder(ParameterizedTypeName.get(ClassName.get(List.class), TypeName.get(String.class)), "strings")
                        .build())
                .addStatement("$T.sort($N, $L)", Collections.class, "strings", getComparatorAnonymousClass())
                .build();
    }

    public static TypeSpec getComparatorAnonymousClass() {
        return TypeSpec
                .anonymousClassBuilder("")
                .addSuperinterface(ParameterizedTypeName.get(Comparator.class, String.class))
                .addMethod(MethodSpec
                        .methodBuilder("compare")
                        .addModifiers(Modifier.PUBLIC)
                        .addAnnotation(Override.class)
                        .addParameter(String.class, "a")
                        .addParameter(String.class, "b")
                        .returns(int.class)
                        .addStatement("return a.length() - b.length()")
                        .build())
                .build();
    }

    public static void generateDao() throws IOException {
        writeToOutputFile(getPersonPackageName(), test());
    }

    private static void writeToOutputFile(String packageName, TypeSpec typeSpec) throws IOException {
        JavaFile javaFile = JavaFile
                .builder(packageName, typeSpec)
                .indent(FOUR_WHITESPACES)
                .build();
        javaFile.writeTo(outputFile);
    }
}