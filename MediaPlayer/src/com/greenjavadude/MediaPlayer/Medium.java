package com.greenjavadude.MediaPlayer;

import java.io.File;
import java.io.Serializable;

public class Medium implements Serializable{
	private static final long serialVersionUID = 3406326308576163580L;
	
	private String title;
	private String author;
	private File file;
	
	public Medium(String t, File f){
		title = t;
		file = f;
		author = "Unknown Author";
	}
	
	public String getTitle() {
		return title;
	}
	
	public synchronized void setTitle(String t) {
		title = t;
	}
	
	public String getAuthor() {
		return author;
	}
	
	public synchronized void setAuthor(String a) {
		author = a;
	}
	
	public File getFile(){
		return file;
	}
	
	public synchronized void setFile(String path){
		file = new File(path);
	}
}