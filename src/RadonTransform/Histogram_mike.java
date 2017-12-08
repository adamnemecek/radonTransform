/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RadonTransform;

import java.awt.Color;
import java.awt.image.BufferedImage;

/**
 *
 * @author Miguel García
 */
public class Histogram_mike {
    
    float[] histogram;
    /**
     * 
     * @param img1 Imagen1 
     * @param img2 Imagen2
     * @param color Color que se analizará 0 = escala de grises, 1 = rojo, 2 = verde, 3 = Azul
     * @return La diferencia de los dos histogramas
     */
    private float[] getHistogram( BufferedImage img1){     
        Color   c1        = null            ;
        
        float[] array1    = new float[256]  ;
        
        int     aux       = 0               ;
        int     resultado = 0               ;
      
        for(int i=0;i<array1.length;i++){
            array1[i]=0;
        }//del for
       
        for (int x = 0; x < img1.getWidth(); x++){
             for (int y = 0; y < img1.getHeight(); y++){
                  c1 = new Color(img1.getRGB(x, y));
                  
                  //Definir la tonalidad de la imagen en escala de grises.(
                  //if(color==0)
                      aux = (int)((c1.getRed() + c1.getGreen() + c1.getBlue()) / 3);                
                  array1[aux]++;
             }//segundo for
        }//primer for    
        
        return array1; 
    }//Fin metodo compara
   /*
 * Where bi is your image, (x0,y0) is your upper left coordinate, and (w,h)
 * are your width and height respectively
 */
public static Color averageColor(BufferedImage bi, int x0, int y0, int w,
        int h) {
    int x1 = x0 + w;
    int y1 = y0 + h;
    long sumr = 0, sumg = 0, sumb = 0;
    for (int x = x0; x < x1; x++) {
        for (int y = y0; y < y1; y++) {
            Color pixel = new Color(bi.getRGB(x, y));
            sumr += pixel.getRed();
            sumg += pixel.getGreen();
            sumb += pixel.getBlue();
        }
    }
    int num = w * h;
    return new Color(sumr / num, sumg / num, sumb / num);
}
}//Fin clase

