package spaceshapes;

import java.util.ArrayList;

public class CarrierShape extends Shape {

	public ArrayList<Shape> list = new ArrayList<Shape>();

	/**
	 * Creates a CarrierShape object with default values for state.
	 */
	public CarrierShape() {
		super();
	}

	/**
	 * Creates a CarrierShape object with with specified location values,
	 * default values for other state items.
	 */
	public CarrierShape(int x, int y){
		super(x,y);
	}

	/**
	 * Creates a CarrierShape object with with specified values for location,
	 * velocity and direction. Non-specified state items take on default
	 * values
	 */
	public CarrierShape(int x, int y, int deltaX, int deltaY) {
		super(x,y,deltaX,deltaY);
	}

	/**
	 *Creates a CarrierShape with specified values for location, velocity,
	 * direction, width and height.
	 */
	public CarrierShape(int x, int y, int deltaX, int deltaY, int width, int height) {
		super(x,y,deltaX,deltaY,width,height);
	}

	public CarrierShape(int x, int y, int deltaX, int deltaY, int width, int height, String text) {
		super(x,y,deltaX,deltaY,width,height,text);
	}
	
	/**
	 * Moves a CarrierShape object (including its children) within the bounds
	 * specified by arguments width and height.
	 */
	public void move(int width, int height){
		super.move(width, height);
		for (int i = 0; i < list.size(); i++) {
			list.get(i).move(_width, _height);
		}
	}

	/**
 ∗ Attempts to add a Shape to a CarrierShape object. If successful, a
 ∗ two−way link is established between the CarrierShape and the newly
 ∗ added Shape. Note that this method has package visibility − for reasons
 ∗ that will become apparent in Space−Shape III.
 ∗ @param shape the shape to be added.
 ∗ @throws IllegalArgumentException if an attempt is made to add a Shape
 ∗ to a CarrierShape instance where the Shape argument is already a child
 ∗ within a CarrierShape instance. An IllegalArgumentException is also
 ∗ thrown when an attempt is made to add a Shape that will not fit within
 ∗ the bounds of the proposed CarrierShape object.
	 */
	public void add(Shape shape) throws IllegalArgumentException{

		if (shape.parent != null) {
			throw new IllegalArgumentException("ERROR: the shape of class " + shape.toString() + " already has a parent,"
					+ shape.parent);
		}
		else if ((shape._width > _width) || (shape._height > _height)) {
			throw new IllegalArgumentException("ERROR: the shape of class " + shape.toString() + " is too large");
		}
		else {
			list.add(shape);
			shape.parent = this;
			this.children.add(shape);
		}
	}

	/**
 ∗ Removes a particular Shape from a CarrierShape instance. Once removed,
 ∗ the two−way link between the CarrierShape and its former child is
 ∗ destroyed. This method has no effect if the Shape specified to remove
 ∗ is not a child of the CarrierShape. Note that this method has package
 ∗ visibility − for reasons that will become apparent in Space−Shape III.
 ∗ @param shape the shape to be removed.
	 */

	public void remove ( Shape shape ){

		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).equals(shape)) {
				list.remove(i);
				shape.parent = null;
			}
		}
		if (this.children.contains(shape)) {
			this.children.remove(shape);
		}

	}

	/**
	 * Returns the Shape at a specified position within a CarrierShape. If
	 * the position specified is less than zero or greater than the number of
	 * children stored in the CarrierShape less one this method throws an
	 * IndexOutOfBoundsException .
	 * @param index the specified index position
	 */
	public Shape shapeAt(int index) throws IndexOutOfBoundsException{

		if ((index < 0) || (index > list.size() - 1)) {
			throw new IndexOutOfBoundsException("ERROR: there is no child at index, " + index);
		}
		else {
			return list.get(index);
		}
	}

	/**
 ∗ Returns the number of children contained within a CarrierShape object.
 ∗ Note this method is not recursive − it simply returns the number of
 ∗ children at the top level within the callee CarrierShape object.
	 */
	public int shapeCount(){
		return list.size();

	}

	/**
 ∗ Returns the index of a specified child within a CarrierShape object.
 ∗ If the Shape specified is not actually a child of the CarrierShape
 ∗ this method returns −1; otherwise the value returned is in the range
 ∗ 0 .. shapeCount()− 1.
 ∗ @param the shape whose index position within the CarrierShape is
 ∗ requested .
	 */
	public int indexOf (Shape shape){

		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).equals(shape)) {
				return i;
			}
		}

		return -1;

	}

	/**
 ∗ Returns true if the Shape argument is a child of the CarrierShape
 ∗ object on which this method is called, false otherwise.
	 */
	public boolean contains (Shape shape){

		for (int i = 0; i < list.size(); i++) { 
			if (list.get(i).equals(shape)) {
				return true;
			}
		}
		return false;
	}


	// Method will paint the shape of the CarrierShape - a rectangle 

	public void paintShape(Painter painter) {
		painter.drawRect(_x,_y,_width,_height);
	}
	
	public void doPaint(Painter painter) {
		
	}


}