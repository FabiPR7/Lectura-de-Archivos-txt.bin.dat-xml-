/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ficherosDat;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author fabia
 */
public class RandomAccesFileEscritura {

    public static void main(String[] args) {
        File f = new File("miFichero.dat");
        RandomAccessFile raf = null;        
        try {
            //si no existe el archivo lo creamos
            if (!f.exists()) {
                 f.createNewFile();
            }
            if (f.length()>0) {
                 raf = new RandomAccessFile(f, "rw");//permisos lectura y escritura
                 //si hay algoo escrito usamos el seek
                 //para no sobreescribir y nos movernos a la ultima posicion escrita
                 raf.seek(f.length());
            }
            else{
                 raf = new RandomAccessFile(f, "rw");
                 //si no hay nada escrito nos ponemos en la posicion 0 para
                 //escribir desde el principio
                 raf.seek(0);
            }
            //escribimos lo que querramos
            //debes saber cuantos bytes ocupa cada cosa
           raf.writeInt(5);
           raf.writeBoolean(true);
           StringBuilder sb = new StringBuilder("Ahi viene kiko");
           //importante saber con cuantos caracteres de longitud lo guardamos
           //para leer luego
           sb.setLength(20);
           raf.writeChars(sb.toString());
        } catch (IOException ex) {
            Logger.getLogger(RandomAccesFileEscritura.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try {
                //CERRAMOS
                raf.close();
            } catch (IOException ex) {
                Logger.getLogger(RandomAccesFileEscritura.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }
}
