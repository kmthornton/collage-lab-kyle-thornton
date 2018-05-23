
/**
 * Kevin Hayes
 * Test Picture Classes
 *
 * @author (Kevin Hayes)
 * @version (10-19-2016)
 */
import java.awt.*;
import java.util.*;
import java.awt.Color;
import java.util.List; // resolves problem with java.awt.List and java.util.List
public class TestPicture17
{

    /**
     * main method, to test the picture
     *
     */
  public static void main(String[] args)
  {
          /*
          //make custom color       R   G B
          Color sample = new Color(255,51,0);
          Color sample2 = Color.orange;
          
          System.out.println(sample2);
          
          //opens picture using a dialog box
         
         String fileName = FileChooser.pickAFile();
         Picture pictObj = new Picture(fileName);
         pictObj.explore();*/
         
    
    
         //opens a pictue using a path
         //Picture apic = new Picture("C:\\Users\\khayes\\Favorites\\Documents\APCS- Java\chap03\Curriclum 2013\Picture Color labs\images\\beach.jpg");
         Picture hay = new Picture("images\\mr_hayes.jpg");
         Picture canvas = new Picture("images\\MyCanvas.jpg");
         Picture greenimage = new Picture("images\\greenscreen.jpg");
         Picture radical = new Picture("images\\rad.jpg");
         canvas.copy(hay,0,916);
         hay.mirrorVertical();
         canvas.copy(hay,1608,0);
         hay = new Picture("images\\mr_hayes.jpg");
         hay.negative();
         canvas.copy(hay,3216,0);
         hay = new Picture("images\\mr_hayes.jpg");
         hay.merge(radical);
         canvas.copy(hay,1608,916);
         hay = new Picture("images\\mr_hayes.jpg");
         hay.greenscreen(greenimage);
         canvas.copy(hay,3216,916);
         hay = new Picture("images\\mr_hayes.jpg");
         hay.scale(1);
         canvas.copy(hay,0,0);
         canvas.explore();
         canvas.write(FileChooser.getMediaPath("images"));
         canvas.write("images/finalcollage.jpg");

         /*    
         //relative path
         Picture apic = new Picture("images\\beach.jpg");
         Picture ferris1 = new Picture("images/2000 ferris wheel2.jpg");
         Picture ferris2 = new Picture("images/2000 ferris wheel2.jpg");
         Picture ferris3 = new Picture("images/2000 ferris wheel2.jpg"); 
         
         Picture myPic = new Picture("images\\chuck.jpg");
         Picture temple = new Picture("images\\temple.jpg");
         Picture canvas = new Picture("images\\MyCanvas.jpg");
         //myPic.gray();
         //canvas.copyKatie();
         //canvas.explore();
         myPic.mirrorHorizontal();
         myPic.mirrorVertical();
         myPic.explore();
         temple.mirrorTemple();
         temple.explore();
         canvas.scale();
         canvas.explore(); */

         /*
         apic.explore();
         ferris1.explore();
         
         //makes an array of pixels
         Pixel[] pixels;
         //gets pixels from picture and assigns to pixels array
         pixels = ferris1.getPixels();
        
         //how many pixels or how large array
        System.out.println("This is a large array"+pixels.length  );
    


            //access each index
        System.out.println(pixels[17]);
        //access each pixel
        Pixel spot = ferris1.getPixel(100,100);
        Pixel lampspot = ferris1.getPixel(252,394);
        Pixel anime = ferris1.getPixel(50,70);
        
        System.out.println(pixels[17].getColor());
        System.out.println(spot);
        System.out.println(lampspot);
    
        pixels[17].setColor(Color.blue);
        spot.setColor(new Color(252,252,252));
        pixels[500034].setColor(Color.blue);
        lampspot.setColor(Color.black);
        
    
    
        ferris1.explore();
    
       // loop to access indexes of array or collection
       
            //makes an array of pixels
         Pixel[] pixels_arr;
         //gets pixels from picture and assigns to pixels array
         pixels_arr = ferris1.getPixels();
        int i = 0;
        //for each loop spot  is a ?
        for (Pixel spot1 : pixels_arr)
        {
            //System.out.println( spot1 );
               //even
            //if(i% 20 == 0)
            if((spot1.getX()+spot1.getY())% 20 == 0)
            {
                spot1.setColor(Color.green);
            }
            
            
            i++;
        }
        ferris1.explore();
   
     
        
         /**
          * Method to clear red from picture
          * @param none
          * @return none
          */
         /*
            for (Pixel pixelObj : pixels_arr)
                {
                    //set the red value of the current pixel to the new value
                    pixelObj.setRed(0);
        
                }
            ferris1.explore();
            
        
    
         /**
          * Method to reduce red from picture by a factor of n
          * @param none
          * @return none
          */
        
         /*
         * int value;
        final double  FACTOR = .5;
        for (Pixel pixelObj : pixels)
        {
    
            //get the redvalue
            value = pixelObj.getRed();
            //System.out.println(value);
    
            //decrease the red value by 50%
            pixelObj.setGreen(value*int.(FACTOR));
        }
        
        // use new picture when changing or it will make changes to 
        // pic you already changed
        ferris1.explore();
        ferris2.explore();
        */
       /*
        //write/save a picture as a file
        ferris1.write("images/ferris11.jpg");//change name!!!!!!!!!!
        
       Picture snowman = new Picture("images/snowman.jpg");
       
            //makes an array of pixels
         Pixel[] pixels_arr;
         //gets pixels from picture and assigns to pixels array
         pixels_arr = snowman.getPixels();
        int i = 0;
        //for each loop spot  is a ?
        for (Pixel spot1 : pixels_arr)
        {
            //System.out.println( spot1 );
               //even
            //if(i% 20 == 0)
            if((spot1.getX()+spot1.getY())% 20 == 0)
            {
                spot1.setColor(Color.green);
            }
            
            
            i++;
        }
        snowman.explore();
        */
    }//main
    /*
      //method to greyscale
     public void grayscale()
     {
         Pixel[]pixelArray = this.getPixels();
         Pixel pixel = null;
         int intensity = 0;
         
         for (int i=0; i<pixelArray.length; i++)
         {
             pixel = pixelArray[i];
             
             intensity = (int) ((pixel.getRed() + pixel.getGreen()+ pixel.getBlue())/3);
             
             pixel.setColor(new Color(intensity,intensity,intensity));
            }
        }*/
         
}//class
