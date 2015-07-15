package com.greenjavadude.MediaPlayer;

import java.io.File;

import javax.swing.*;

public class Test {
	public static void main(String[] args){
		JFrame frame = new JFrame("Video test");
		File file = new File("C://Programming//test.mp4");
		
		frame.setSize(500, 500);
		JPanel panel = new JPanel();
		frame.add(panel);
		
		Video video = new Video("Freestyle - Lady Antebellum", file);
		VideoPlayer player = new VideoPlayer(video, panel);
		
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		player.start();
	}
	
	
	
	
	/*
	public static void main(String[] args){
		Song song = new Song("Testsong", new File("C://Programming//test.wav"));
		SongPlayer player = new SongPlayer(song);
		player.start();
		
		try{
			Thread.sleep(5000);
		}catch(Exception e){
			
		}
		player.stop();
	}
	*/
}