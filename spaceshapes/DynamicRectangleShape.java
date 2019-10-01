package spaceshapes;

import java.awt.Color;

public class DynamicRectangleShape extends Shape{
	
	private Color _color;
	private final Color _defaultColor = new Color(212, 212, 212);
	private boolean _fill;

	/**
	 * Default constructor that creates a DynamicShape instance whose instance
	 * variables are set to default values.
	 */
	public DynamicRectangleShape() {
		super();
	}

	/**
	 * Creates a DynamicShape instance with specified values for instance 
	 * variables.
	 * @param color color of the shape
	 */
	public DynamicRectangleShape(Color color) {
		super();
		_color = color;
	}
	
	/**
	 * Creates a DynamicShape instance with specified values for instance 
	 * variables.
	 * @param x x position.
	 * @param y y position.
	 * @param deltaX speed and direction for horizontal axis.
	 * @param deltaY speed and direction for vertical axis.
	 */
	public DynamicRectangleShape(int x, int y, int deltaX, int deltaY) {
		super(x,y,deltaX,deltaY);
	}
	
	/**
	 * Creates a DynamicShape instance with specified values for instance 
	 * variables.
	 * @param x x position.
	 * @param y y position.
	 * @param deltaX speed and direction for horizontal axis.
	 * @param deltaY speed and direction for vertical axis.
	 * @param color color of the shape
	 */
	public DynamicRectangleShape(int x, int y, int deltaX, int deltaY,Color color) {
		super(x,y,deltaX,deltaY);
		_color = color;
	}

	/**
	 * Creates a DynamicShape instance with specified values for instance 
	 * variables.
	 * @param x x position.
	 * @param y y position.
	 * @param deltaX speed (pixels per move call) and direction for horizontal 
	 *        axis.
	 * @param deltaY speed (pixels per move call) and direction for vertical 
	 *        axis.
	 * @param width width in pixels.
	 * @param height height in pixels.
	 */
	public DynamicRectangleShape(int x, int y, int deltaX, int deltaY, int width, int height) {
		super(x,y,deltaX,deltaY,width,height);
	}

	public DynamicRectangleShape(int x, int y, int deltaX, int deltaY, int width, int height,String text) {
		super(x,y,deltaX,deltaY,width,height,text);
	}

	public DynamicRectangleShape(int x, int y, int deltaX, int deltaY, int width, int height,Color color) {
		super(x,y,deltaX,deltaY,width,height);
		_color = color;
	}

	/**
	 * Creates a DynamicShape instance with specified values for instance
	 * variables.
	 * @param x x position.
	 * @param y y position.
	 * @param deltaX speed (pixels per move call) and direction for horizontal
	 *        axis.
	 * @param deltaY speed (pixels per move call) and direction for vertical
	 *        axis.
	 * @param width width in pixels.
	 * @param height height in pixels.
	 * @param color color of the shape
	 */
	public DynamicRectangleShape(int x, int y, int deltaX, int deltaY, int width, int height,String text,Color color) {
		super(x,y,deltaX,deltaY,width,height,text);
		_color = color;
	}

	@Override

	public void move(int width, int height) {
		int nextX = _x + _deltaX;
		int nextY = _y + _deltaY;

		if (nextY <= 0) {
			nextY = 0;
			_deltaY = -_deltaY;
			_fill = false;
		} else if (nextY + _height >= height) {
			nextY = height - _height;
			_deltaY = -_deltaY;
			_fill = false;
		}

		if (nextX <= 0) {
			nextX = 0;
			_deltaX = -_deltaX;
			_fill = true;
		} else if (nextX + _width >= width) {
			nextX = width - _width;
			_deltaX = -_deltaX;
			_fill = true;
		}

		_x = nextX;
		_y = nextY;
	}
	
	protected void doPaint(Painter painter) {
		if(_fill) {
			painter.getColor();
			painter.setColor(_color);
			painter.fillRect(_x, _y, _width, _height);
			painter.setColor(_defaultColor);
		} else {
			painter.drawRect(_x, _y, _width, _height);
		}
	}

	public void paintShape(Painter painter) {
		painter.drawRect(_x, _y, _width, _height);
		
	}

}
