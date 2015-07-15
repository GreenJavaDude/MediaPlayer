package com.greenjavadude.MediaPlayer;

import java.io.File;

public class Test {
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
}