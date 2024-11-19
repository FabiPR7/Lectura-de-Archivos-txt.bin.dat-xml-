/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ficherosTxt;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author fabia
 */
public class Reader {
    public static void main(String[] args) {
          //  para crear una instancia File 
        File f = new File("miFcihero.txt");
             // el reader para leer
        FileReader fr = null;
        try {
            //indicamos de que fichero quremos leer
            fr = new FileReader(f);
            //devuelve el caracter que esta leyendo de manera numerica
            int n;
            while((n=fr.read())!= -1){
                //leemos uno por uno hasta que devuelva -1(es cuando ya no hay nada que leer) 
               //parseamo
                System.out.print((char) n);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Wrtier.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Wrtier.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try {
                //impotrante cerar tambien
                fr.close();
            } catch (IOException ex) {
                Logger.getLogger(Wrtier.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        System.out.println("Fin");
    }
}
