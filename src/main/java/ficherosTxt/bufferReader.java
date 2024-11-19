/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ficherosTxt;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author fabia
 */
public class bufferReader {

    //es una manera mas facil de leer 
    public static void main(String[] args) {
        //necesitamos esto para escribir
        File f = new File("mi archivo con buffer.txt");
      
        //para leer
        BufferedReader br = null;
        try {
            
            br = new BufferedReader(new FileReader(f));
            //buffer lee por lineas
            String linea;
            //leemos uno por uno, devolvera null cuando no haya que leer
            while((linea=br.readLine()) != null ){
                System.out.println(linea);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(bufferReader.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(bufferReader.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            try {//siempre se cierra
                br.close();
            } catch (IOException ex) {
                Logger.getLogger(bufferReader.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }

    }
}
