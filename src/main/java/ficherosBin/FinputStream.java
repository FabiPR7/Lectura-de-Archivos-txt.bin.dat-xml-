/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ficherosBin;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author fabia
 */
public class FinputStream {
    public static void main(String[] args) {
        File f  = new File("miFichero.bin");
        FileInputStream fis = null;
        
        try {

//+++++++++++++MANERA GUAY++++++++++++++++++++++++++++
            fis = new FileInputStream(f);
            byte[] bytes = fis.readAllBytes();
            String leido = new String(bytes);
            System.out.println(leido);
//++++++++++++++++++++++++++++++++++++++++++++++++++++++
//++++++++++++++MANERA ANTIGUAY++++++++++++++++++++
            fis = new FileInputStream(f);
            int n;
            while((n = fis.read()) != -1){
                System.out.print((char) n);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FinputStream.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(FinputStream.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try {
                fis.close();
            } catch (IOException ex) {
                Logger.getLogger(FinputStream.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        
    }
    }
