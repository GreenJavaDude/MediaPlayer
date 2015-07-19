package com.greenjavadude.MediaPlayer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class Control {
	private SpriteSheet sheet;
	
	private ImageIcon playIm;
	private JButton play;
	private ImageIcon pauseIm;
	
	private JPanel panel;
	
	private Player player;
	
	public Control(Player player){
		sheet = new SpriteSheet("res//SpriteSheet.png", 64, 64, 5, 5);
		playIm = new ImageIcon(sheet.getImage(0));
		pauseIm = new ImageIcon(sheet.getImage(1));
		this.player = player;
		play = new JButton();
		play.setIcon(pauseIm);
		
		play.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if(play.getIcon().equals(pauseIm)){
					pause();
				}else if(play.getIcon().equals(playIm)){
					play();
				}
			}
		});
		
		panel.add(play);
	}
	
	public void pause(){
		player.pause();
		play.setIcon(playIm);
	}
	
	public void play(){
		player.continuePlaying();
		play.setIcon(pauseIm);
	}
	
	public JPanel getPanel(){
		return panel;
	}
}






