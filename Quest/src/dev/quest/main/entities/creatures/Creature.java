package dev.quest.main.entities.creatures;

import dev.quest.main.Handler;
import dev.quest.main.entities.Entity;
import dev.quest.main.tiles.Tile;

public abstract class Creature extends Entity  {
	
	public static final int DEFAULT_HEALTH = 10;
	public static final float DEFAULT_SPEED = 3.0f;
	public static final int DEFAULT_CREATURE_WIDTH = 32;
	public static final int DEFAULT_CREATURE_HEIGHT = 32;
	
	
	protected int health;
	protected float speed;
	protected float xMove;
	protected float yMove;
	
	public Creature(Handler handler, float x, float y, int width, int height) {
		super(handler, x, y, width, height);
		health = DEFAULT_HEALTH;
		speed = DEFAULT_SPEED;
	}
	
	public void move(){
		MoveX();
		MoveY();
	}
	public void MoveX(){
		
		if(xMove > 0){//Moving right
			int tx = (int) (x + xMove + boundingBox.x + boundingBox.width) / Tile.TILE_WIDTH;
			
			if(!collisionWithTile(tx, (int) (y + boundingBox.y) / Tile.TILE_HEIGHT) &&
					!collisionWithTile(tx, (int) (y + boundingBox.y + boundingBox.height) / Tile.TILE_HEIGHT)){
				x += xMove;
			}
			else{
				x = tx * Tile.TILE_WIDTH - boundingBox.x - boundingBox.width - 1;
			}
		}
		
		else if(xMove < 0){//Moving left
			int tx = (int) (x + xMove + boundingBox.x) / Tile.TILE_WIDTH;
			
			if(!collisionWithTile(tx, (int) (y + boundingBox.y) / Tile.TILE_HEIGHT) &&
					!collisionWithTile(tx, (int) (y + boundingBox.y + boundingBox.height) / Tile.TILE_HEIGHT)){
				x += xMove;
			}
			
			else{
				x = tx * Tile.TILE_WIDTH + Tile.TILE_WIDTH - boundingBox.x;
			}
		}
	}
	
	public void MoveY(){
		if(yMove < 0){//Up
			int ty = (int) (y + yMove + boundingBox.y) / Tile.TILE_HEIGHT;
			
			if(!collisionWithTile((int) (x + boundingBox.x) / Tile.TILE_WIDTH, ty) &&
					!collisionWithTile((int) (x + boundingBox.x + boundingBox.width) / Tile.TILE_WIDTH, ty)){
				y += yMove;
			}
			else{
				y = ty * Tile.TILE_HEIGHT + Tile.TILE_HEIGHT - boundingBox.y;
			}
		}
		else if(yMove > 0){//Down
			int ty = (int) (y + yMove + boundingBox.y + boundingBox.height) / Tile.TILE_HEIGHT;
			
			if(!collisionWithTile((int) (x + boundingBox.x) / Tile.TILE_WIDTH, ty) &&
					!collisionWithTile((int) (x + boundingBox.x + boundingBox.width) / Tile.TILE_WIDTH, ty)){
				y += yMove;
			}
			else{
				y = ty * Tile.TILE_HEIGHT - boundingBox.y - boundingBox.height -1;
			}
		}
	}
	protected boolean collisionWithTile(int x, int y){
		return handler.getWorld().getTile(x, y).isSolid();
	}
	
	
	//Getters & Setters
	public float getxMove() {
		return xMove;
	}


	public void setxMove(float xMove) {
		this.xMove = xMove;
	}


	public float getyMove() {
		return yMove;
	}


	public void setyMove(float yMove) {
		this.yMove = yMove;
	}


	public int getHealth() {
		return health;
	}


	public void setHealth(int health) {
		this.health = health;
	}


	public float getSpeed() {
		return speed;
	}


	public void setSpeed(float speed) {
		this.speed = speed;
	}
	
}
