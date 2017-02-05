package dev.quest.main.entities.creatures;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import dev.quest.main.Handler;
import dev.quest.main.gfx.Animation;
import dev.quest.main.gfx.Assets;

public class Player extends Creature{
	
	private Animation walkDown,walkUp,walkRight,walkLeft,stillDown,stillUp,stillRight,stillLeft;
	private boolean left,right,up,down;
	
	
	public Player(Handler handler, float x, float y) {
		super(handler, x, y, Creature.DEFAULT_CREATURE_WIDTH, Creature.DEFAULT_CREATURE_HEIGHT);
		
		boundingBox.x = 8;
		boundingBox.y = 16;
		boundingBox.width = 16;
		boundingBox.height = 16;
		
		//Animations
		walkDown = new Animation(250, Assets.player_down);
		walkUp = new Animation(250, Assets.player_up);
		walkRight = new Animation(250, Assets.player_right);
		walkLeft = new Animation(250, Assets.player_left);
		stillDown = new Animation(250, Assets.player_stillDown);
		stillUp = new Animation(250, Assets.player_stillUp);
		stillLeft = new Animation(250, Assets.player_stillLeft);
		stillRight = new Animation(250, Assets.player_stillRight);
		
	}

	@Override
	public void tick() {
		//Animations
		walkRight.tick();
		walkLeft.tick();
		walkDown.tick();
		walkUp.tick();
		stillDown.tick();
		
		//Movement
		getInput();
		move();
		handler.getGameCamera().centerEntity(this);
	}
	
	private void getInput(){
		xMove = 0;
		yMove = 0;
		
		if(handler.getKeyManager().up)
			yMove = -speed;
		if(handler.getKeyManager().down)
			yMove = speed;
		if(handler.getKeyManager().left)
			xMove = -speed;
		if(handler.getKeyManager().right)
			xMove = speed;
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(getCurrentAnimationFrame(), (int) (x - handler.getGameCamera().getxOffset()), 
								   (int) (y - handler.getGameCamera().getyOffset()), 
								   width, height, null);
//		g.setColor(Color.red);
//		g.fillRect((int)(x + boundingBox.x -handler.getGameCamera().getxOffset()), 
//				   (int)(y + boundingBox.y -handler.getGameCamera().getyOffset()), 
//				   boundingBox.width, boundingBox.height);
}
	
	private BufferedImage getCurrentAnimationFrame(){
		
		
		
		if(xMove < 0){
			left = true;
			right = false;
			up = false;
			down = false;
			return walkLeft.getCurrentFrame();
		}else if(xMove > 0){
			left = false;
			right = true;
			up = false;
			down = false;
			return walkRight.getCurrentFrame();
		}else if(yMove < 0){
			left = false;
			right = false;
			up = true;
			down = false;
			return walkUp.getCurrentFrame();
		}else if(yMove > 0){
			left = false;
			right = false;
			up = false;
			down = true;
			return walkDown.getCurrentFrame();
		}
		else{
			if(right){
				return stillRight.getCurrentFrame();
			}	
		    else if(left){
		    	return stillLeft.getCurrentFrame();
		    }
			else if (up){
				return stillUp.getCurrentFrame();
			}
			else{	
			return stillDown.getCurrentFrame();
			}
		}
			
			
}
}
