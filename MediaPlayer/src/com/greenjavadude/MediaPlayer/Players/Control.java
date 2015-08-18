package com.greenjavadude.MediaPlayer.Players;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import com.greenjavadude.UniversalAPI.Log;
import com.greenjavadude.UniversalAPI.GameEngine.SpriteSheet;

public class Control {
	private SpriteSheet sheet;
	private Log l = Log.INSTANCE;
	
	private ImageIcon playIm;
	private JButton play;
	private ImageIcon pauseIm;
	
	private JPanel panel;
	private JSlider slide;
	
	private Player player;
	private Thing upper;
	
	public Control(Player player, JPanel panel){
		sheet = new SpriteSheet("res//SpriteSheet.png", 64, 64, 5, 5);
		playIm = new ImageIcon(sheet.getImage(1));
		pauseIm = new ImageIcon(sheet.getImage(0));
		this.player = player;
		this.panel = panel;
		play = new JButton();
		play.setIcon(pauseIm);
		upper = new Thing();
		
		play.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if(play.getIcon().equals(pauseIm)){
					pause();
				}else if(play.getIcon().equals(playIm)){
					play();
				}
			}
		});
		
		slide = new JSlider(0, this.player.getTotalDuration(), 0);
		slide.addChangeListener(new ChangeListener(){
			public void stateChanged(ChangeEvent e){
				if(!slide.getValueIsAdjusting()){
					l.debug("Value: "+slide.getValue());
					skipTo(slide.getValue());
				}
			}
		});
		
		panel.add(play);
		panel.add(slide);
		
		Runtime.getRuntime().addShutdownHook(new Thread(){
			public void run(){
				upper.stop();
			}
		});
	}
	
	public void pause(){
		player.pause();
		play.setIcon(playIm);
	}
	
	public void play(){
		player.continuePlaying();
		play.setIcon(pauseIm);
	}
	
	public void start(){
		player.start();
		upper.start();
	}
	
	public void skipTo(int i){
		l.debug("Value used: " + i);
		player.skipTo((double) i);
	}
	
	private class Thing implements Runnable{
		boolean busy;
		
		public Thing(){
			busy = false;
		}
		
		public void run(){
			try{
				while(busy){
					try{
						Thread.sleep(1000);
					}catch(Exception e){
						
					}
					slide.setValue(slide.getValue() + 1);
					l.debug("Slide moved one second up");
				}
			}catch(Exception e){
				l.error("Thing class in Control class");
			}
		}
		
		public void start(){
			busy = true;
			new Thread(this).start();
		}
		
		public void stop(){
			busy = false;
		}
	}
}