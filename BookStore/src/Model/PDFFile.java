/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.pdfbox.exceptions.COSVisitorException;
import org.pdfbox.pdmodel.PDDocument;
import org.pdfbox.pdmodel.PDPage;
import org.pdfbox.pdmodel.common.PDRectangle;
import org.pdfbox.pdmodel.edit.PDPageContentStream;
import org.pdfbox.pdmodel.font.PDFont;
import org.pdfbox.pdmodel.font.PDType1Font;

/**
 *
 * @author Ioana
 */
public class PDFFile implements ReportFile {

    public PDFFile(String fileName) {
        PDDocument document = null;
        try {
            document = new PDDocument();
        PDPage page = new PDPage();
        document.addPage(page);
        PDPageContentStream contentStream = null;
            contentStream = new PDPageContentStream(document, page);
            contentStream.setFont(PDType1Font.COURIER, 12);
            contentStream.beginText();
            contentStream.endText();
            contentStream.close();
            document.save("Fisier."+fileName);
            document.close();
        } catch (IOException ex) {
            Logger.getLogger(PDFFile.class.getName()).log(Level.SEVERE, null, ex);
        } catch (COSVisitorException ex) {
            Logger.getLogger(PDFFile.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void write(ArrayList<String> raport,String file) {
        PDDocument doc = null;
        try {
        doc = new PDDocument();
        PDPage page = new PDPage();
        doc.addPage(page);
        PDPageContentStream contentStream = new PDPageContentStream(doc, page);

        PDFont pdfFont = PDType1Font.HELVETICA;
        float fontSize = 8;
        float leading = 1.5f * fontSize;

        PDRectangle mediabox = page.getMediaBox();
        float margin = 50;
        float width = mediabox.getWidth() - 2*margin;
        float startX = mediabox.getLowerLeftX() + margin;
        float startY = mediabox.getUpperRightY() - margin;
        List<String> lines = new ArrayList<String>();
        int lastSpace = -1;
        int i=0;
        while(i<raport.size()){
            String text=raport.get(i);
            while (text.length() > 0)
            {
                int spaceIndex = text.indexOf(' ', lastSpace + 1);
                if (spaceIndex < 0)
                    spaceIndex = text.length();
                String subString = text.substring(0, spaceIndex);
                float size = (float) (fontSize * 0.001);
                //System.out.printf("'%s' - %f of %f\n", subString, size, width);
                if (size > width)
                {
                    if (lastSpace < 0)
                        lastSpace = spaceIndex;
                    subString = text.substring(0, lastSpace);
                    lines.add(subString);
                    text = text.substring(lastSpace).trim();
                   // System.out.printf("'%s' is line\n", subString);
                    lastSpace = -1;
                }
                else if (spaceIndex == text.length())
                {
                    lines.add(text);
                    System.out.printf("'%s' is line\n", text);
                    text = "";
                }
                else
                {
                    lastSpace = spaceIndex;
                }
            }
        i++;
        }

        contentStream.beginText();
        contentStream.setFont(pdfFont, fontSize);
        contentStream.moveTextPositionByAmount(startX, startY);            
        for (String line: lines)
        {   
        contentStream.drawString(line);
        contentStream.moveTextPositionByAmount(0, -leading);
        }
        contentStream.endText(); 
        contentStream.close();
        
        // Save the results and ensure that the document is properly closed:
        doc.save("Fisier."+file);
        doc.close();
        }catch (IOException ex) {
            Logger.getLogger(PDFFile.class.getName()).log(Level.SEVERE, null, ex);
        } catch (COSVisitorException ex) {
            Logger.getLogger(PDFFile.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
 
}
