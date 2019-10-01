package spaceshapes;

import java.util.List;
import java.awt.Font;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Abstract superclass to represent the general concept of a Shape. This class
 * defines state common to all special kinds of Shape instances and implements
 * a common movement algorithm. Shape subclasses must override method paint()
 * to handle shape-specific painting.
 * 
 * @author Paramvir Singh (Original Author - Ian Warren)
 * 
 */
public abstract class Shape {
	// === Constants for default values. ===
	protected static final int DEFAULT_X_POS = 0;

	protected static final int DEFAULT_Y_POS = 0;

	protected static final int DEFAULT_DELTA_X = 5;

	protected static final int DEFAULT_DELTA_Y = 5;

	protected static final int DEFAULT_HEIGHT = 35;

	protected static final int DEFAULT_WIDTH = 25;
	// ===

	// === Instance variables, accessible by subclasses.
	protected int _x;

	protected int _y;

	protected int _deltaX;

	protected int _deltaY;

	protected int _width;

	protected int _height;
	
	protected String _text = "";
	// ===


	// parent stores the parent of the shape
	// children stores a list of the shape's children, otherwise being empty
	// shapeList is an array that is used in the path method
	// text stores the string associated with the shape

	CarrierShape parent = null;
	List<Shape> children = new ArrayList<Shape>();
	List<Shape> shapeList = new ArrayList<Shape>();
	String text = "";

	/**
	 * Creates a Shape object with default values for instance variables.
	 */
	public Shape() {
		this(DEFAULT_X_POS, DEFAULT_Y_POS, DEFAULT_DELTA_X, DEFAULT_DELTA_Y, DEFAULT_WIDTH, DEFAULT_HEIGHT);
	}

	/**
	 * Creates a Shape object with a specified x and y position.
	 */
	public Shape(int x, int y) {
		this(x, y, DEFAULT_DELTA_X, DEFAULT_DELTA_Y, DEFAULT_WIDTH, DEFAULT_HEIGHT);
	}

	/**
	 * Creates a Shape instance with specified x, y, deltaX and deltaY values.
	 * The Shape object is created with a default width and height.
	 */
	public Shape(int x, int y, int deltaX, int deltaY) {
		this(x, y, deltaX, deltaY, DEFAULT_WIDTH, DEFAULT_HEIGHT);
	}

	/**
	 * Creates a Shape instance with specified x, y, deltaX, deltaY, width and
	 * height values.
	 */
	public Shape(int x, int y, int deltaX, int deltaY, int width, int height) {
		_x = x;
		_y = y;
		_deltaX = deltaX;
		_deltaY = deltaY;
		_width = width;
		_height = height;
	}
	
	public Shape(int x, int y, int deltaX, int deltaY, int width, int height, String text) {
		_x = x;
		_y = y;
		_deltaX = deltaX;
		_deltaY = deltaY;
		_width = width;
		_height = height;
		_text = text;
	}

	/**
	 * Moves this Shape object within the specified bounds. On hitting a 
	 * boundary the Shape instance bounces off and back into the two- 
	 * dimensional world. 
	 * @param width - width of two-dimensional world.
	 * @param height - height of two-dimensional world.
	 */
	public void move(int width, int height) {
		int nextX = _x + _deltaX;
		int nextY = _y + _deltaY;

		if (nextX <= 0) {
			nextX = 0;
			_deltaX = -_deltaX;
		} else if (nextX + _width >= width) {
			nextX = width - _width;
			_deltaX = -_deltaX;
		}

		if (nextY <= 0) {
			nextY = 0;
			_deltaY = -_deltaY;
		} else if (nextY + _height >= height) {
			nextY = height - _height;
			_deltaY = -_deltaY;
		}

		_x = nextX;
		_y = nextY;
	}


	/**
	 * Method to be implemented by concrete subclasses to handle subclass
	 * specific painting.
	 * @param painter the Painter object used for drawing.
	 */

	// Paints both the shape and text for a shape. Does the same for its children also
	// The default text is the type of shape it is, but this can be reset by the client/developer

	final public void paint(Painter painter) {
		
	
		
		if (this instanceof DynamicRectangleShape) {
			this.doPaint(painter);
		}
		else {
			this.paintShape(painter);
		}
		
		painter.drawCentredText(_text, this);
		
		if (children.size() > 0) {
			painter.translate(this._x, this._y);
			for (int i = 0; i < children.size(); i++) {
				children.get(i).paint(painter);
			}
			painter.translate(-this._x, -this._y);
		}
	}

	// Abstract paintShape method that paints the shape only, which is relative to that class

	public abstract void paintShape(Painter painter);

	// setText method will allow clients/developers to choose what text to associate with the shape (if any)

	public void setText(String string) {
		text = string;
	}

	/**
	 * Returns this Shape object's x position.
	 */
	public int x() {
		return _x;
	}

	/**
	 * Returns this Shape object's y position.
	 */
	public int y() {
		return _y;
	}

	/**
	 * Returns this Shape object's speed and direction.
	 */
	public int deltaX() {
		return _deltaX;
	}

	/**
	 * Returns this Shape object's speed and direction.
	 */
	public int deltaY() {
		return _deltaY;
	}

	/**
	 * Returns this Shape's width.
	 */
	public int width() {
		return _width;
	}

	/**
	 * Returns this Shape's height.
	 */
	public int height() {
		return _height;
	}
	
	public String text() {
		return _text;
	}

	/**
	 * Returns a String whose value is the fully qualified name of this class 
	 * of object. E.g., when called on a RectangleShape instance, this method 
	 * will return "spaceshapes.RectangleShape".
	 */
	public String toString() {
		return getClass().getName();
	}

	// shapeType determines what string should be presented for each shape based on its class
	// The text will be blank, if the class is different to existing classes

	public void shapeType() {
		if ((this.toString().equals("spaceshapes.CarrierShape")) || (this.toString().equals("spaceshapes.RectangleShape"))) {
			text = "Rectangle";
		}
		else if (this.toString().equals("spaceshapes.OvalShape")) {
			text = "Oval";
		}
		else if (this.toString().equals("spaceshapes.HexagonShape")) {
			text = "Hexagon";
		}
		else if (this.toString().equals("spaceshapes.NewShape")) {
			text = "Fishy";
		}
		else {
			text = "";
		}
	}


	// parent method returns the single parent for that shape, otherwise returning null

	public CarrierShape parent() {
		return parent;
	}

	// path is a recursive method that appends a shape's parents to a list, and their parent's parents etc.
	// If no parent is found, then the iteration ends at that shape, the top level shape.

	public List<Shape> path() {
List<Shape> list = new ArrayList<Shape>();
		
		if (parent == null) {
			list.add(this);
			return list;
		} else {
			Shape x = this;
			while (x != null) {
				list.add(x);
				x = x.parent;
			}
		
		}
		Collections.reverse(list);
		
		return list;
	}
	
	protected abstract void doPaint(Painter painter);
}

	


