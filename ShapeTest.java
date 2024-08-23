import org.junit.jupiter.api.Test;

import java.awt.*;

import utility.Point2D;
import utility.Rectangle;
import utility.ShapeType;
import utility.Shape;
import utility.Rectangle;

import static org.junit.jupiter.api.Assertions.*;

public class ShapeTest {

  @Test
  public void testShapeCreationAndGetters() {
    Point2D point = new Point2D(1, 2);
    Shape shape = new Rectangle("Rectangle", ShapeType.RECTANGLE, point,
            10, 5, Color.ORANGE);

    // Testing getters for information inputted above
    assertEquals("Rectangle", shape.getName());
    assertEquals(ShapeType.RECTANGLE, shape.getType());
    assertEquals(point, shape.getCorner());
    assertEquals(shape.getColor(), Color.ORANGE);
  }

  @Test
  public void testShapeSetters() {
    Point2D point = new Point2D(1, 2);
    Shape shape = new Rectangle("Rectangle", ShapeType.RECTANGLE, point, 10, 5, Color.BLACK);

    // Changing the name, shape type, and color.
    shape.setName("New Name");
    shape.setType(ShapeType.OVAL);

    // Testing getters for new information set above
    assertEquals("New Name", shape.getName());
    assertEquals(ShapeType.OVAL, shape.getType());
    assertEquals(Color.BLACK, shape.getColor());
  }

  @Test
  public void testShapeToString() {
    Point2D point = new Point2D(1, 2);
    Shape shape = new Rectangle("Rectangle", ShapeType.RECTANGLE, point, 10, 5, Color.ORANGE);

    String expected = "Name: Rectangle\nType: RECTANGLE\nMin corner: (1, 2), Width: 10.0, Height: 5.0, Color: java.awt.Color[r=255,g=200,b=0]";
    assertEquals(expected, shape.toString());
  }
}