package com.greenjavadude.MediaPlayer;

public abstract class Player implements Runnable{
	protected boolean running;
	
	public Player(){
		running = false;
	}
	
	public void run(){
		try{
			doStuff();
		}catch(Exception e){
			
		}
	}
	
	public void start(){
		running = true;
		new Thread(this).start();
	}
	
	public void stop(){
		running = false;
	}
	
	public abstract void doStuff() throws Exception;
}