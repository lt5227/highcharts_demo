package org.flightythought.controller;

import com.itextpdf.text.*;
import com.itextpdf.text.Image;
import com.itextpdf.text.pdf.*;
import org.apache.batik.transcoder.TranscoderInput;
import org.apache.batik.transcoder.TranscoderOutput;
import org.apache.batik.transcoder.image.PNGTranscoder;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

/**
 * Copyright 2017 济中节能 All rights reserved.
 * Created by LiLei on 2017/6/7 16:49.
 */
@Controller
public class HighChartsController {

    @PostMapping("/export")
    @ResponseBody
    public void exportPDF(HttpServletRequest request, HttpServletResponse response, String msg) {
        try {
            // 取得输出流
            OutputStream outputStream = response.getOutputStream();
            // 清空输出流
            response.reset();
            // 弹框选择保存路径和文件名
            response.setHeader("content-disposition", "attachment; filename=PrdVerList.pdf");
            // 定义输出类型
            response.addHeader("Content-Type", "application/pdf");

            PNGTranscoder t = new PNGTranscoder();
            TranscoderInput input = new TranscoderInput(new StringReader(msg));
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            TranscoderOutput output = new TranscoderOutput(byteArrayOutputStream);
            t.transcode(input, output);

            Image image = Image.getInstance(byteArrayOutputStream.toByteArray());

            image.scaleToFit(780, 380);
//            Document document = new Document(new Rectangle(image.getScaledWidth(), image.getScaledHeight()));
            Document document = new Document(PageSize.A4);
            PdfWriter.getInstance(document, outputStream);
            document.open();
            document.add(image);
            Resource resource = new ClassPathResource("simsun.ttc");
            File file = resource.getFile();
            String path = file.getName();
            System.out.println(file.getPath());
            BaseFont bfChinese = BaseFont.createFont(path + ",1", BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
            // 定义字体
            Font fontChinese8 = new Font(bfChinese, 10.0F, 0, new BaseColor(59, 54, 54));
            document.add(new Paragraph(" 你要生成文字写这里", new Font(bfChinese, 8.0F, 1)));
            document.close();


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
