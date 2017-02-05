package dev.quest.main.worlds;

import java.awt.Graphics;

import dev.quest.main.Handler;
import dev.quest.main.tiles.Tile;
import dev.quest.main.utils.Utils;

public class World {
	
	private Handler handler;
	private int width, height;
	private int[][] tiles;
	private int spawnX, spawnY;
	
	public World(Handler handler, String path){
		this.handler = handler;
		loadWorld(path);
		
	}
	
	public void tick(){
		
	}
	
	public void render(Graphics g){
		int xStart = (int) Math.max(0, handler.getGameCamera().getxOffset() / Tile.TILE_WIDTH);
		int xStop = (int) Math.min(width, (handler.getGameCamera().getxOffset() + handler.getWidth() + 1));
		int yStart = (int) Math.max(0, handler.getGameCamera().getyOffset() / Tile.TILE_HEIGHT);
		int yStop = (int) Math.min(height, (handler.getGameCamera().getyOffset() + handler.getHeight() + 1));
		
		for(int y = yStart; y < yStop; y ++)
			for (int x = xStart; x < xStop; x ++)
				getTile(x, y).render(g, (int)(x * Tile.TILE_WIDTH - handler.getGameCamera().getxOffset()), 
										(int)(y * Tile.TILE_HEIGHT - handler.getGameCamera().getyOffset()));
	}
	
	public Tile getTile(int x, int y){
		
		if (x < 0 || y < 0 || x >= width || y >= height)
			return Tile.grassTile;
		
		Tile t = Tile.tiles[tiles[x][y]];
		
		if (t == null)
		return Tile.dirtTile;
		
		return t;
		
	}
	
	private void loadWorld(String path){
		String file = Utils.loadFileAsString(path);
		String [] mapTokens = file.split("\\s+");
		width = Utils.parseInt(mapTokens[0]);
		height = Utils.parseInt(mapTokens[1]);
		this.spawnX = Utils.parseInt(mapTokens[2]);
		this.spawnY = Utils.parseInt(mapTokens[3]);
		
		tiles = new int[width][height];
		
		for(int y = 0; y < height; y ++)
			for (int x = 0; x < width; x ++)
				tiles[x][y] = Utils.parseInt(mapTokens[(x + y * width) + 4]);
	}
	
	public int getWidth(){
		return width;
	}
	public int getHeight(){
		return height;
	}
}