package com.greenjavadude.MediaPlayer;

import javax.swing.JPanel;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.media.*;

public class VideoPlayer implements Runnable{
	private Video video;
	private Media media;
	private MediaPlayer player;
	private MediaView mediaView;
	
	private JPanel panel;
	
	private JFXPanel jfxpanel;
	private Scene scene;
	private Pane pane;
	
	private int x;
	private int y;
	
	public VideoPlayer(Video v, JPanel p, int x, int y){
		video = v;
		panel = p;
		this.x = x;
		this.y = y;
		
		pane = new Pane();
		
		jfxpanel = new JFXPanel();
		media = new Media(video.getFile().toURI().toString());
		player = new MediaPlayer(media);
		mediaView = new MediaView(player);
		scene = new Scene(pane, x, y);
	}
	
	public void run(){
		try{
			init();
			player.play();
		}catch(Exception e){
			
		}
	}
	
	public void start(){
		new Thread(this).start();
	}
	
	public void stop(){
		player.stop();
		panel.remove(jfxpanel);
		jfxpanel.setEnabled(false);
		
		player.dispose();
	}
	
	public void init(){
		//mediaView.setFitHeight(y);
		//mediaView.setFitWidth(x);
		mediaView.autosize();
		pane.getChildren().add(mediaView);
		
		jfxpanel.setScene(scene);
		panel.add(jfxpanel);
	}
	
	
}














