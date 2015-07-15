package com.greenjavadude.MediaPlayer;

import javax.swing.JFrame;

public class Player extends JFrame{
	private static final long serialVersionUID = 2615681120010026910L;
	
	public Player(){
		setTitle("Media Player");
		
		setSize(800, 500);
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	public static void main(String[] args){
		Player player = new Player();
		player.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}