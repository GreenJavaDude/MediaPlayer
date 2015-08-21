package com.greenjavadude.MediaPlayer;

import java.awt.BorderLayout;
import java.io.File;

import javax.swing.*;

import com.greenjavadude.MediaPlayer.Media.*;
import com.greenjavadude.MediaPlayer.Players.*;
import com.greenjavadude.UniversalAPI.Log;

public class Test {
	private static Log l = Log.INSTANCE;
	
	public static void main(String[] args){
		l.setup(true, true, null, null);
		
		JFrame frame = new JFrame("Test");
		frame.setSize(500, 500);
		frame.setLocationRelativeTo(null);
		
		JPanel south = new JPanel();
		frame.add(south);
		/*
		Song song = new Song("Freestyle - Lady Antebellum", new File("C://Programming//test.wav"));
		SongPlayer player = new SongPlayer(song);
		Control control = new Control(player, south);
		*/
		
		Video video = new Video("Freestyle - Lady Antebellum", new File("C://Programming//test.avi"));
		VideoPlayer player = new VideoPlayer(video);
		Control control = new Control(player, south);
		
		frame.repaint();
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		l.debug("Starting...");
		control.start();
	}
}














