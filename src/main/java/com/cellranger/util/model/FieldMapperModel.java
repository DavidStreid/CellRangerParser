package com.cellranger.util.model;

import java.util.List;

public abstract class FieldMapperModel {
    protected List<FieldMapper> fieldMapperList;
    public List<FieldMapper> getFieldMapperList(){
        return fieldMapperList;
    }
}
