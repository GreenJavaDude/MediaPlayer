package com.greenjavadude.MediaPlayer;

import java.io.IOException;
import javax.sound.sampled.*;
import javax.sound.sampled.DataLine.Info;

public class SongPlayer extends Player{
	public static final int BYTE_BUFFER = 4096;
	
	private Song song;
	
	private AudioInputStream stream;
	private AudioFormat format;
	private Info info;
	private SourceDataLine line;
	
	public SongPlayer(Song s){
		super();
		song = s;
		
		try{
			stream = AudioSystem.getAudioInputStream(song.getFile());
			format = stream.getFormat();
			info = new Info(SourceDataLine.class, format);
			line = (SourceDataLine) AudioSystem.getLine(info);
		}catch(IOException e){
			
		}catch(LineUnavailableException e){
			
		}catch(UnsupportedAudioFileException e){
			
		}
	}
	
	public void doStuff() throws Exception{
		line.open(format);
		
		line.start();
		
		byte[] buffer = new byte[BYTE_BUFFER];
		int bytesread = -1;
		
		while((running) && ((bytesread = stream.read(buffer)) != -1)){
			line.write(buffer, 0, bytesread);
		}
		stop();
	}
	
	public void stop(){
		super.stop();
		try{
			stream.close();
		}catch(IOException e){
			
		}
		format = null;
		info = null;
		line.close();
		song = null;
	}
}