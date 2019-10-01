package spaceshapes;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Image;

/**
 * Implementation of the Painter interface that delegates drawing to a
 * java.awt.Graphics object.
 * 
 * @author Paramvir Singh (Original Author - Ian Warren)
 * 
 */
public class GraphicsPainter implements Painter {
	// Delegate object.
	private Graphics _g;

	/**
	 * Creates a GraphicsPainter object and sets its Graphics delegate.
	 */
	public GraphicsPainter(Graphics g) {
		this._g = g;
		_g.setColor(new Color(212, 212, 212));
	}

	/**
	 * @see spaceshapes.Painter.drawRect
	 */
	public void drawRect(int x, int y, int width, int height) {
		_g.drawRect(x, y, width, height);
	}

	/**
	 * @see spaceshapes.Painter.drawOval
	 */
	public void drawOval(int x, int y, int width, int height) {
		_g.drawOval(x, y, width, height);
	}

	/**
	 * @see spaeshapes.Painter.drawLine.
	 */
	public void drawLine(int x1, int y1, int x2, int y2) {
		_g.drawLine(x1, y1, x2, y2);
	}

	public void translate( int x, int y ) {
		_g.translate(x, y);
	}

	public void drawCentredText(String string, Shape shape) {

		_g.setFont(new Font("SansSerif", Font.BOLD, 30));
		FontMetrics metrics = _g.getFontMetrics();
		
		int x = shape._x + shape._width/2;
		
		x = x - metrics.stringWidth(string)/2;
		
		int y = shape._y + shape._height/2;
		
		if (metrics.getAscent() <= metrics.getDescent()) {
			y = y + (metrics.getDescent()-metrics.getAscent())/2;
		}
		else {
			y = y + (metrics.getAscent()-metrics.getDescent())/2;
		}
		
		_g.drawString(string, x, y);
	}
	
	public void drawImage(Image img, int x, int y, int width, int height) {
		
	}

	public void getColor() {
		_g.getColor();
	}

	public void setColor(Color color) {
		_g.setColor(color);
	}

	public void fillRect(int x, int y, int width, int height) {
		_g.fillRect(x, y, width, height);
	}
}
