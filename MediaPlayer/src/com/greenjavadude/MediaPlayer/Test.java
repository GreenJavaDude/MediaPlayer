package com.greenjavadude.MediaPlayer;

import javax.swing.*;

public class Test {
	public static void main(String[] args){
		JFrame frame = new JFrame();
		frame.setTitle("Music Test");
		frame.setSize(500, 500);
		frame.setLocationRelativeTo(null);
		
		
		
		
		frame.setVisible(true);
	}
	
	
	
	
	
	
	
	
	
	
	//this is working
	/*
	public static void main(String[] args){
		Song song = new Song("Testsong", new File("C://Programming//test.wav"));
		SongPlayer player = new SongPlayer(song);
		player.start();
		try{
			Thread.sleep(5000);
		}catch(Exception e){
			
		}
		player.pause();
		try{
			Thread.sleep(5000);
		}catch(Exception e){
			
		}
		player.continuePlaying();
		try{
			Thread.sleep(5000);
		}catch(Exception e){
			
		}
		player.stop();
	}
	*/
}