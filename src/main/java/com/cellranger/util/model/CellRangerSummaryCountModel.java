package com.cellranger.util.model;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

import com.cellranger.util.model.FieldMapper;

public class CellRangerSummaryCountModel {
    private static List<FieldMapper> fieldMapperList;
    static {
        fieldMapperList = new ArrayList<FieldMapper>(Arrays.asList(
                new FieldMapper("h1", "Estimated Number of Cells", ""),
                new FieldMapper("h2", "Mean Reads per Cell", ""),
                new FieldMapper("h2", "Median Genes per Cell", ""),
                new FieldMapper("td", "Number of Reads", ""),
                new FieldMapper("td", "Valid Barcodes", ""),
                new FieldMapper("td", "Sequencing Saturation", ""),
                new FieldMapper("td", "Q30 Bases in Barcode", ""),
                new FieldMapper("td", "Q30 Bases in RNA Read", ""),
                new FieldMapper("td", "Q30 Bases in Sample Index", ""),
                new FieldMapper("td", "Q30 Bases in UMI", ""),
                new FieldMapper("td", "Reads Mapped to Genome", ""),
                new FieldMapper("td", "Reads Mapped Confidently to Genome", ""),
                new FieldMapper("td", "Reads Mapped Confidently to Intergenic Regions", ""),
                new FieldMapper("td", "Reads Mapped Confidently to Intronic Regions", ""),
                new FieldMapper("td", "Reads Mapped Confidently to Exonic Regions", ""),
                new FieldMapper("td", "Reads Mapped Confidently to Transcriptome", ""),
                new FieldMapper("td", "Reads Mapped Antisense to Gene", ""),
                new FieldMapper("td", "Estimated Number of Cells", ""),
                new FieldMapper("td", "Fraction Reads in Cells", ""),
                new FieldMapper("td", "Median Genes per Cell", ""),
                new FieldMapper("td", "Total Genes Detected", ""),
                new FieldMapper("td", "Median UMI Counts per Cell", ""),
                new FieldMapper("td", "Name", ""),
                new FieldMapper("td", "Description", ""),
                new FieldMapper("td", "Transcriptome", ""),
                new FieldMapper("td", "Chemistry", ""),
                new FieldMapper("td", "Cell Ranger Version", "")
                // new FieldMapper(),
        ));
    }

    public static List<FieldMapper> getFieldMapperList() {
        return fieldMapperList;
    }
}
