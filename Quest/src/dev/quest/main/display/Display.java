package dev.quest.main.display;

import java.awt.Canvas;
import java.awt.Dimension;
import javax.swing.JFrame;

public class Display {

	private JFrame frame;
	private Canvas canvas;
	
	private String title;
	private int width, height;
	
	public Display(String title, int width, int height){
		this.title=title;
		this.width=width;
		this.height=height;
		
		createDisplay();
	}
	
	private void createDisplay(){
		
		frame = new JFrame(title);
		frame.setSize(width, height); //Sets Frame size based on width and height
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Closes frame properly
		frame.setResizable(false);
		frame.setLocationRelativeTo(null); // Default Display startup location
		frame.setVisible(true);
		
		canvas = new Canvas();
		canvas.setPreferredSize(new Dimension(width, height)); //Sets preferred size of canvas
		canvas.setMaximumSize(new Dimension(width, height)); //Sets preferred size of canvas
		canvas.setMinimumSize(new Dimension(width, height)); //Sets preferred size of canvas
		canvas.setFocusable(false);
		
		frame.add(canvas);
		frame.pack();
	}
	public Canvas getCanvas(){
		return canvas;
	}
	
	public JFrame getFrame(){
		return frame;
	}
	
}
