/**
 * Created by Jan Olschewski on 26.10.15.
 */
public class Main
{
    public static void main(String[] args)
    {
        Timer timer = new Timer();

        //inititiate Game
        World world = new World(timer);

        //start Timing
        timer.timing();
    }
}
