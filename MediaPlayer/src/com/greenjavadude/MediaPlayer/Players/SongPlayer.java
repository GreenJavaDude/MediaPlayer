package com.greenjavadude.MediaPlayer.Players;

import com.greenjavadude.MediaPlayer.Media.Song;

import javafx.embed.swing.JFXPanel;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;

public class SongPlayer extends Player{
	private Song song;
	private MediaPlayer mp;
	
	public SongPlayer(Song s){
		super();
		song = s;
	}
	
	public void doStuff() throws Exception{
		JFXPanel panel = new JFXPanel();
		panel.setEnabled(false);
		Media media = new Media(song.getFile().toURI().toString());
		mp = new MediaPlayer(media);
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
		Duration dur = new Duration(d);
		l.debug("Ms: "+d);
		if(mp == null){
			l.debug("MediaPlayer is null");
		}
		l.debug("MediaPlayer's volume" + mp.getVolume());
		l.debug("The Song's total duration: " + mp.getTotalDuration().toString());
		if(mp.getTotalDuration().greaterThan(dur)){
			mp.seek(dur);
		}
	}
}












