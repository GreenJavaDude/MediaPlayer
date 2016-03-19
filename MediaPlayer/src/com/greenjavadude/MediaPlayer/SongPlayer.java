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
	private Clip clip;
	
	private int lastFrame;
	
	public SongPlayer(Song s){
		super();
		song = s;
		lastFrame = 0;
		
		try{
			stream = AudioSystem.getAudioInputStream(song.getFile());
			format = stream.getFormat();
			info = new Info(Clip.class, format);
			clip = (Clip) AudioSystem.getLine(info);
		}catch(IOException e){
			e.printStackTrace();
		}catch(LineUnavailableException e){
			e.printStackTrace();
		}catch(UnsupportedAudioFileException e){
			e.printStackTrace();
		}
	}
	
	public void doStuff() throws Exception{
		clip.open(stream);
		clip.flush(); 
		clip.start();
	}
	
	public void doPause(){
		lastFrame = clip.getFramePosition();
		clip.stop();
	}
	
	public void doContinuePlaying(){
		clip.setFramePosition(lastFrame);
		clip.start();
	}
	
	public synchronized void stop(){
		super.stop();
		clip.stop();
		clip.close();
		try{
			stream.close();
		}catch(IOException e){
			
		}
		format = null;
		info = null;
	}
}