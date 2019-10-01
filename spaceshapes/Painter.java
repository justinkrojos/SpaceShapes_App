package spaceshapes;

import java.awt.Color;
import java.awt.Image;

//import java.awt.Color;

/** 
 * Interface to represent a type that offers primitive drawing methods.
 * 
 * @author Paramvir Singh (Original Author - Ian Warren)
 * 
 */
public interface Painter {
	/**
	 * Draws a rectangle. Parameters x and y specify the top left corner of the
	 * oval. Parameters width and height specify its width and height.
	 */
	public void drawRect(int x, int y, int width, int height);
	
	/**
	 * Draws an oval. Parameters x and y specify the top left corner of the
	 * oval. Parameters width and height specify its width and height.
	 */
	public void drawOval(int x, int y, int width, int height);
	
	/**
	 * Draws a line. Parameters x1 and y1 specify the starting point of the 
	 * line, parameters x2 and y2 the ending point.
	 */
	public void drawLine(int x1, int y1, int x2, int y2);
	
	public void translate( int x, int y );
	
	public void drawCentredText(String string, Shape shape);
	
	public void drawImage(Image img, int x, int y, int width, int height);
	
	public void getColor();
	
	public void setColor(Color color);
	
	public void fillRect(int x, int y, int width, int height);
}
