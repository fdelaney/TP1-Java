package ca.csf.Travail_Pratique_1;

import javafx.scene.paint.Color;

public class Disk {
	private int size;
	private Color color;
	
	public Disk(){
		size = 0;		
	}

	public Disk(int size){
		this.size = size;		
	}
	
	public Disk(Color color){		
		this.color = color;
	}
	
	public Disk(int size, Color color){
		this.size = size;		
		this.color = color;
	}

	public int getSize() {
		return this.size;
	}

	public void setSize(int size) {
		this.size = size;
	}
	
	public Color getColor() {
		return this.color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

}