import java.awt.Component;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class Image {

    int this_width;
    int this_height;

    Color[][] this_pixels;

    /**
     * Constructs an Image with a width, height, and a default black background color.
     * @param width
     * @param height
     * 
     */
    public Image(int width, int height){
        this(width,height, Color.BLACK);

    }
    /**
     * 
     * @param width
     * @param height
     * @param background
     * Constructs an Image with a width, height, and a background color.
     */
    public Image(int width, int height, Color background){

        assert width >= 0;
        assert height >= 0;

        this_width = width;
        this_height = height;

        this_pixels = new Color[width][height];
        
        for(int x = 0; x < width; x++){
            for(int y = 0; y < height; y++){
                this_pixels[x][y] = background;
            }
        }

    }
    /**
     * Returns the width of the Image
     * @return int
     */
    public int width(){
        return this_width;
    }
    /**
     * Returns the height of the image
     * @return int
     */
    public int height(){
        return this_height;
    }
    /**
     * Returns the color value of the pixel at x,y location.
     * @param x
     * @param y
     * @return Color
     */
    public Color pixel(int x, int y){
        return this_pixels[x][y];
    }
    /**
     * Sets the color of th pixel at [x][y] to a given colour.  
     * @param int x
     * @param int y
     * @param Color color
     */
    public void setPixel(int x, int y, Color z){
        this_pixels[x][y] = z;
    }

    public static Image fromFile(String path){
        try {
         BufferedImage temp_image = ImageIO.read(new File(path));
         Image new_image = new Image(temp_image.getWidth(), temp_image.getHeight());

         for(int x = 0; x < new_image.width(); ++x) {
            for(int y = 0; y < new_image.height(); ++y) {
               int newColor = temp_image.getRGB(x, y) & 16777215;
               new_image.this_pixels[x][y] = new Color(newColor);
            }
         }

         return new_image;
      } catch (IOException e) {
         return new Image(100,100, Color.BLACK);
      }
    }

    public void display(){
        BufferedImage buff_image = new BufferedImage(this.width(), this.height(), 1);

        for(int x = 0; x < this.width(); ++x) {
            for(int y = 0; y < this.height(); ++y) {
                buff_image.setRGB(x, y, this_pixels[x][y].rgb());
            }
        }

      JOptionPane.showMessageDialog((Component)null, new ImageIcon(buff_image));
    }


    public static void main(String[] args){
        Image here = Image.fromFile("C:\\Users\\marcu\\Desktop\\cat.jpg");
        // here = ImageUtils.flip_vertical(here);
        here.display();
    }
}
