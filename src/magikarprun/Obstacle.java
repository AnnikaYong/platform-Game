package magikarprun;

import processing.core.PApplet;
//import java.util.Math; 

import processing.core.PImage;

public class Obstacle extends Shape{
	PApplet p;
	PImage img;
	int xspeed;
	public Obstacle(PApplet _p,int _x, int _y, int _width, int _height, int _xspeed) 
	{
		super(_x, _y, _width, _height);
   	    p = _p;
   	    img = p.loadImage("gary1.png");
   	    xspeed = _xspeed;
	}
	
	public void display() {
		p.image(img, x, y, width+100, height);
		//p.rect(x, y, width, height);
	  }
	public void move()
    {
		x -= xspeed;
    if (x<= 0) {
    	int random = 400 + (int)(Math.random()*600);
    	x= p.width + random;
    }
    }
	
	
	
}

