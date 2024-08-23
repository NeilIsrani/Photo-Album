import org.junit.jupiter.api.Test;

import java.awt.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import utility.Point2D;
import utility.Rectangle;
import utility.ShapeType;
import utility.Shape;
import utility.Snapshot;
import utility.Oval;


public class SnapshotTest {

  @Test
  public void testSnapshotCreationAndGetters() {
    Point2D point1 = new Point2D(1, 2);
    Point2D point2 = new Point2D(3, 4);
    Shape shape1 = new Rectangle("Rectangle", ShapeType.RECTANGLE, point1, 10, 5, Color.ORANGE);
    Shape shape2 = new Oval("Oval", ShapeType.OVAL, point2, 8, 6, Color.BLACK);
    List<Shape> shapes = Arrays.asList(shape1, shape2);

    Snapshot snapshot = new Snapshot("1", "2024-04-01 09:00:00", "Description", shapes);

    // Testing getters for information inputted above
    assertEquals("1", snapshot.getId());
    assertEquals("2024-04-01 09:00:00", snapshot.getTimestamp());
    assertEquals("Description", snapshot.getDescription());
    assertEquals(shapes, snapshot.getShapes());
  }

  @Test
  public void testSnapshotPrintSnapshot() {
    Point2D point1 = new Point2D(1, 2);
    Point2D point2 = new Point2D(3, 4);
    Shape shape1 = new Rectangle("Rectangle", ShapeType.RECTANGLE, point1, 10, 5, Color.ORANGE);
    Shape shape2 = new Oval("Oval", ShapeType.OVAL, point2, 8, 6, Color.BLACK);
    List<Shape> shapes = Arrays.asList(shape1, shape2);

    Snapshot snapshot = new Snapshot("1", "2024-04-01 09:00:00", "Description", shapes);

    // Redirect stdout to capture the output
    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    PrintStream originalOut = System.out;
    System.setOut(new PrintStream(outputStream));

    // Invoke the printSnapshot method
    snapshot.printSnapshot();

    // Reset stdout
    System.setOut(originalOut);

    // Verify the output
    String expected = "Printing Snapshot\nSnapshot ID: 1\nTimestamp: 2024-04-01 09:00:00\nDescription: Description\nShape Information:\n" +
            "Name: Rectangle\nType: RECTANGLE\nMin corner: (1, 2), Width: 10.0, Height: 5.0, Color: java.awt.Color[r=255,g=200,b=0]\n" +
            "Name: Oval\nType: OVAL\nCenter: (3, 4), X radius: 8.0, Y radius: 6.0, Color: java.awt.Color[r=0,g=0,b=0]\n\n";
    assertEquals(expected, outputStream.toString());
  }
}