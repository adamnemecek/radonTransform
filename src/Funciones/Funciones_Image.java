package Funciones;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

/**
 * @since 06/05/2012
 * @version 1 @ultima revision 06/05/2012
 */
public class Funciones_Image {

    /**
     * Trasforma un bufferedImage en una imagen
     *
     * @param buffer buffer de entrada que contiene una imagen
     * @param nombreImagen nombre de la imagen de salida
     * @param formato formato para la imagen de salida
     */
    public static void ImagenAFormato(BufferedImage buffer, String nombreImagen, String formato) {
        File outputFile = new File(nombreImagen);
        try {
            ImageIO.write(buffer, formato, outputFile);
        } catch (IOException ex) {
        }
    }

    /**
     * Trasforma un bufferedImage en un vector
     *
     * @param buffer buffer de entrada que contiene una imagen
     */
    public static BufferedImage VetorBuffer(int alto, int ancho, int[] axu) {
        BufferedImage image2 = new BufferedImage(ancho, alto, BufferedImage.TYPE_INT_RGB);
        int color;
        int pod = 0;
        for (int i = 0; i < ancho; i++) {
            for (int j = 0; j < alto; j++) {
                color = axu[pod];
                image2.setRGB(i, j, color);
                pod++;
            }
        }
        BufferedImage bg = new BufferedImage(ancho, alto, BufferedImage.TYPE_INT_RGB);
        ((Graphics2D) bg.getGraphics()).drawImage(image2, 0, 0, null);
        return bg;
    }
    /**
     * Guarda una image en un BufferedImage
     *
     * @param image imagen que sera guardada en el buffer
     * @return Buffer que contiene la imagen de entrada
     */
    public static BufferedImage toBufferedImage(Image image) {
        if (image instanceof BufferedImage) {
            return (BufferedImage) image;
        }//fin if
        image = new ImageIcon(image).getImage();
        BufferedImage bimage = null;
        int type = BufferedImage.TYPE_INT_RGB;
        bimage = new BufferedImage(image.getWidth(null), image.getHeight(null), type);
        Graphics g = bimage.createGraphics();
        g.drawImage(image, 0, 0, null);
        g.dispose();
        return bimage;
    }//fin metodo toBufferedImage
    

    public static float[] BufferAVector(BufferedImage d) {
        int pos = 4;
        float vector[] = new float[d.getWidth() * d.getHeight() + 4];
        vector[0] = 256;
        vector[1] = 0;
        vector[2] = d.getWidth();
        vector[3] = d.getHeight();
        for (int a = 0; a < d.getWidth(); a++) {
            for (int gg = 0; gg < d.getHeight(); gg++) {
                vector[pos] = d.getRGB(a, gg);
                //        System.out.print("  "+ vector[pos]+" ");
                pos++;

            }
        }
        return vector;
    }

    public static int[] flotanteInt(float[] r) {
        int[] axu = new int[r.length];
        for (int x = 0; x < r.length; x++) {
            int valor;
            valor = (int) r[x];
            axu[x] = valor;
        }
        return axu;
    }

    public static boolean VerificaSi_IMG(String Archivo) {
        boolean formato = false;
        
        if (Archivo.endsWith(".img") || Archivo.endsWith(".IMG")) {
            formato = true;
        } else if (Archivo.endsWith(".jpg") || Archivo.endsWith(".JPG") || Archivo.endsWith(".TIFF")
                || Archivo.endsWith(".tiff") || Archivo.endsWith(".gif") || Archivo.endsWith(".GIF")
                || Archivo.endsWith(".BMP") || Archivo.endsWith(".bmp") || Archivo.endsWith(".png")
                || Archivo.endsWith(".PNG") || Archivo.endsWith(".WBMP") || Archivo.endsWith(".wbmp")) {
            formato = false;
        }
        return formato;
    }
}
