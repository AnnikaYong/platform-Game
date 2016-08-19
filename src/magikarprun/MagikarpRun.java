package magikarprun;

import java.util.ArrayList;

import ddf.minim.AudioPlayer;
import ddf.minim.Minim;
import magikarprun.Obstacle;
import processing.core.PApplet;
import processing.core.PImage;


public class MagikarpRun extends PApplet {
	public static void main (String[] args) {
		PApplet.main("magikarprun.MagikarpRun");
	}
	//list of objects in game
	PApplet p;
	ArrayList<Obstacle>waves;
	Magikarp magikarp;
    Obstacle obstacle;
    Obstacle obstacle2; 
    PImage img;
    int platform;
    int score;
    AudioPlayer song;
    Minim minim;
    boolean gameOver = false;
    PImage yo;
    int timer=0;
    long lastTime = System.currentTimeMillis();
    boolean playing = true;
    int highscore = 0;
	public void settings() {
		size(1500, 844);
	}
	public void setup() {
		platform = height-300;
		waves = new ArrayList<Obstacle>();
		magikarp = new Magikarp(this, "floppy copy.png", 100, platform, 100, 100);
	    obstacle = new Obstacle(this, width, platform, 50, 200, 20);
	    obstacle2 = new Obstacle(this, width +900, platform, 50, 200, 20); 
	    waves.add(obstacle);
		waves.add(obstacle2);
	    img = loadImage("background4.jpg");
	    background(img);
		frameRate=60;
		minim = new Minim(this);
		song = minim.loadFile("punishment.mp3",512);
		yo = loadImage("Game Over title.jpg");
	}

	public void draw() {
		if(playing == true)
		{	
			background(img);
			magikarp.display();
			//syntax for controlling objects in an ArrayList
			for (int i = 0; i < waves.size(); i++) {
				Obstacle tempOb = waves.get(i);
				tempOb.display();
				tempOb.move();
				checkCollisions();
				text(highscore, 700, 200); 
			    timer();
			    textSize(32);
			    text(timer, 100, 100);
			}
			}else{
				// PLAYING IS FALSE (GAME IS OVER) 
				if (keyPressed == true && key=='r'){
					obstacle.x = width;
					obstacle2.x = width +900; 
					int newscore = timer; 
					if (newscore > highscore) {
						highscore = newscore; 
					}
		        	 timer = 0;
		        	 playing = true;
				}
		}
	}
		
	
	public void keyPressed()
	{
		if(key =='m')
		
			magikarp.activateJump();
	}
	//public void checkCollisions(Obstacle obst)
	public void checkCollisions()
	{
		if(magikarp.hasCollided(obstacle))
		{
		
			song.play();
		    gameOver();
		    
		}
		if(magikarp.hasCollided(obstacle2))
		{
			song.play();
			song.rewind();
		    gameOver(); 
		   
		}
		
	}
   
     public void gameOver()
     { 
    	 
    	 background(0);
    	 image(yo, 0,0, 1400, 914);
    	 fill(255); 
         text("press r to restart", 1000, 200);
         text("wow much failure",1000, 400);
         text("are your ears bleeding yet?",980, 700);
         text("hah loser", 200, 400);
         text("you suck at your own game", 446,400);
         playing = false; 
    	 
     }
     public void timer() {
    	 //count single second and add 1 to a timer
    	 if(System.currentTimeMillis() - lastTime > 1000) {
    		 timer += 1;
    	 }
     }
	}

