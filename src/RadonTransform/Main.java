 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RadonTransform;  

import java.io.IOException;
/**
 *
 * @author Miguel García
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            // TODO code application logic here
            Radon r = new Radon(args);
        } catch (IOException ex) {
            System.out.println(ex.getLocalizedMessage());
        }
    }
    
}
