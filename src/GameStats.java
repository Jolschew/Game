import java.util.Observable;
import java.util.Observer;

/**
 * Created by Jan Olschewski on 02.11.15.
 */
public class GameStats
{
    private int time;
    private int score;

    /**
     * @return time in seconds
     */
    public int getTime()
    {
        return time / 50;
    }

    /**
     * set increase Time by 1
     */
    public void setTime()
    {
        this.time++;
    }

    /**
     * @return score
     */
    public int getScore()
    {
        return score;
    }

    /**
     * @param time in Seconds
     */
    public void calculateScore(int time)
    {
        this.score += 200 - time % 10;
    }


}
