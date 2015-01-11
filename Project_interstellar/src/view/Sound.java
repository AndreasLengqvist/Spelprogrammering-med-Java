package view;

import java.io.IOException;
import java.net.MalformedURLException;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineEvent;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;


/*
 * Sound Class which all sounds (background music, and others) is played.
 */public class Sound
 {
 	private Clip m_clip;


 	/*
 	 *	The clip will be played nLoopCount + 1 times.
 	 */
 	public Sound()
 	{
        try {
                AudioInputStream sound = AudioSystem.getAudioInputStream(this.getClass().getResource("/montana.wav"));
             // load the sound into memory (a Clip)
                m_clip = AudioSystem.getClip();
                m_clip.open(sound);
        }
        catch (MalformedURLException e) {
            e.printStackTrace();
            throw new RuntimeException("Sound: Malformed URL: " + e);
        }
        catch (UnsupportedAudioFileException e) {
            e.printStackTrace();
            throw new RuntimeException("Sound: Unsupported Audio File: " + e);
        }
        catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Sound: Input/Output Error: " + e);
        }
        catch (LineUnavailableException e) {
            e.printStackTrace();
            throw new RuntimeException("Sound: Line Unavailable Exception Error: " + e);
        }
 	}



 	public void update(LineEvent event)
 	{
 	}

 	public void start(){
        m_clip.setFramePosition(0);  // Must always rewind!
 		m_clip.start();
 	}
 	
 	public void loop(){
        m_clip.loop(Clip.LOOP_CONTINUOUSLY);
 	}

 	public void stop(){
 		m_clip.stop();
 	}
 }