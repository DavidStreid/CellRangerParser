package com.cellranger.util.model;

public class FieldMapper {
    private String htmlElement;
    private String htmlField;
    private String tableField;
    private Class type;

    public FieldMapper(String htmlElement, String htmlField, String tableField, Class type) {
        this.htmlElement = htmlElement;
        this.htmlField = htmlField;
        this.tableField = tableField;
        this.type = type;
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
    public Class getType() { return type; }
}