package com.greenjavadude.MediaPlayer;

import javafx.embed.swing.JFXPanel;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class MusicPlayer implements Runnable{
	private Mode mode;
	private MediaPlayer mp;
	private Song song;
	
	public MusicPlayer(Song s, Mode m){
		mode = m;
		song = s;
		Media media = new Media(song.getFile().toURI().toString());
		mp = new MediaPlayer(media);
		
		//this is used to initialize some stuff for the music
		//the mediaplayer is from javafx so this is necessary
		JFXPanel panel = new JFXPanel();
		panel.setEnabled(false);//if i don't use it it's yellow
	}
	
	public void run(){
		switch(mode){
		case LOOP:
			mp.setCycleCount(MediaPlayer.INDEFINITE);
			break;
		case SINGLE:
			mp.play();
			mp.stop();
			break;
		}
		
		
		if(mode.equals(Mode.LOOP)){
			mp.setCycleCount(MediaPlayer.INDEFINITE);
			mp.play();
		}
		if(mode.equals(Mode.SINGLE)){
			mp.play();
			this.stop();
		}
	}
	
	public void start(){
		new Thread(this).start();
	}
	
	public void stop(){
		if(!mp.isMute()){
			mp.stop();
		}
		mp.dispose();
	}
}