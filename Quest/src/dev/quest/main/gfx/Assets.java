package dev.quest.main.gfx;

import java.awt.image.BufferedImage;

public class Assets {
	
	private static final int width = 32, height = 32;
	
	public static BufferedImage dirt, grass, stone, tree;
	
	public static BufferedImage[] player_down;  
	public static BufferedImage[] player_up;
	public static BufferedImage[] player_right;
	public static BufferedImage[] player_left;
	public static BufferedImage[] player_stillDown;
	public static BufferedImage[] player_stillUp;
	public static BufferedImage[] player_stillLeft;
	public static BufferedImage[] player_stillRight;
	
	public static void init(){
		SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("/textures/map.png"));
		SpriteSheet sheet2 = new SpriteSheet(ImageLoader.loadImage("/textures/char.png"));
		
		//Tiles
		stone = sheet.crop(192, 352, width, height);
		dirt = sheet.crop(64, 0, width, height);
		grass = sheet.crop(0, 0, width, height);
		tree = sheet.crop(0, 32, width, height);
		
		//Player Down
		player_down = new BufferedImage[10];
		player_down[0] = sheet2.crop(0, 520, 120, 130);
		player_down[1] = sheet2.crop(120, 520, 120, 130);
		player_down[2] = sheet2.crop(240, 520, 120, 130);
		player_down[3] = sheet2.crop(360, 520, 120, 130);
		player_down[4] = sheet2.crop(480, 520, 120, 130);
		player_down[5] = sheet2.crop(600, 520, 120, 130);
		player_down[6] = sheet2.crop(720, 520, 120, 130);
		player_down[7] = sheet2.crop(840, 520, 120, 130);
		player_down[8] = sheet2.crop(960, 520, 120, 130);
		player_down[9] = sheet2.crop(1080, 520, 120, 130);
		
		//Player Left
		player_left = new BufferedImage[10];
		player_left[0] = sheet2.crop(0, 780, 120, 130);
		player_left[1] = sheet2.crop(120, 650, 120, 130);
		player_left[2] = sheet2.crop(240, 650, 120, 130);
		player_left[3] = sheet2.crop(360, 650, 120, 130);
		player_left[4] = sheet2.crop(480, 650, 120, 130);
		player_left[5] = sheet2.crop(600, 650, 120, 130);
		player_left[6] = sheet2.crop(720, 650, 120, 130);
		player_left[7] = sheet2.crop(840, 650, 120, 130);
		player_left[8] = sheet2.crop(960, 650, 120, 130);
		player_left[9] = sheet2.crop(1080, 650, 120, 130);
		
		//Player up
		player_up = new BufferedImage[10];
		player_up[0] = sheet2.crop(0, 780, 120, 130);
		player_up[1] = sheet2.crop(120, 780, 120, 130);
		player_up[2] = sheet2.crop(240, 780, 120, 130);
		player_up[3] = sheet2.crop(360, 780, 120, 130);
		player_up[4] = sheet2.crop(480, 780, 120, 130);
		player_up[5] = sheet2.crop(600, 780, 120, 130);
		player_up[6] = sheet2.crop(720, 780, 120, 130);
		player_up[7] = sheet2.crop(840, 780, 120, 130);
		player_up[8] = sheet2.crop(960, 780, 120, 130);
		player_up[9] = sheet2.crop(1080, 780, 120, 130);
		
		//Player right
		player_right = new BufferedImage[10];
		player_right[0] = sheet2.crop(0, 910, 120, 130);
		player_right[1] = sheet2.crop(120, 910, 120, 130);
		player_right[2] = sheet2.crop(240, 910, 120, 130);
		player_right[3] = sheet2.crop(360, 910, 120, 130);
		player_right[4] = sheet2.crop(480, 910, 120, 130);
		player_right[5] = sheet2.crop(600, 910, 120, 130);
		player_right[6] = sheet2.crop(720, 910, 120, 130);
		player_right[7] = sheet2.crop(840, 910, 120, 130);
		player_right[8] = sheet2.crop(960, 910, 120, 130);
		player_right[9] = sheet2.crop(1080, 910, 120, 130);
		
		//Player Standing Still Down
		player_stillDown = new BufferedImage[3];
		player_stillDown[0] = sheet2.crop(0, 0, 120, 130);
		player_stillDown[1] = sheet2.crop(120, 0, 120, 130);
		player_stillDown[2] = sheet2.crop(240, 0, 120, 130);
		
		//Player Standing Still Up
		player_stillUp = new BufferedImage[1];
		player_stillUp[0] = sheet2.crop(0, 260, 120, 130);

		
		//Player Standing Still Right
		player_stillRight = new BufferedImage[3];
		player_stillRight[0] = sheet2.crop(0, 390, 120, 130);
		player_stillRight[1] = sheet2.crop(120, 390, 120, 130);
		player_stillRight[2] = sheet2.crop(240, 390, 120, 130);
		
		//Player Standing Still Left
		player_stillLeft = new BufferedImage[3];
		player_stillLeft[0] = sheet2.crop(0, 130, 120, 130);
		player_stillLeft[1] = sheet2.crop(120, 130, 120, 130);
		player_stillLeft[2] = sheet2.crop(240, 130, 120, 130);
	}

}
