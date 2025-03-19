public class ImageUtils {
    public static Image flipHorizontal(Image image) {
        int height = image.height();
        int width = image.width();

        Image newImage = new Image(width, height);

        for (int col = 0; col < width; col++) {
            for (int row = 0; row < height; row++) {

                Color pixel = image.pixel(col, row);
                
                newImage.setPixel(col, height-row-1, pixel);
            }
        }

        return newImage;
    }

    public static Image flipVertical(Image image){
        int height = image.height();
        int width = image.width();

        Image newImage = new Image(width, height);

        for (int row = 0; row< width; row++) {
            for (int col = 0; col < height;col++) {

                Color pixel = image.pixel(col,row);

                newImage.setPixel(width-col-1,row ,pixel );
            }
        }

        return newImage;
    }
    public static Image rotateLeft(Image image){
        int height = image.height();
        int width = image.width();

        Image newImage = new Image(height, width);

        for (int col = 0; col < width; col ++){
            for (int row = 0; row < height; row++){

                Color pixel = image.pixel(col,row);

                newImage.setPixel(width-row-1,height,pixel);
            }
        }

        return newImage;
    }
    public static Image rotateHalf(Image image){
        return rotateLeft(rotateLeft(image));
    }
    public static Image rotateRight(Image image){
        return rotateLeft(rotateLeft(rotateLeft(image)));
    }
    public static Image stretchHorizontal(Image image){
        int height = image.height();
        int width = 2*image.width();

        Image stretched = new Image(width, height);
        for (int col = 0; col < width; col ++){
            for (int row = 0; row < height; row++){
                Color pixel = image.pixel(col,row/2);

                stretched.setPixel(width,height,pixel);
            }
        }
        return stretched;
    }
    // }


}