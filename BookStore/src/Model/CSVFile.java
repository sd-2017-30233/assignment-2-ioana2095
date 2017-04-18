/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ioana
 */
public class CSVFile implements ReportFile {

    public CSVFile(String fileName) {
        File newFile = new File("Fisier."+fileName);
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(newFile));
        } catch (IOException ex) {
            Logger.getLogger(CSVFile.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void write(ArrayList<String> raport,String file) {
        PrintWriter pw = null;
        try {
            pw = new PrintWriter(new File("Fisier."+file));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(CSVFile.class.getName()).log(Level.SEVERE, null, ex);
        }
        for(int i=0;i<raport.size();i++){
        pw.write(raport.get(i));
        }
        pw.close();
        System.out.println("done!");
    }

    
}
