package com.greenjavadude.MediaPlayer;

import java.io.*;
import java.net.URL;

import javax.swing.*;

public class Test{
	public static void main(String[] args) {
		JFrame frame = new JFrame("Player");
		JFileChooser chooser = new JFileChooser();
		int choice = chooser.showOpenDialog(null);
		URL url = chooser.getSelectedFile().toURI().toURL();
		File file = new File(url);
		
		if(path.endsWith(".mp4")){
			Video media = new Video("title", new File(path));
			VideoPlayer vp = new VideoPlayer(media, Mode.SINGLE);
			frame.add(vp.getMediaView());
		}else{
			Song media = new Song("title", new File(path));
		}
		
		frame.setSize(800, 500);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
}