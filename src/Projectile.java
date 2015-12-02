import java.util.Observable;
import java.util.Observer;
import java.util.Random;

/**
 * Created by Jan Olschewski on 26.10.15.
 */
public class Projectile extends Figure implements Observer
{

    private boolean shot;
    private Player player;
    private int directionY = -1;
    private Random randomNumber = new Random();
    private int directionX = randomNumber.nextInt(4);

    /**
     * initiate Projectile Object
     * @param o
     * @param player
     */
    public Projectile(Observable o, Player player)
    {
        this.setxPos(400);
        this.setyPos(550);
        this.setWidth(10);
        this.setHeight(10);
        o.addObserver(this);
        this.player = player;

    }


    /**
     *
     * @return shot-Flag value
     */
    public boolean isShot()
    {
        return shot;
    }


    /**
     * set shoot Flag on true, when "W" or "Up-Arrow" were pressed
     * @param shot
     */
    public void setShot(boolean shot)
    {
        this.shot = shot;
    }

    /**
     *  Update every time Observable Class changes
     * @param o
     * @param arg
     */
    public void update(Observable o, Object arg)
    {

        calculateBoundingBox();

        // IF - calculate Position Coordinates, when shot-Flag is true
        if (isShot())
        {
            this.setyPos(this.getyPos() + 2 * this.getDirectionY());
            this.setxPos(this.getxPos() + this.getDirectionX());
        }
        //ELSE - Move Projectile with Player movement
        else
        {
            setxPos(player.getxPos() + 30);
        }

        // Bottom Border
        if (this.getyPos() >= 590)
        {
            this.setyPos(550);
            this.changeDirectionY();
            this.setShot(false);
        }

        //Top Border
        else if (this.getyPos() <= 50)
        {
            this.changeDirectionY();
        }
        //Left and Right Border
        else if (this.getxPos() <= 0 || this.getxPos() >= 795)
        {
            this.changeDirectionX();
        }
    }

    /**
     *
     * @return Y direction of Projectile
     */
    public int getDirectionY()
    {
        return directionY;
    }

    /**
     * invert Direction
     */
    public void changeDirectionY()
    {
        this.directionY = directionY * -1;
    }

    /**
     *
     * @return
     */
    public int getDirectionX()
    {
        return directionX;
    }

    /**
     * set X Direction when Projectile collides with Player
     */
    public void setDirectionX()
    {
        this.directionX = this.randomNumber.nextInt(8) - 4;
    }

    /**
     * invert Direction
     */
    public void changeDirectionX()
    {
        this.directionX = directionX * -1;
    }
}
