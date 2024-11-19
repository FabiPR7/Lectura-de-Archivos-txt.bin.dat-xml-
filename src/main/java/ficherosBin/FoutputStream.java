/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ficherosBin;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author fabia
 */
public class FoutputStream {
    public static void main(String[] args) {
            //creamos el File
        File f = new File("miFichero.bin");
          try {
            //creamos el archivo en la ruta
            if (f.createNewFile()) {
                System.out.println("Creado correctamente");
            }
            
        } catch (IOException ex) {
            Logger.getLogger(FoutputStream.class.getName()).log(Level.SEVERE, null, ex);
        }
          
        //PARA ESCRIBIR el:
        FileOutputStream fos = null; 
        String contenido = "Estoy escribiendo en mi archivo binario";
        //MANEERA ANTIGUAY
        //+++++++++++++++++++++++++++++++++++++
        //convertimos el string en array de char
//        char[] bytes = new char[contenido.length()];
//        for (int i = 0; i < bytes.length; i++) {
//            //introducimos caracter a caracter
//            bytes[i] = contenido.charAt(i);
//        }
        try {//inciiamos el fileoutputStream
           if (f.length() > 0) {
                //si ya hay algo escrito el true hace que escribamos despues 
                //de lo escrito y que no se sobreescriba(borre todo y escriba)
                fos = new FileOutputStream(f,true);
            }
            else{
                fos = new FileOutputStream(f);
            }
//            for (int i = 0; i < bytes.length; i++) {
//                // y lo agregamos uno por uno casteando a int cada caracter
//                fos.write((int) bytes[i]);
//            }
            //++++++++++++++++++++++++++++++++++++
            //++++++++++++++++++++++++++++++
            //MANERA SUPERGUAY 
            //ESCRIBIMOS TODO EL TEXTO CONVERTIDO EN BYTES
            fos.write(contenido.getBytes());
            //+++++++++++++++++++++++++++++
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FoutputStream.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(FoutputStream.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try {
                fos.close();
            } catch (IOException ex) {
                Logger.getLogger(FoutputStream.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
      
    }
}
