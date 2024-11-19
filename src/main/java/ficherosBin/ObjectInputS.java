/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ficherosBin;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author fabia
 */
public class ObjectInputS {

    public static void main(String[] args) {
        File f = new File("miFcihero.bin");
        //    necesitamos esto para leer objetos 
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        Persona p1 = null;
        try {
            fis = new FileInputStream(f);
            ois = new ObjectInputStream(fis);
            //leemos el objeto aqui 
            while (true) {
                //dara error cuando no haya que leer con el EOFException
                try {
                    p1 = (Persona) ois.readObject();
                    System.out.println(p1);
                    //al dar error
                } catch (EOFException ef) {
                    //Salimos del bucle al alcanzar el final del archivo con el break 
                      break;
                }
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ObjectInputS.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ObjectInputS.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ObjectInputS.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {//cerramos todo
                    ois.close();
                    fis.close();
            } catch (IOException ex) {
                Logger.getLogger(ObjectInputS.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
