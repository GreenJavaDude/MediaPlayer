package com.greenjavadude.MediaPlayer.Media;

import java.io.File;
import java.util.ArrayList;

import com.greenjavadude.UniversalAPI.Saver;

public class Library {
	private ArrayList<Medium> media;
	private File saveLocation;
	private Saver saver;
	
	public Library(String location){
		media = new ArrayList<Medium>();
		saveLocation = new File(location);
		saver = new Saver();
	}
	
	public void save(){
		saver.saveToSer(this, saveLocation.getAbsolutePath());
	}
	
	public static Library loadLibrary(String path){
		File file = new File(path);
		Saver save = new Saver();
		Library lib = null;
		try{
			lib = (Library) save.getFromSer(file.getAbsolutePath());
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
	
	public ArrayList<Medium> getMedia(){
		return media;
	}
	
	public synchronized void setMedia(ArrayList<Medium> m){
		media = m;
	}
	
	public synchronized void add(Medium m){
		media.add(m);
	}
	
	public synchronized void remove(Medium m){
		media.remove(m);
	}
	
	public Medium getMedia(int i){
		return media.get(i);
	}
}