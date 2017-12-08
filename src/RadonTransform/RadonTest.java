/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RadonTransform;


import Funciones.Img;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

/**
 * Created on 03/05/2014.
 */
public class RadonTest {
    public static void main(String[] args) {
        String[] args2 = {
"C:\\TEMP\\test\\lleno.png"};
        mainFct(args2);
        
    }

    public static void mainFct(String[] args) {
        try {
            if(args.length < 1 || args[0] == "--help" || args[0] == "-h") {
                System.out.print(
                        "Usage: java HocrToPdf INPUTURL.tiff INPUTURL.html OUTPUTURL.pdf\n" +
                                "\n" +
                                "Converts hOCR files into PDF\n" +
                                "\n" +
                                "Example: java com.acoveo.hocrtopdf.HocrToPdf file:///home/username/hocr.html ./output.pdf\n");
                if(args.length < 1)
                    System.exit(-1);
                else
                    System.exit(0);
            }
            System.out.println(args[0]);
            String inputImgFile = null;
            File imgFile = null;
            /*try {
                inputImgFile = new String(args[0]);
                imgFile = new File(inputImgFile.toURI());
            } catch (Exception e) {
                System.out.println("First and second parameters have to be a valid URL");
                e.printStackTrace();
                System.exit(-1);
            }*/
            //BufferedImage img = Imaging.getBufferedImage(imgFile);
            BufferedImage img = ImageIO.read(new File(args[0]));
            if(img == null) {
                System.exit(-1);
            }
            System.out.println("Image name : " + args[0]);

            System.out.println(" - page " + " width x height = " + img.getWidth() + " x " + img.getHeight());
            double res = RadonTransform.doIt(img);
            System.out.println(" -- skew " + " :" + res);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
