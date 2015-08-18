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
	
	public void doStuff() throws Exception{
		mp.play();
	}
	
	public void doPause(){
		mp.pause();
	}
	
	public void doContinuePlaying(){
		mp.play();
	}
	
	public void doStop(){
		mp.stop();
		mp.dispose();
	}
	
	public void skipTo(double d){
		//double d is in ms
		Duration dur = new Duration(d*1000);
		l.debug("seconds in skipTo SongPlayer: "+d);
		if(mp == null){
			l.debug("MediaPlayer is null");
			return;
		}
		l.debug("The Song's total duration: " + mp.getTotalDuration().toString());
		if(mp.getTotalDuration().greaterThan(dur)){
			l.debug("Value is usable");
			mp.seek(dur);
		}
	}
	
	public int getTotalDuration(){
		return (int) mp.getTotalDuration().toSeconds();
	}
}












