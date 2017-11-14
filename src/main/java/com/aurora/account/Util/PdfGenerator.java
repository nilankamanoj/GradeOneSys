package com.aurora.account.Util;



import com.lowagie.text.DocumentException;
import org.apache.commons.io.FileUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.xhtmlrenderer.pdf.ITextRenderer;

import java.io.*;


public class PdfGenerator {

    private  byte[] toPdf(String html) throws DocumentException, IOException {
        final ITextRenderer renderer = new ITextRenderer();
        renderer.setDocumentFromString(html);
        renderer.layout();
        try (ByteArrayOutputStream fos = new ByteArrayOutputStream(html.length())) {
            renderer.createPDF(fos);
            return fos.toByteArray();
        }
    }

    public boolean generatePdf(String html,String fileName,String folder){
        try {
            FileUtils.writeByteArrayToFile(new File(folder+fileName+".pdf"), toPdf(htmlToXhtml(html)));
        } catch (IOException e) {
            return false;
        } catch (DocumentException e) {
            return true;
        }
        return true;
    }
    private String htmlToXhtml(final String html) {
        Document document = Jsoup.parse(html);
        document.outputSettings().syntax(Document.OutputSettings.Syntax.xml);
        return document.html();
    }


}
