import javax.swing.*;
import java.awt.image.*;
import java.awt.*;

/**
* Этот класс позволяет нам отображать наши фракталы.
 * Он является производным от javax.swing.JComponent.
 */
class JImageDisplay extends JComponent
{
    /**
     * Экземпляр буферизованного изображения.
     */ 
    private BufferedImage displayImage;
    
    /**
     * Метод получения отображаемого изображения из другого класса
     */
    public BufferedImage getImage() {
        return displayImage;
    }
    
    /**
      * Конструктор принимает целые значения ширины и высоты и инициализирует
      * его объект BufferedImage должен быть новым изображением с такой шириной и высотой
      * типа изображения TYPE_INT_RGB.
      */
    public JImageDisplay(int width, int height) {
        displayImage = new BufferedImage(width, height,
        BufferedImage.TYPE_INT_RGB);
        
        /** 
         * Вызвать метод setPreferredSize () родительского класса
         * с заданной шириной и высотой.
         */
        Dimension imageDimension = new Dimension(width, height);
        super.setPreferredSize(imageDimension);
        
    }
    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        g.drawImage(displayImage, 0, 0, displayImage.getWidth(),
        displayImage.getHeight(), null);
    }
    /**
     * Устанавливает все пиксели в данных изображения черными.
     */
    public void clearImage()
    {
        int[] blankArray = new int[getWidth() * getHeight()];
        displayImage.setRGB(0, 0, getWidth(), getHeight(), blankArray, 0, 1);
    }
    /**
     * Устанавливает пиксель определенного цвета.
     */
    public void drawPixel(int x, int y, int rgbColor)
    {
        displayImage.setRGB(x, y, rgbColor);
    }
}
