import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


/**
 * Created by Jan Olschewski on 31.10.15.
 */
public class Controller implements KeyListener
{
    Player player;
    Projectile projectile;

    public Controller(Player player, Projectile projectile)
    {
        this.player = player;
        this.projectile = projectile;
    }

    @Override
    public void keyTyped(KeyEvent e)
    {
    }

    @Override
    public void keyPressed(KeyEvent e)
    {
        //if Key == A or Arrow Left
        if (e.getKeyCode() == 65 || e.getKeyCode() == 37)
        {

            player.movePlayer(-45);

        }
        //if Key == D or Arrow Right
        if (e.getKeyCode() == 68 || e.getKeyCode() == 39)
        {
            player.movePlayer(45);
        }
        //if Key == W or Arrow Up
        if (e.getKeyCode() == 87 || e.getKeyCode() == 38)
        {
            projectile.setShot(true);
        }

    }

    @Override
    public void keyReleased(KeyEvent e)
    {

    }
}
