package com.greenjavadude.MediaPlayer.Players;

import javax.swing.JPanel;

import com.greenjavadude.MediaPlayer.Media.Video;

import javafx.embed.swing.JFXPanel;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.util.Duration;

public class VideoPlayer extends Player{
	private MediaPlayer mp;
	private MediaView mv;
	private JFXPanel jfx;
	
	public VideoPlayer(Video v){
		super(v);
		jfx = new JFXPanel();
		Media media = new Media(v.getFile().toURI().toString());
		mp = new MediaPlayer(media);
		mv = new MediaView(mp);
	}
	
	public int getTotalDuration(){
		return (int) mp.getTotalDuration().toSeconds();
	}
	
	public int getCurrentDuration(){
		return (int) mp.getCurrentTime().toSeconds();
	}
	
	public synchronized void skipTo(double d){
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
	
	public synchronized void init(JPanel panel){
		panel.add(jfx);
	}
}












