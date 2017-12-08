/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package RadonTransform;

import Funciones.Archivos;
import Funciones.Funciones_Image;
import Funciones.IOBinFile;
import Funciones.Img;
import Funciones.MyListArgs;
import Funciones.MySintaxis;
import Funciones.RUN;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import javax.imageio.ImageIO;

/**
 *
 * @author Miguel Angel
 * @since 17-jul-2012
 */
public class Radon {

    /**
     * @param args the command line arguments
     */
    Radon( String[] args ) throws IOException{      
        
        String        ConfigFile = "";
        String        Archivo    = "";
        String        DIR        = "";
        String        JAR_ROTATE = "";
        String        rotateTo   = "left";
        
        boolean       SAVE_ANGLE = false;
        
        MyListArgs    Param         ;
        BufferedImage image         ;

        Param      = new MyListArgs(args)                  ;
        ConfigFile = Param.ValueArgsAsString("-CONFIG", "");
        
        if (!ConfigFile.equals("")) 
        {
            Param.AddArgsFromFile(ConfigFile);
           }//fin if
        
        String Sintaxis   = "-IN:str -OUT:str -JAR_ROTATE:str [-SAVE_ANGLE:bool]";
        MySintaxis Review = new MySintaxis(Sintaxis, Param);
        //PARAMETROS FORZOSOS        
               
        Archivo    = Param.ValueArgsAsString( "-IN", "" );//lectura del directorio donde se encuentra la iamgen
        JAR_ROTATE = Param.ValueArgsAsString( "-JAR_ROTATE", "");
        DIR        = Param.ValueArgsAsString( "-OUT", "jkhj");
        
        SAVE_ANGLE = Param.ValueArgsAsBoolean("-SAVE_ANGLE", false);
        
        
        //System.out.println(DIR);
        
        if ( Archivo.endsWith( ".img" ) | Archivo.endsWith( ".IMG" ) )//en caso de ser un archivo .img se procede a abrir la imagen con el metodo abreIMG
            image = Img.abreIMG( Archivo);
        else
            image = ImageIO.read( new File(Archivo) );//en caso contrario la imagen se abre con el metodo read de la clase ImageIO
        
        double res = RadonTransform.doIt(image);
        System.out.print(res);
        
        if(res<0)
        {
            res = res*-1;
            rotateTo = "right";
        }
        //System.out.println("jar: "+JAR_ROTATE);
        
        Process p = null;
                try {
                    p = Runtime.getRuntime().exec("java -jar "+JAR_ROTATE +" -IMG "+Archivo+" -DIR "+DIR+" -ANGLE "+res+" -ROTATE_TO "+rotateTo+" -FOREGROUND white");
                    //System.out.println("java -jar "+JAR_ROTATE +" -IMG "+Archivo+" -DIR "+DIR+" -ANGLE "+res+" -ROTATE_TO "+rotateTo+" -FOREGROUND white");
                } catch (IOException ex) {
                    //Logger.getLogger(FAFM1VarA.class.getName()).log(Level.SEVERE, null, ex);
                }
                
               // if(SAVE_ANGLE)
               // {
                    
                    Archivos.escribeArchivo(DIR+".txt", String.valueOf(res));
               // }
                
        //RUN.run_JAR(JAR_ROTATE,  "-IMG "+Archivo+" -DIR "+DIR+" -ANGLE "+res+" -ROTATE_TO "+rotateTo+" -FOREGROUND white");
        
    }//del constructor
    
    
}