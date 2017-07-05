package org.flightythought.examples;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Copyright 2017 济中节能 All rights reserved.
 * Created by LiLei on 2017/6/19 13:16.
 */
public class SmallTable {
    public static final String DEST = "results/tables/small_table.pdf";

    public static void main(String[] args) throws IOException, DocumentException {
        File file = new File(DEST);
        file.getParentFile().mkdirs();
        new SmallTable().createPdf(DEST);
    }

    public void createPdf(String dest) {
        try {
            Rectangle small = new Rectangle(290, 100);
            Font smallfont = new Font(Font.FontFamily.HELVETICA, 10);
            Document document = new Document(small, 5, 5, 5, 5);
            PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(dest));
            document.open();
            PdfPTable table = new PdfPTable(2);
            table.setTotalWidth(new float[]{160, 120});
            table.setLockedWidth(true);
            PdfContentByte cb = writer.getDirectContent();
            // first row
            PdfPCell cell = new PdfPCell(new Phrase("Some text here"));
            cell.setFixedHeight(30);
            cell.setBorder(Rectangle.NO_BORDER);
            cell.setColspan(2);
            table.addCell(cell);
            // second row
            cell = new PdfPCell(new Phrase("Some more text", smallfont));
            cell.setFixedHeight(30);
            cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
            cell.setBorder(Rectangle.NO_BORDER);
            table.addCell(cell);
            Barcode128 code128 = new Barcode128();
            code128.setCode("14785236987541");
            code128.setCodeType(Barcode128.CODE128);
            Image code128Image = code128.createImageWithBarcode(cb, null, null);
            cell = new PdfPCell(code128Image, true);
            cell.setBorder(Rectangle.NO_BORDER);
            cell.setFixedHeight(30);
            table.addCell(cell);
            // third row
            table.addCell(cell);
            cell = new PdfPCell(new Phrase("and something else here", smallfont));
            cell.setBorder(Rectangle.NO_BORDER);
            cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
            table.addCell(cell);
            document.add(table);
            document.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
