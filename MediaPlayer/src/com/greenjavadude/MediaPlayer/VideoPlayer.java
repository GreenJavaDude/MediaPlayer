package com.greenjavadude.MediaPlayer;

import javax.swing.JPanel;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.media.*;

public class VideoPlayer extends Player{
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
		super();
		video = v;
		panel = p;
		this.x = x;
		this.y = y;
		
		pane = new Pane();
		
		jfxpanel = new JFXPanel();
		media = new Media(video.getFile().toURI().toString());
		player = new MediaPlayer(media);
		mediaView = new MediaView(player);
		scene = new Scene(pane, this.x, this.y);
	}
	
	public void doStuff() throws Exception{
		init();
		player.play();
	}
	
	public void stop(){
		super.stop();
		player.stop();
		panel.remove(jfxpanel);
		jfxpanel.setEnabled(false);
		
		player.dispose();
	}
	
	public void init(){
		mediaView.autosize();
		pane.getChildren().add(mediaView);
		
		jfxpanel.setScene(scene);
		panel.add(jfxpanel);
	}
	
	
}














