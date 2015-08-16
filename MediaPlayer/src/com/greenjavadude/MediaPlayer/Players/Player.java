package com.greenjavadude.MediaPlayer.Players;

import com.greenjavadude.UniversalAPI.Log;

public abstract class Player implements Runnable{
	protected boolean running;
	protected boolean isPaused;
	protected Log l = Log.INSTANCE;
	
	public Player(){
		running = false;
		isPaused = false;
		
		Runtime.getRuntime().addShutdownHook(new Thread(){
			public void run(){
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
	
	public abstract void doStuff() throws Exception;
	public abstract void doPause();
	public abstract void doContinuePlaying();
	public abstract void doStop();
}