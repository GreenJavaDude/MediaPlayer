package com.greenjavadude.MediaPlayer;

import java.io.File;
import javax.swing.*;

public class Test {
	//add controls to the screen in videoplayer AND songplayer
	//video probably won't fit screen
	
	public static final int X = 500;
	public static final int Y = 500;
	
	public static void main(String[] args){
		JFrame frame = new JFrame("Video test");
		File file = new File("C://Programming//test.mp4");
		
		JPanel panel = new JPanel();
		frame.add(panel);
		
		Video video = new Video("Freestyle - Lady Antebellum", file);
		VideoPlayer player = new VideoPlayer(video, panel, X, Y);
		
		frame.setSize(X, Y);
		
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		player.start();
	}
	
	
	//the music is working
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