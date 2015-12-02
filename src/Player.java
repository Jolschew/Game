import java.util.Observable;
import java.util.Observer;

/**
 * Created by Jan Olschewski on 26.10.15.
 */
public class Player extends Figure implements Observer
{

    /**
     * inititate Player Object
     * @param o
     */
    public Player(Observable o)
    {
        this.setxPos(370);
        this.setyPos(560);
        this.setWidth(70);
        this.setHeight(10);
        o.addObserver(this);
    }

    /**
     *  Move Player in between windowsize
     * @param x
     */
    public void movePlayer(int x)
    {
        int newPos = this.getxPos() + x;
        this.setxPos(newPos);
        if (this.getxPos() <= 0)
        {
            this.setxPos(0);
        }
        if (this.getxPos() >= 730)
        {
            this.setxPos(730);
        }
    }

    /**
     *  Update every time Observable Class changes
     * @param o
     * @param arg
     */
    @Override
    public void update(Observable o, Object arg)
    {
        this.calculateBoundingBox();
    }

}
