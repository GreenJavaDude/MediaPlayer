package com.greenjavadude.MediaPlayer.Players;

import javax.swing.JPanel;

import com.greenjavadude.MediaPlayer.Media.Medium;
import com.greenjavadude.UniversalAPI.Log;

public abstract class Player implements Runnable{
	protected boolean running;
	protected boolean isPaused;
	protected Log l = Log.INSTANCE;
	protected Medium medium;
	
	public Player(Medium m){
		running = false;
		isPaused = false;
		medium = m;
		
		Runtime.getRuntime().addShutdownHook(new Thread(){
			public void run(){
				l.debug("Shutting down player through shutdownhook");
				stopPlayer();
			}
		});
	}
	
	public void run(){
		try{
			doStuff();
		}catch(Exception e){
			l.error("doStuff in Player" + e.toString());
		}
	}
	
	public synchronized void start(){
		running = true;
		new Thread(this).start();
	}
	
	public synchronized void stopPlayer(){
		isPaused = false;
		running = false;
		doStop();
	}
	
	public synchronized void pause(){
		if((running) && (!isPaused)){
			doPause();
			isPaused = true;
		}
	}
	
	public synchronized void continuePlaying(){
		if(isPaused && running){
			doContinuePlaying();
			isPaused = false;
		}
	}
	
	public Medium getMedium(){
		return medium;
	}
	
	public abstract int getTotalDuration();
	public abstract int getCurrentDuration();
	public abstract void skipTo(double d);
	public abstract void doStuff() throws Exception;
	public abstract void doPause();
	public abstract void doContinuePlaying();
	public abstract void doStop();
	public void init(JPanel panel){
		
	}
}










