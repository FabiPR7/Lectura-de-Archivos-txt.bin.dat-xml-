/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ficherosBin;

import java.io.DataInputStream;
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
public class DataInputS {

    public static void main(String[] args) {
        File f = new File("miFichero.bin");
        //necesitamos esto para leer
        FileInputStream fis = null;
        DataInputStream dis = null;

        try {
            fis = new FileInputStream(f);
            dis = new DataInputStream(fis);
            //leemos con los datos que sabemos que hemos escrito
            System.out.println(dis.readUTF());  
            System.out.println(dis.readInt());  
            System.out.println(dis.readBoolean());  
        } catch (FileNotFoundException ex) {
            Logger.getLogger(DataInputS.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(DataInputS.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try {
                dis.close();
                fis.close();
            } catch (IOException ex) {
                Logger.getLogger(DataInputS.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
