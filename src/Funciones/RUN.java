/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Funciones;

import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Miguel García
 */
public class RUN {
    public static String run_JAR(String jar, String params)
    {
        String out = "";
        try {           
            //String c = "";
            //System.out.println(params);
            Process proc = Runtime.getRuntime().exec("java -jar "+jar+" "+params);
            System.out.println("java -jar "+jar+" "+params);
            proc.waitFor();
            // Then retreive the process output
            InputStream in = proc.getInputStream();
            InputStream err = proc.getErrorStream();

            byte b[]=new byte[in.available()];
            in.read(b,0,b.length);
            out = new String(b);
            //System.out.println(new String(b));

            byte c[]=new byte[err.available()];
            err.read(c,0,c.length);
            //System.out.println(new String(c));
            out = out.concat(new String(c));
        
            return new String(out);
        } catch (InterruptedException ex) {
            Logger.getLogger(RUN.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(RUN.class.getName()).log(Level.SEVERE, null, ex);
        }
        return out;
    }
    
}
