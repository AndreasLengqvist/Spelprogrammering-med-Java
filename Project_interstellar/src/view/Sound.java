package view;

import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineEvent;
import javax.sound.sampled.LineListener;
import javax.sound.sampled.LineUnavailableException;


/*
 * Sound Class which all sounds (background music, and others) is played.
 */
public class Sound implements LineListener {
	
	private Clip m_clip;

	
	public Sound(File clipFile, int nLoopCount)
	{
		AudioInputStream	audioInputStream = null;
		try {
			audioInputStream = AudioSystem.getAudioInputStream(clipFile);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		if (audioInputStream != null) {
			AudioFormat	format = audioInputStream.getFormat();
			DataLine.Info	info = new DataLine.Info(Clip.class, format);
			
			try {
				m_clip = (Clip) AudioSystem.getLine(info);
				m_clip.addLineListener(this);
				m_clip.open(audioInputStream);
			}
			catch (LineUnavailableException e) {
				e.printStackTrace();
			}
			catch (IOException e) {
				e.printStackTrace();
			}
		}
		else {
			out("ClipPlayer.<init>(): can't get data from file " + clipFile.getName());
		}
	}
	
	public void start(){
		m_clip.start();
	}
	
	public void stop(){
		m_clip.stop();
	}

	public static void main(String[] args) {
		if (args.length != 2) {
			out("ClipPlayer: usage:");
			out("\tjava ClipPlayer <soundfile> <#loops>");
		}
		else {
			File	clipFile = new File(args[0]);
			int		nLoopCount = Integer.parseInt(args[1]);
			Sound	clipPlayer = new Sound(clipFile, nLoopCount);

			/* In the JDK 5.0, the program would exit if we leave the
			   main loop here. This is because all Java Sound threads
			   have been changed to be daemon threads, not preventing
			   the VM from exiting (this was not the case in 1.4.2 and
			   earlier). So we have to stay in a loop to prevent
			   exiting here.
			*/
			while (true)
			{
				/* sleep for 1 second. */
				try {
					Thread.sleep(1000);
				}
				catch (InterruptedException e) {
				}
			}
		}
	}

	private static void out(String strMessage) {
		System.out.println(strMessage);
	}

	@Override
	public void update(LineEvent event) {		
	}
}