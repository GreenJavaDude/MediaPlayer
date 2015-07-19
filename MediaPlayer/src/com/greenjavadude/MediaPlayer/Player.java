package com.greenjavadude.MediaPlayer;

public abstract class Player implements Runnable{
	protected boolean running;
	protected boolean isPaused;
	
	public Player(){
		running = false;
		isPaused = false;
	}
	
	public void run(){
		try{
			doStuff();
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("Error at doStuff in Player.class");
		}
	}
	
	public void start(){
		running = true;
		new Thread(this).start();
	}
	
	public void stop(){
		running = false;
	}
	
	public void pause(){
		if((running) && (!isPaused)){
			isPaused = true;
			doPause();
		}
	}
	
	public void continuePlaying(){
		if(isPaused && running){
			doContinuePlaying();
		}
	}
	
	public abstract void doStuff() throws Exception;
	public abstract void doPause();
	public abstract void doContinuePlaying();
}