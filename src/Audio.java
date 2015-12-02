import sun.audio.*;

/**
 * Created by Jan Olschewski on 04.11.15.
 */
public class Audio
{

    /**
     * start Background Music Loop
     */
    public void startMusic()
    {
        AudioPlayer bgMusicPlayer = AudioPlayer.player;
        ContinuousAudioDataStream loop = null;

        try
        {
            AudioStream bgMusic = new AudioStream(getClass().getResourceAsStream("/audio/bg.wav"));
            AudioData bgData = bgMusic.getData();
            loop = new ContinuousAudioDataStream(bgData);
        } catch (Exception e)
        {
            e.printStackTrace();
        }
        bgMusicPlayer.start(loop);

    }

}
