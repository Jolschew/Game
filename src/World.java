import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Observable;
import java.util.Observer;

/**
 * Created by Jan Olschewski on 26.10.15.
 */
public class World extends JFrame implements Observer
{

    private int numberOfEnemies;
    private Enemy enemies[];
    private Player player;
    private Projectile projectile;
    private Controller controller;
    private GameStats stats;
    private Audio audio;
    private BufferedImage enemyImage, bgImage;


    /**
     * initiate World Object
     * @param o
     */
    public World(Observable o)
    {


        this.initObjects(o);
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        this.audio = new Audio();
     //   this.audio.startMusic();


    }

    /**
     * paint Objects
     * @param g
     */
    public void paint(Graphics g)
    {

        if (this.getNumberOfEnemies() >= 1)
        {
            //draw Background
            g.drawImage(bgImage, 0, 0, 800, 600, null);
            g.fillRect(0,0,800,600);


            //draw Player
            g.setColor(Color.blue);
            g.fillRect(this.player.getxPos(), this.player.getyPos(), this.player.getWidth(), this.player.getHeight());

            //draw Projectile
            g.setColor(Color.cyan);
            g.fillRect(this.projectile.getxPos(), this.projectile.getyPos(), this.projectile.getWidth(), this.projectile.getHeight());

            //draw enemies
            for (int i = 0; i < 30; i++)
            {

                g.fillRect(this.enemies[i].getxPos(), this.enemies[i].getyPos(), this.enemies[i].getWidth(), this.enemies[i].getHeight());
            }

            //draw HUD
            g.setColor(Color.white);
            g.setFont(new Font("Helvetica", Font.BOLD, 20));
            g.drawString("Points: " + this.stats.getScore(), 550, 50);
            g.drawString("Time: " + this.stats.getTime(), 700, 50);
        }

        // All Enemies are Dead - End Screen
        else
        {
            g.fillRect(0, 0, 800, 600);
            g.setColor(Color.white);
            g.setFont(new Font("Helvetica", Font.BOLD, 20));
            g.drawString("Toll", 300, 150);
            g.drawString("Du hast " + this.stats.getScore() + " Punkte erreicht!", 300, 200);
        }
    }

    /**
     *  Update every time Observable Class changes
     * @param o
     * @param arg
     */
    public void update(Observable o, Object arg)
    {
        this.stats.setTime();
        repaint();

        // Catch NullPointer Exception, before Bounding Boxes where initialized
        try
        {
            if (projectile.getBoundingBox().intersects(player.getBoundingBox()))
            {
                projectile.changeDirectionY();
                projectile.setDirectionX();
                projectile.setyPos(550);
            }
        } catch (NullPointerException e) {}

        for (Enemy i : enemies)
        {
            // Catch NullPointer Exception, before Bounding Boxes where initialized
            try
            {
                if (projectile.getBoundingBox().intersects(i.getBoundingBox()))
                {
                    projectile.changeDirectionY();
                    i.destroyEnemy();
                    this.setNumberOfEnemies(this.getNumberOfEnemies() - 1);
                    this.stats.calculateScore(this.stats.getTime());
                }

            } catch (NullPointerException e){}
        }
    }

    /**
     * initiate Enemies
     * @param o
     */
    public void initEnemies(Observable o)
    {
        for (int i = 0; i < this.getNumberOfEnemies(); i++)
        {
            int xPos = i * 80;
            int yPos;
            if (i / 10 < 1)
            {
                yPos = 100;
            }
            else if (1 < i / 10 && i > 2)
            {
                yPos = 170;

            }
            else
            {
                yPos = 240;
            }
            enemies[i] = new Enemy(60, 30, xPos, yPos, o);
        }
        o.addObserver(this);
    }

    /**
     * initiate Objects
     * @param o
     */
    public void initObjects(Observable o)
    {
        this.setNumberOfEnemies(30);
        enemies = new Enemy[this.getNumberOfEnemies()];
        player = new Player(o);
        projectile = new Projectile(o, this.player);
        controller = new Controller(this.player, this.projectile);
        addKeyListener(controller);
        stats = new GameStats();
        this.initEnemies(o);

    }

    /**
     *  Helper Method to get living Enemies
     * @return
     */
    public int getNumberOfEnemies()
    {
        return numberOfEnemies;
    }

    /**
     * set Number of Enemies
     * @param numberOfEnemies
     */
    public void setNumberOfEnemies(int numberOfEnemies)
    {
        if(0 < numberOfEnemies && numberOfEnemies <= 30)
        {
            this.numberOfEnemies = numberOfEnemies;
        }
        else
        {
            this.numberOfEnemies = 30;
        }
    }

}
