import java.util.Observable;
import java.util.Observer;

/**
 * Created by Jan Olschewski on 26.10.15.
 */
public class Enemy extends Figure implements Observer
{

    /**
     * inititate Enemy
     * @param width
     * @param height
     * @param xPos
     * @param yPos
     * @param o
     */
    public Enemy(int width, int height, int xPos, int yPos, Observable o)
    {
        o.addObserver(this);
        this.setWidth(width);
        this.setHeight(height);
        this.setxPos(xPos);
        this.setyPos(yPos);

    }

    /**
     * set width and height 0, when Enemy was hitted
     **/
    public void destroyEnemy()
    {
        this.setHeight(0);
        this.setWidth(0);
    }


    /**
     *  Update every time Observable Class changes
     * @param o
     * @param arg
     */
    public void update(Observable o, Object arg)
    {
        calculateBoundingBox();
        this.setxPos(this.getxPos() + 1);
        this.setxPos(this.getxPos() % 800);
        // this.xPos%=800;
    }


}

// 10 Gegner auf einer Ebene durch  Modulo  Berechnung