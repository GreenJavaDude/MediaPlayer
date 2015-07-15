package com.greenjavadude.MediaPlayer;

import java.io.*;
import java.net.URL;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import javax.swing.*;

public class Test extends Application{
	public static void main(String[] args) {
		launch(args);
	}
	
	public void start(Stage stage) throws Exception {
		JFileChooser chooser = new JFileChooser();
		int i = chooser.showDialog(null, "save");
		URL url = chooser.getSelectedFile().toURI().toURL();
		String path = url.getPath();
		Scene scene = new Scene(new Group(), 800, 500);
		stage.setScene(scene);
		
		if(path.endsWith(".mp4")){
			Video media = new Video("title", new File(path));
			VideoPlayer vp = new VideoPlayer(media, Mode.SINGLE);
			((Group) scene.getRoot()).getChildren().add(vp.getMediaView());
			vp.start();
		}else{
			Song media = new Song("title", new File(path));
			MusicPlayer mp = new MusicPlayer(media, Mode.SINGLE);
			mp.start();
		}
		
		stage.show();
	}
}







