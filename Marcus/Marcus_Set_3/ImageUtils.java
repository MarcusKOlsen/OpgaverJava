public class ImageUtils {
    public static Image flip_horizontal(Image image) {
        int height = image.height();
        int width = image.width();
        
        Image t_image = new Image(width, height);

        for (int col = 0; col < width; col++){
            for (int row = 0; row < height; row++) {
                Color temp_pixel = image.pixel(col, row);
                t_image.setPixel(col, height-1-row, temp_pixel);
            }
        }
        return t_image;
    }
    public static Image flip_vertical(Image image) {
        int height = image.height();
        int width = image.width();

        Image t_image = new Image(width, height);

        for (int col = 0; col < width; col++){
            for (int row = 0; row < height; row++) {
                Color temp_pixel = image.pixel(col, row);
                t_image.setPixel(width-1-col, row, temp_pixel);
            }
        }

        return t_image;
    }
}
