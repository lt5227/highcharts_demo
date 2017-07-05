package org.flightythought.examples;

import com.itextpdf.text.Document;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.File;
import java.io.FileOutputStream;

/**
 * Copyright 2017 济中节能 All rights reserved.
 * Created by LiLei on 2017/6/19 13:10.
 */
public class SimpleTable {
    public static final String DEST = "results/tables/simple_table.pdf";

    public static void main(String[] args) {
        File file = new File(DEST);
        file.getParentFile().mkdirs();
        new SimpleTable().createPdf(DEST);
    }

    public void createPdf(String dest) {
        try {
            Document document = new Document();
            PdfWriter.getInstance(document, new FileOutputStream(dest));
            document.open();
            PdfPTable table = new PdfPTable(8);
            for (int aw = 0; aw < 16; aw++) {
                table.addCell("hi");
            }
            document.add(table);
            document.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
