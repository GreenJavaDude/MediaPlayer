package com.greenjavadude.MediaPlayer;

import java.awt.Image;

import javax.swing.JButton;

public class Control {
	private SpriteSheet sheet;
	
	private Image playIm;
	private JButton play;
	private Image pauseIm;
	
	private VideoPlayer player;
	
	public Control(VideoPlayer player){
		sheet = new SpriteSheet("//SpriteSheet.png", 64, 64, 5, 5);
		playIm = sheet.getImage(0);
		pauseIm = sheet.getImage(1);
		this.player = player;
	}
}