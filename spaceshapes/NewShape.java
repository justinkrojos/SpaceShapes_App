package spaceshapes;

public class NewShape extends Shape {

	// NewShape should display a fish that flips orientation upon hitting the left and right walls
	public NewShape() {
		super();
	}

	public NewShape(int x, int y, int deltaX, int deltaY) {
		super(x,y,deltaX,deltaY);
	}

	public NewShape(int x, int y, int deltaX, int deltaY, int width, int height) {
		super(x,y,deltaX,deltaY,width,height);
	}

	public NewShape(int x, int y, int deltaX, int deltaY, int width, int height, String text) {
		super(x,y,deltaX,deltaY,width,height,text);
	}
	
	public void paintShape(Painter painter) {
	
		
		if (_deltaX < 0) {
			
		painter.drawOval(_x, _y, _width/2, _height);
		painter.drawLine(_x + _width/4, _y, _x + 2*_width/3, _y);
		painter.drawLine(_x + 2*_width/3, _y, _x + _width, _y + _height);
		painter.drawLine(_x + _width, _y + _height, _x + _width, _y);
		painter.drawLine(_x + _width, _y, _x + 2*_width/3, _y + _height);
		painter.drawLine(_x + 2*_width/3, _y + _height, _x + _width/4, _y + _height);
	
		}
		else {
			painter.drawOval(_x + _width/2, _y, _width/2, _height);
			painter.drawLine(_x + 3*_width/4, _y, _x + _width/3, _y);
			painter.drawLine(_x + _width/3, _y, _x, _y + _height);
			painter.drawLine(_x, _y + _height, _x, _y);
			painter.drawLine(_x, _y, _x + _width/3, _y + _height);
			painter.drawLine(_x + _width/3, _y + _height, _x + 3*_width/4, _y + _height);
		}
	}
	
	public void doPaint(Painter painter) {
		
	}
	
}
