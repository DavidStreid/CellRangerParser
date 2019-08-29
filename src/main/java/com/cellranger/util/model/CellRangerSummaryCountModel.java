package com.cellranger.util.model;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

import com.cellranger.util.model.FieldMapper;

/**
 * SOURCE OF TRUTH - THIS CREATES THE DAO & DOCUMENTATION.
 * If there are changes to the schema or CellRanger output, MODIFY THIS
 */
public class CellRangerSummaryCountModel {
    private static List<FieldMapper> fieldMapperList;
    static {
        fieldMapperList = new ArrayList<FieldMapper>(Arrays.asList(
                new FieldMapper("h1", "Estimated Number of Cells", "EstimatedNumberOfCells", Long.class),
                new FieldMapper("h2", "Mean Reads per Cell", "MeanReadsPerCell", Long.class),
                new FieldMapper("h2", "Median Genes per Cell", "MedianGenesPerCell", Long.class),
                new FieldMapper("td", "Number of Reads", "NumberOfReads", Long.class),
                new FieldMapper("td", "Valid Barcodes", "ValidBarcodes", Float.class),
                new FieldMapper("td", "Sequencing Saturation", "SequencingSaturation", Float.class),
                new FieldMapper("td", "Q30 Bases in Barcode", "Q30BasesInBarcode", Float.class),
                new FieldMapper("td", "Q30 Bases in RNA Read", "Q30BasesinRNARead", Float.class),
                new FieldMapper("td", "Q30 Bases in Sample Index", "Q30BasesInSampleIndex", Float.class),
                new FieldMapper("td", "Q30 Bases in UMI", "Q30BasesInUMI", Float.class),
                new FieldMapper("td", "Reads Mapped to Genome", "ReadsMappedToGenome", Float.class),
                new FieldMapper("td", "Reads Mapped Confidently to Genome", "ReadsMappedConfidentlyToGenome", Float.class),
                new FieldMapper("td", "Reads Mapped Confidently to Intergenic Regions", "ReadsMappedToIntergenicRegions", Float.class),
                new FieldMapper("td", "Reads Mapped Confidently to Intronic Regions", "ReadsMappedToIntronicRegions", Float.class),
                new FieldMapper("td", "Reads Mapped Confidently to Exonic Regions", "ReadsMappedToExonicRegions", Float.class),
                new FieldMapper("td", "Reads Mapped Confidently to Transcriptome", "ReadsMappedToTranscriptome", Float.class),
                new FieldMapper("td", "Reads Mapped Antisense to Gene", "ReadsMappedToGene", Float.class),
                new FieldMapper("td", "Fraction Reads in Cells", "FractionReadsInCells", Float.class),
                new FieldMapper("td", "Total Genes Detected", "TotalGenesDetected", Long.class),
                new FieldMapper("td", "Median UMI Counts per Cell", "MedianUMICountsPerCell", Long.class),
                new FieldMapper("td", "Name", "Name", String.class),
                // new FieldMapper("td", "Description", "Description", String.class),
                new FieldMapper("td", "Transcriptome", "Transcriptome", String.class),
                new FieldMapper("td", "Chemistry", "Chemistry", String.class),
                new FieldMapper("td", "Cell Ranger Version", "CellRangerVersion", String.class)
        ));
    }

    public static List<FieldMapper> getFieldMapperList() {
        return fieldMapperList;
    }
}
