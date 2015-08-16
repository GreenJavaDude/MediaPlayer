package com.greenjavadude.MediaPlayer.Players;

import com.greenjavadude.MediaPlayer.Media.Song;

import javafx.embed.swing.JFXPanel;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class SongPlayer extends Player{
	private Song song;
	private MediaPlayer mp;
	
	public SongPlayer(Song s){
		super();
		song = s;
	}
	
	public void doStuff() throws Exception{
		try{
			JFXPanel panel = new JFXPanel();
			
			Media media = new Media(song.getFile().toURI().toString());
			mp = new MediaPlayer(media);
			
			mp.play();
		}catch(Exception e){
			
		}
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
}