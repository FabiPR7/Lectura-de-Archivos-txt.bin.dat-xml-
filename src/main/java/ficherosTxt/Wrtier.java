/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package ficherosTxt;

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
public class Wrtier {

    public static void main(String[] args) {
    //  para crear una instancia File 
        File f = new File("miFcihero.txt");
        try {
      //      aqui creamos el fichero en la ruta antes indicada CON EL createNewFile
            if (f.createNewFile()) {
                System.out.println("Se creo correctamente");
            }
        } catch (IOException ex) {
            System.out.println("Error al crear");
            Logger.getLogger(Wrtier.class.getName()).log(Level.SEVERE, null, ex);
        }
        
      //  Aqui creamos el escritor
        FileWriter fw = null;
        try {
            //apuntamos en que fichero vamos a escribir
            fw = new FileWriter(f);
            //escribimos con el write
            fw.write("Este es mi texto");
        } catch (IOException ex) {
            System.out.println("Error al escribir");
            Logger.getLogger(Wrtier.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            try {
                //Importante cerrar si no, no funciona corrrectamente
                fw.close();
            } catch (IOException ex) {
                Logger.getLogger(Wrtier.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
