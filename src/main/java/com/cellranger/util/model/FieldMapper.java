package com.cellranger.util.model;

public class FieldMapper {
    private String htmlElement;
    private String htmlField;
    private String tableField;

    public FieldMapper(String htmlElement, String htmlField, String tableField) {
        this.htmlElement = htmlElement;
        this.htmlField = htmlField;
        this.tableField = tableField;
    }

    public String getHtmlElement() {
        return htmlElement;
    }
    public String getHtmlField() {
        return htmlField;
    }
    public String getTableField() {
        return tableField;
    }
}