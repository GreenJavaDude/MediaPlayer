package com.greenjavadude.MediaPlayer;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Saver {
	public boolean saveToSer(Object obj, File f){
		boolean success = false;
		try{
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(f.getAbsolutePath()));
			try{
				oos.writeObject(obj);
				success = true;
			}finally{
				oos.close();
			}
		}catch(Exception e){
			
		}
		return success;
	}
	
	public Object getFromSer(File f){
		Object obj = null;
		try{
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f.getAbsolutePath()));
			try{
				obj = ois.readObject();
			}finally{
				ois.close();
			}
		}catch(Exception e){
			
		}
		return obj;
	}
}