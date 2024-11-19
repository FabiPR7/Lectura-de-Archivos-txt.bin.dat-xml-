/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ficherosTxt;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author fabia
 */
public class bufferWriter {
    public static void main(String[] args) {
         //necesitamos esto para escribir
        File f = new File("mi archivo con buffer.txt");
        BufferedWriter bw = null;
        
        try {
            bw = new BufferedWriter(new FileWriter(f));
            bw.write("Hola este es mi archivo con BufferredWriter");
            bw.newLine();
            bw.write("Hola");
        } catch (IOException ex) {
            Logger.getLogger(bufferReader.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try {
                bw.close();
            } catch (IOException ex) {
                Logger.getLogger(bufferWriter.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }
}
