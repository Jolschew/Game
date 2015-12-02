import java.util.Observable;

/**
 * Created by Jan Olschewski on 26.10.15.
 */
public class Timer extends Observable
{
    /**
     * Tick and notify all Observers
     */
    public void timing()
    {
        while (true)
        {
            try
            {
                Thread.sleep(20);
                this.setChanged();
                this.notifyObservers();
            } catch (InterruptedException e)
            {
                e.printStackTrace();
            }

        }
    }
}
