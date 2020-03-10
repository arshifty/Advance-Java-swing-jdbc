package Calculator_Watch;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.midi.Soundbank;
import javax.sound.sampled.*;
import javax.swing.JOptionPane;

import javazoom.jl.player.Player;
import sun.audio.*;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;
import sun.audio.ContinuousAudioDataStream;

public class mp3Pro {

	
	public void checkAlarm(final int a, final int b)
	{
		Thread t=new Thread()
				{
			public void run()
			{
				int wl=0;
				while(wl==0)
				{
					Calendar c = new GregorianCalendar();
					int ahour=c.get(Calendar.HOUR);
					int amin=c.get(Calendar.MINUTE);
					
					if(a==ahour  && b==amin)
					{
						/// JOptionPane.showMessageDialog(null, "Alarm worked");
					
						
						try
						{
							
							File file=new File("G:\\1 project\\src\\Calculator_Watch\\3idiots05.mp3");
							FileInputStream fis=new FileInputStream(file);
							BufferedInputStream bis=new BufferedInputStream(fis);
							
							try
							{
								Player player=new Player(bis);
								player.play();
							}
							catch(Exception eee)
							{
								
							}
							
							
							
							
						}
						catch(Exception ex)
						{
							
						}
						
						
						
					}
				}
			}
				};
				t.setPriority(Thread.MIN_PRIORITY);
				t.start();
	}
	
	
	public static void main(String[] args) 
	{
		mp3Pro ac=new mp3Pro();
		ac.checkAlarm(4,07);
		
		
	
	}

	

}
