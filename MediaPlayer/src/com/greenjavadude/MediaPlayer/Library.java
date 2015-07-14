package com.greenjavadude.MediaPlayer;

import java.io.File;
import java.util.ArrayList;

public class Library {
	private ArrayList<Media> media;
	private File saveLocation;
	private Saver saver;
	
	public Library(String location){
		media = new ArrayList<Media>();
		saveLocation = new File(location);
		saver = new Saver();
	}
	
	public void save(){
		saver.saveToSer(this, saveLocation);
	}
	
	public static Library loadLibrary(String path){
		File file = new File(path);
		Saver save = new Saver();
		Library lib = null;
		try{
			lib = (Library) save.getFromSer(file);
		}catch(Exception e){
			
		}
		return lib;
	}
	
	public synchronized void setSaveLocation(String location){
		saveLocation = new File(location);
	}
	
	public File getSaveLocation(){
		return saveLocation;
	}
	
	public ArrayList<Media> getMedia(){
		return media;
	}
	
	public synchronized void setMedia(ArrayList<Media> m){
		media = m;
	}
	
	public synchronized void add(Media m){
		media.add(m);
	}
	
	public synchronized void remove(Media m){
		media.remove(m);
	}
	
	public Media getMedia(int i){
		return media.get(i);
	}
}