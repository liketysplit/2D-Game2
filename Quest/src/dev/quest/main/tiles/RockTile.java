package dev.quest.main.tiles;

import dev.quest.main.gfx.Assets;

public class RockTile extends Tile {

	public RockTile(int id) {
		super(Assets.stone, id);
		
	}
	@Override
	public boolean isSolid(){
		return true;
	}

}
