package com.greenjavadude.MediaPlayer;

import javafx.embed.swing.JFXPanel;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;

public class VideoPlayer implements Runnable{
	private Mode mode;
	private Video video;
	private MediaPlayer mp;
	private MediaPanel mv;
	
	public VideoPlayer(Video vi, Mode m){
		video = vi;
		mode = m;
		
		Media media = new Media(video.getFile().toURI().toString());
		mp = new MediaPlayer(media);
		mv = new MediaPanel(video.getFile().getPath());
		
		JFXPanel panel = new JFXPanel();
		panel.setEnabled(false);
	}
	
	public void run(){
		switch(mode){
		case LOOP:
			mp.setCycleCount(MediaPlayer.INDEFINITE);
			mp.play();
			break;
		case SINGLE:
			mp.play();
			stop();
			break;
		}
	}
	
	//must add mediaview to the screen before calling stop()
	public void start(){
		new Thread(this).start();
	}
	
	//must remove mediaview off the screen before calling stop()
	public void stop(){
		if(!mp.isMute()){
			mp.stop();
		}
		mp.dispose();
	}
	
	public MediaView getMediaView(){
		return mv;
	}
}