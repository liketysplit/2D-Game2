package dev.quest.main;

import dev.quest.main.display.Display;

public class Launcher {

		public static void main (String[]args){
			Game quest = new Game("Quest", 1024, 768);
			quest.start();
		}
}
