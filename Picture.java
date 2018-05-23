import java.awt.*;
import java.awt.font.*;
import java.awt.geom.*;
import java.awt.image.BufferedImage;
import java.text.*;
import java.util.*;
import java.util.List; // resolves problem with java.awt.List and java.util.List

/**
 * A class that represents a picture.  This class inherits from
 * SimplePicture and allows the student to add functionality to
 * the Picture class.
 *
 * Copyright Georgia Institute of Technology 2004-2005
 * @author Barbara Ericson ericson@cc.gatech.edu
 */
public class Picture extends SimplePicture
{
  ///////////////////// constructors //////////////////////////////////

  /**
   * Constructor that takes no arguments
   */
  public Picture ()
  {
    /* not needed but use it to show students the implicit call to super()
     * child constructors always call a parent constructor
     */
    super();
  }

  /**
   * Constructor that takes a file name and creates the picture
   * @param fileName the name of the file to create the picture from
   */
  public Picture(String fileName)
  {
    // let the parent class handle this fileName
    super(fileName);
  }

  /**
   * Constructor that takes the width and height
   * @param width the width of the desired picture
   * @param height the height of the desired picture
   */
  public Picture(int width, int height)
  {
    // let the parent class handle this width and height
    super(width,height);
  }

  /**
   * Constructor that takes a picture and creates a
   * copy of that picture
   */
  public Picture(Picture copyPicture)
  {
    // let the parent class do the copy
    super(copyPicture);
  }

  /**
   * Constructor that takes a buffered image
   * @param image the buffered image to use
   */
  public Picture(BufferedImage image)
  {
    super(image);
  }

  ////////////////////// methods ///////////////////////////////////////

  /**
   * Method to return a string with information about this picture.
   * @return a string with information about the picture such as fileName,
   * height and width.
   */
  public String toString()
  {
    String output = "Picture, filename " + getFileName() +
      " height " + getHeight()
      + " width " + getWidth();
    return output;

  }

  public static void main(String[] args)
  {
     String fileName = FileChooser.pickAFile();
     Picture pictObj = new Picture(fileName);
     pictObj.explore();
     pictObj.gray();
  }

  //------------------------MY METHODS---------------------
  /**
  * takes the average of the rgb values and changes their color
  */
  public void gray()
  {     //not the greatest way if you have a large picture
       Pixel[]pixelArray = this.getPixels();
       Pixel pixel = null;
       int intensity = 0;

       for (int i=0; i<pixelArray.length; i++)
       {
         pixel = pixelArray[i];

         intensity = (int) ((pixel.getRed() + pixel.getGreen()+ pixel.getBlue())/3);

         pixel.setColor(new Color(intensity,intensity,intensity));
         }
    }//end of gray
    
  /**
     * copies a picture onto another picture
     * @param Picture picture being copied
     * @param x = xpos
     * @param y = ypos
  */
  public void copy(Picture sourcePicture, int x, int y)
  {
        //String source = ("images\\mr_hayes.jpg");

        //Picture sourcePicture = new Picture(source);

        Pixel sourcePixel = null;
        Pixel targetPixel = null;

        //width of the source must be = or < the canvas i am copying to
        for(int sourceX = 0, targetX = x;
        sourceX < sourcePicture.getWidth();
        sourceX++, targetX++)
        {
            for(int sourceY = 0, targetY = y;
            sourceY < sourcePicture.getHeight();
            sourceY++, targetY++)
            {   //set the target pixel color to the source pixel color
                sourcePixel = sourcePicture.getPixel(sourceX, sourceY);
                targetPixel = this.getPixel(targetX, targetY);
                targetPixel.setColor(sourcePixel.getColor());
            }
        }

  }//end of copy
  
  /**
  *mirror around a vertical line in the middle based on width
  *makes the second half of the picture negative
  */
  public void mirrorVertical()
  {
        int width = this.getWidth();
        int mirrorpoint = width/2;
        
        Pixel leftPixel = null;
        Pixel rightPixel = null;
        
        //loop through all the rows
        for (int y = 0; y< getHeight(); y++)
        {
            //loop from 0 to the middle(mirror point)
            for(int x = 0; x<mirrorpoint; x++)
            {
                leftPixel = getPixel(x,y);
                rightPixel = getPixel(width -1 -x,y);
                rightPixel.setColor(leftPixel.getColor());
                rightPixel.setRed(255-rightPixel.getRed());
                rightPixel.setGreen(255-rightPixel.getGreen());
                rightPixel.setBlue(255-rightPixel.getBlue());
               }
           }
    }//end of vert mirror
    
       /**
        * flips the image over a horizontal axis
        */
  public void mirrorHorizontal()
  {
        
        int height = this.getHeight();
        int mirrorpoint = height/2;
        
        Pixel topPixel = null;
        Pixel bottomPixel = null;
        
        //loop through all the rows
        for (int x = 0; x< getWidth(); x++)
        {
            //loop from 0 to the middle(mirror point)
            for(int y=0; y< mirrorpoint; y++)
            {
                topPixel = getPixel(x,y);
                bottomPixel = getPixel(x,height-1-y);
                bottomPixel.setColor(topPixel.getColor());
               }
           }
  }//end of mirrorHorizontal
       /**
        * flips the TEMPLE
        */
  public void mirrorTemple()
  {
        int mirrorpoint = 276;
        
        Pixel leftPixel = null;
        Pixel rightPixel = null;
        
        //loop through all the rows
        for (int y = 0; y< getHeight(); y++)
        {
            //loop from 0 to the middle(mirror point)
            for(int x = 0; x<mirrorpoint; x++)
            {
                leftPixel = getPixel(x,y);
                rightPixel = getPixel(276 -1 -x,y);
                rightPixel.setColor(leftPixel.getColor());
               }
           }    
  }//mirror temple
  
  /**
   * makes an image smaller and smaller recursively
   * @param the factor the image is scaled by
   */
  public void scale(int scale)
  {
           
       Pixel sourcePixel = null;
       Pixel targetPixel = null;
       
       if (scale >=5)
       {}
       else
       {
       for (int sourceX = 0, targetX = 0;
           sourceX < this.getWidth();
           sourceX += scale, targetX++)
           {
           for(int sourceY = 0, targetY = 0; 
           sourceY < this.getHeight();
           sourceY += scale, targetY++)
           {
               //set the target pixel color to the source pixel color
               sourcePixel = this.getPixel(sourceX, sourceY);
               targetPixel = this.getPixel(targetX, targetY);
               targetPixel.setColor(sourcePixel.getColor());
           }
        }
        this.scale(scale+1);
       }
       }//end of scale
       
  /**
  * method to make an image negative
  * subtracts the rgb values from 255 to make a negative image
  */
  public void negative()
  {
        Pixel source = null;
        
        for (int x = 0; x<getWidth(); x++)
        {
           for (int y = 0; y<getHeight(); y++)
           {
               source = this.getPixel(x,y);
               source.setRed(255-source.getRed());
               source.setGreen(255-source.getGreen());
               source.setBlue(255-source.getBlue());
            }
        }
    }//end of negative
    
    /**
    * Method to do a simple edge detection by comparing the
    * absolute value of the difference between the color 
    * intensities (average of the color values) between a
    * pixel and the pixel below it.  If the absolute value
    * of the difference between the color intensities is
    * less than a passed amount the top pixel color 
    * will be set to white. Otherwise it is set to black.
    * @param amount if the absolute value of the differences
    * in the color average is less thatn this
    * set the color to white, else black
    */
  public void edger(double ammount)
  {
     Color purp = new Color(143,64,251);
     Color gree = new Color(150,206,99);
     Pixel topPix = null;
     Pixel bottomPix = null;
     this.gray();
     for (int x = 0; x<getWidth(); x++)
        {
           for (int y = 0; y<getHeight()-1; y++)
           {
               topPix = this.getPixel(x,y);
               bottomPix = this.getPixel(x,y+1);
               //finds the absolute value of the difference
               //any color will work to check because all the values are the same

               double value = Math.abs(topPix.getRed()-bottomPix.getRed());
               if(value<ammount)
                    topPix.setColor(Color.white);
               else
                    topPix.setColor(Color.black);
               
            }
        }
    }  //end of edge detection
    
    /**
     * greenscreen
     * puts the non green pixels of
     * the greenscreen picture onto the original image
     * @param the greenscreen picture
     */
  public void greenscreen(Picture greenPic)
  {
        //color of the green background
        //Color screen = new Color(0, 254, 0);
        Pixel pix = null;
        Pixel greenpix = null;
        
        for (int x = 0; x<getWidth(); x++)
        {
           for (int y = 0; y<getHeight()-1; y++)
           {
               pix = this.getPixel(x,y);
               greenpix = greenPic.getPixel(x,y);
               //if the g value is greater than 220 it should be green 
               //<= because it transfers the greenPic onto the og pic
               if(greenpix.getGreen()<=220)
               //transfers non green pixels on greenPic to the og pic
               { pix.setColor(greenpix.getColor());}
               
            }
        }   
  }// end of greenscreen
  
    /**
     * merges two pictures by switching off pictures every
     * other pixel
     * @param picture being overlayed
     */
  public void merge(Picture image)
  {
        Pixel thisPix = null;
        Pixel imagePix = null;
        
        for (int x = 0; x<getWidth()-2; x+=2)
        {
           for (int y = 0; y<getHeight()-2; y+=2)
           {
               imagePix = image.getPixel(x,y);
               thisPix = this.getPixel(x,y);
               thisPix.setColor(imagePix.getColor());
               
            }
        }
        
    }// end of merge
    
} // this } is the end of class Picture, put all new methods before this
















