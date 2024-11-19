/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ficherosDat;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author fabia
 */
public class RandomAccesFileLectura {

    public static void main(String[] args) {
        /*
        int = 4 bytes
        String = 2 bytes por cada caracter
        boolean = 1 byte
        char = 2 bytes
        double =  8 bytes
         */
        File f = new File("miFichero.dat");
        RandomAccessFile raf = null;
        try {
            raf = new RandomAccessFile(f, "r");//damos permisos de solo lectura
            //si sabemos lo que tenemos que leer,  tenemos que leer en el orden
            //que hayamos escrito
            System.out.println(raf.readInt());
            System.out.println(raf.readBoolean());
            //como sabemos la siguiente cadena cuanto mide lo guardamos en un array 
            char[] letras = new char[20];
            //vamos caracter por caracter rellenando datos
            for (int i = 0; i < letras.length; i++) {
                letras[i] = raf.readChar();
            }
            //yo lo  junto todo en un String 
            String fraseCompleta = new String(letras);
            System.out.println(fraseCompleta);
            //si quieres leer un dato especifico puedes moverte sabiendo cuanto 
            //ocupa cada cosa
            //4 el primer dato es un numero, el numero son 4bytes pero al empezar
            //de 0 es 3 por eso vamos a la posicion 4 pero -1
            raf.seek(4 - 1);
            System.out.println(raf.readBoolean());
            //tambien podemos saber en que posicion estamos si usamos el getFilePointer 
            System.out.println(String.valueOf(raf.getFilePointer()));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(RandomAccesFileLectura.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(RandomAccesFileLectura.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                //cerralo we
                raf.close();
            } catch (IOException ex) {
                Logger.getLogger(RandomAccesFileLectura.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
