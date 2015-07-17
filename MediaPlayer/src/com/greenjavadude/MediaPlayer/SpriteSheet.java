package com.greenjavadude.MediaPlayer;

import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

public class SpriteSheet {
	private BufferedImage image;
	private int width;
	private int height;
	private int rows;
	private int columns;
	private BufferedImage[] sprites;
	
	public SpriteSheet(String path, int width, int height, int rows, int columns){
		this.width = width;
		this.height = height;
		this.rows = rows;
		this.columns = columns;
		sprites = new BufferedImage[rows*columns];
		
		try{
			image = ImageIO.read(new File(path));
		}catch(Exception e){
			System.out.println("Couldn't read spritesheet");
			return;
		}
		
		for(int i = 0; i<rows; i++){
			for(int j = 0; j<columns; j++){
				sprites[i*columns+j] = image.getSubimage(j*width, i*height, width, height);
			}
		}
	}

	public BufferedImage getBigImage() {
		return image;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public int getRows() {
		return rows;
	}

	public int getColumns() {
		return columns;
	}

	public BufferedImage[] getSprites() {
		return sprites;
	}
	
	public BufferedImage getImage(int x){
		return sprites[x];
	}
	
	public int getAmountImages(){
		return rows*columns;
	}
}