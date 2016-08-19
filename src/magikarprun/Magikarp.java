package magikarprun; 

import processing.core.PApplet;

import processing.core.PImage;

public class Magikarp extends Shape{
	//class attributes
	PApplet p;
	PImage img;
	boolean isJumping;
	int gravity = 4;
	int yspeed = -50;
	int currentSpeed = 0;
	//constructor
	
public Magikarp (PApplet _p, String name, int _x, int _y, int _width, int _height) {
		super( _x, _y, _width, _height);
		p=_p; 
		img = p.loadImage(name);
		isJumping = false;
		
		
	}
    public void display() {
    jump();	
	p.image(img, x, y, width+50, height+50);
	// p.rect(x, y, width, height);
  }
    
    public void activateJump()
    {
    	if(isJumping == false)
    	{
    		isJumping = true;
    		currentSpeed = yspeed;
    	}
    }
    public void jump() {
    	
    	if(isJumping == true)
    	{
    		y = currentSpeed + y;
    		currentSpeed= currentSpeed + gravity;
    		if(currentSpeed > - yspeed)
    		{
    			currentSpeed = 0;
    	        isJumping=false;
    		}
    	}
    	}
    }


