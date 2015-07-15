package com.greenjavadude.MediaPlayer;

import javax.swing.JPanel;

import javafx.embed.swing.JFXPanel;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.media.*;

public class VideoPlayer implements Runnable{
	private boolean running;
	private Video video;
	private Media media;
	private MediaPlayer player;
	private MediaView mediaView;
	
	private JPanel panel;
	
	private JFXPanel jfxpanel;
	private Scene scene;
	private Pane pane;
	
	public VideoPlayer(Video v, JPanel p){
		running = false;
		video = v;
		panel = p;
		
		pane = new Pane();
		
		jfxpanel = new JFXPanel();
		media = new Media(video.getFile().toURI().toString());
		player = new MediaPlayer(media);
		mediaView = new MediaView(player);
		scene = new Scene(pane, 500, 500);
	}
	
	public void run(){
		try{
			init();
			player.play();
		}catch(Exception e){
			
		}
	}
	
	public void start(){
		running = true;
		new Thread(this).start();
	}
	
	public void stop(){
		running = false;
		player.stop();
		panel.remove(jfxpanel);
		jfxpanel.setEnabled(false);
		
		player.dispose();
	}
	
	public void init(){
		//adds stuff
		pane.getChildren().add(mediaView);
		
		jfxpanel.setScene(scene);
		panel.add(jfxpanel);
	}
	
	
}