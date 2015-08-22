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
	
	private JPanel main;
	private JPanel south;
	private JSlider slide;
	
	private Player player;
	private Thing upper;
	
	private boolean slidermanuel;
	
	public Control(Player player, JPanel main, JPanel south){
		sheet = new SpriteSheet("res//SpriteSheet.png", 64, 64, 5, 5);
		playIm = new ImageIcon(sheet.getImage(1));
		pauseIm = new ImageIcon(sheet.getImage(0));
		this.player = player;
		this.main = main;
		this.south = south;
		play = new JButton();
		play.setIcon(pauseIm);
		upper = new Thing();
		slidermanuel = false;
		
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
					if(slidermanuel){
						skipTo(slide.getValue());
					}
				}else{
					slidermanuel = true;
				}
			}
		});
		
		this.south.add(play);
		this.south.add(slide);
		
		Runtime.getRuntime().addShutdownHook(new Thread(){
			public void run(){
				upper.stop();
			}
		});
	}
	
	public synchronized void pause(){
		player.pause();
		play.setIcon(playIm);
	}
	
	public synchronized void play(){
		player.continuePlaying();
		play.setIcon(pauseIm);
	}
	
	public synchronized void start(){
		player.init(main);
		player.start();
		upper.start();
	}
	
	public synchronized void skipTo(int i){
		slidermanuel = true;
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
						Thread.sleep(500);
					}catch(Exception e){
						
					}
					slidermanuel = false;
					slide.setValue(player.getCurrentDuration());
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