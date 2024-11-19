/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ficherosBin;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author fabia
 */
public class DataOutputS {
    public static void main(String[] args) {
        File f = new File("miFichero.bin");
        //para escribir con el dataOs necesitamos esto
        FileOutputStream fos = null;
        DataOutputStream dos = null;
        try { 
            if (f.length() > 0) {
                //si ya hay algo escrito el true hace que escribamos despues 
                //de lo escrito y que no se sobreescriba(borre todo y escriba)
                fos = new FileOutputStream(f,true);
            }
            else{
                fos = new FileOutputStream(f);
            }
            dos = new DataOutputStream(fos);
            //Aqui escribimos los datos que queramos
            dos.writeUTF("Hola eesto esta escrito con DataOutputStream");
            dos.writeInt(1);
            dos.writeBoolean(true);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(DataOutputS.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(DataOutputS.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try {
                //Cerrar primero
                dos.close();
                //luego
                fos.close();
            } catch (IOException ex) {
                Logger.getLogger(DataOutputS.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
    }
}
