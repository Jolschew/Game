import java.awt.*;

/**
 * Created by Jan Olschewski on 03.11.15.
 */
public class Figure
{
    private Rectangle boundingBox;
    private int width;
    private int height;
    private int xPos;
    private int yPos;

    /**
     *
     * @return width of Object
     */
    public int getWidth()
    {
        return width;
    }

    /**
     *
     * @param width
     */
    public void setWidth(int width)
    {
        this.width = width;
    }

    /**
     *
     * @return height of Object
     */
    public int getHeight()
    {
        return height;
    }

    /**
     *
     * @param height
     */
    public void setHeight(int height)
    {
        this.height = height;
    }

    /**
     *
     * @return xPosition of Object
     */
    public int getxPos()
    {
        return xPos;
    }

    /**
     *
     * @param xPos
     */
    public void setxPos(int xPos)
    {
        this.xPos = xPos;
    }

    /**
     *
     * @return yPosition of Object
     */
    public int getyPos()
    {
        return yPos;
    }

    /**
     *
     * @param yPos
     */
    public void setyPos(int yPos)
    {
        this.yPos = yPos;
    }

    /**
     *
     * @return Rectangle BoundingBox
     */
    public Rectangle getBoundingBox()
    {
        return boundingBox;
    }

    /**
     * calculate Rectangle Bounding Box of Object
     */
    public void calculateBoundingBox()
    {
        this.boundingBox = new Rectangle(getxPos(), getyPos(), getWidth(), getHeight());
    }
}
