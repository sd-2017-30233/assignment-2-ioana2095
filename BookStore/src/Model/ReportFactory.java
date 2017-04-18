/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Ioana
 */
public class ReportFactory {
    public ReportFile getReportFile(String file){
        if(file.equals(null))
            return null;
        if(file.equals("csv"))
            return new CSVFile(file);
        if(file.equals("pdf"))
            return new PDFFile(file);
    return null;
    }
}
