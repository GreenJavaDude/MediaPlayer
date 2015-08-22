package com.greenjavadude.MediaPlayer.Players;

import com.greenjavadude.MediaPlayer.Media.Song;
import javafx.embed.swing.JFXPanel;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;

public class SongPlayer extends Player{
	private MediaPlayer mp;
	
	public SongPlayer(Song s){
		super(s);
		JFXPanel panel = new JFXPanel();
		panel.setEnabled(false);
		Media media = new Media(medium.getFile().toURI().toString());
		mp = new MediaPlayer(media);
	}
	
	public synchronized void doStuff() throws Exception{
		mp.play();
	}
	
	public synchronized void doPause(){
		mp.pause();
	}
	
	public synchronized void doContinuePlaying(){
		mp.play();
	}
	
	public synchronized void doStop(){
		mp.stop();
		mp.dispose();
	}
	
	public synchronized void skipTo(double d){
		Duration dur = new Duration(d*1000);
		
		if(mp == null){
			return;
		}
		
		if(mp.getTotalDuration().greaterThan(dur)){
			mp.seek(dur);
		}
	}
	
	public int getTotalDuration(){
		return (int) mp.getTotalDuration().toSeconds();
	}
	
	public int getCurrentDuration(){
		return (int) mp.getCurrentTime().toSeconds();
	}
}