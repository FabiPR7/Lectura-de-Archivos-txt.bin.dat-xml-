/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ficherosBin;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

/**
 *
 * @author fabia
 */
public class MiObjectOutputStream extends ObjectOutputStream{

    protected  MiObjectOutputStream(OutputStream out) throws IOException, SecurityException {
        super(out);
    }

    public MiObjectOutputStream() throws IOException,SecurityException {
        super();
    }
    
    @Override
    protected void writeStreamHeader() throws IOException {
        super.writeStreamHeader(); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }
    
}
