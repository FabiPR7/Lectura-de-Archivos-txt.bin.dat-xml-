/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ficherosBin;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author fabia
 */
public class ObjectOutputS {

    public static void main(String[] args) {
        File f = new File("miFcihero.bin");
        //Guarda cualquier objeto
        Persona p1 = new Persona("KIKO", 40);
        Persona p2 = new Persona("FRANCO N", 22);

        //guardamos con
        FileOutputStream fos = null;
       
        //AL USAR ESTO DA ERROR PORQUE ESCRIBE COSAS RARAS EN LA CABECERA 
        //PARA ARREGLAR ESO TIENES QUE SOBRE ESCRIBIR UN METODO CON LA CLASE 
        // que se llama MIOBJECTOUTPUTSTREAM
        ObjectOutputStream oos = null;
        try {
            if (f.length() > 0) {
                //si ya hay algo escrito el true hace que escribamos despues 
                //de lo escrito y que no se sobreescriba(borre todo y escriba)
                fos = new FileOutputStream(f, true);
                //si ya tiene cositas se le pone el normal
                oos = new ObjectOutputStream(fos);
            } else {
                fos = new FileOutputStream(f); 
                //si no tiene nada se pone esto pa que no ponga una cabecera
                //to fea
                oos = new MiObjectOutputStream(fos);
            }
            //AQUI CAMBIAMOS Al nuevo OutputStream
          
           //guardamos directo el objeto
           
           //!!!IMPORTANTE¡¡¡¡ EL OBJETO DEBE SER SERIALIABLE MIRA EL OBJETO ABAJO DE ESTA CLASE
           oos.writeObject(p1);
           oos.writeObject(p2);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ObjectOutputS.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ObjectOutputS.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try {
                oos.close();
                fos.close();
            } catch (IOException ex) {
                Logger.getLogger(ObjectOutputS.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
    }
}

class Persona implements Serializable{

    private String nombre;
    private int edad;

    public Persona(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    @Override
    public String toString() {
          return nombre+" con "+edad+" años\n";
    }
    
    
}
