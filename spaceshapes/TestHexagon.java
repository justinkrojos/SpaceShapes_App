package spaceshapes;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class TestHexagon {

	private MockPainter _painter;

	@Before
	public void setUp() {
		_painter = new MockPainter();
	}


	@Test
	// For small hexagons
	public void testSimpleMove() {
		GemShape shape = new GemShape(100, 20, 12, 15, 30, 30);
		shape.paint(_painter);
		shape.move(500, 500);
		shape.paint(_painter);
		assertEquals("(line 100,35,115,20)(line 115,20,130,35)(line 130,35,115,50)(line 115,50,100,35)"
				+ "(line 112,50,127,35)(line 127,35,142,50)(line 142,50,127,65)(line 127,65,112,50)", 
				_painter.toString());
	}
	@Test
	public void testShapeMoveWithBounceOffRight() {
		GemShape shape = new GemShape(100, 20, 12, 15, 30, 30);
		shape.paint(_painter);
		shape.move(135, 10000);
		shape.paint(_painter);
		shape.move(135, 10000);
		shape.paint(_painter);
		assertEquals("(line 100,35,115,20)(line 115,20,130,35)(line 130,35,115,50)(line 115,50,100,35)"
				+ "(line 105,50,120,35)(line 120,35,135,50)(line 135,50,120,65)(line 120,65,105,50)" 
				+ "(line 93,65,108,50)(line 108,50,123,65)(line 123,65,108,80)(line 108,80,93,65)"
				, _painter.toString());
	}
	
	@Test
	public void testShapeMoveWithBounceOffLeft() {
		GemShape shape = new GemShape(10, 20, -12, 15, 30, 30);
		shape.paint(_painter);
		shape.move(10000, 10000);
		shape.paint(_painter);
		shape.move(10000, 10000);
		shape.paint(_painter);
		assertEquals("(line 10,35,25,20)(line 25,20,40,35)(line 40,35,25,50)(line 25,50,10,35)"
				+ "(line 0,50,15,35)(line 15,35,30,50)(line 30,50,15,65)(line 15,65,0,50)" 
				+ "(line 12,65,27,50)(line 27,50,42,65)(line 42,65,27,80)(line 27,80,12,65)"
				,_painter.toString());
	}

	// Testing the Hexagon was made correctly.
	
	@Test
	// For small hexagons
	public void testSmallHexagonalShape() {
		GemShape shape = new GemShape(10, 90, -12, 15, 30, 30);
		shape.paint(_painter);
		assertEquals("(line 10,105,25,90)(line 25,90,40,105)(line 40,105,25,120)(line 25,120,10,105)"
				, _painter.toString());
	}
	
	@Test
	// For large hexagons
	public void testLargeHexagonalShape() {
		GemShape shape = new GemShape(10, 90, -12, 15, 50, 50);
		shape.paint(_painter);
		assertEquals("(line 10,115,30,90)(line 30,90,40,90)(line 40,90,60,115)"
				+ "(line 60,115,40,140)(line 40,140,30,140)(line 30,140,10,115)"
				, _painter.toString());
	}
}
