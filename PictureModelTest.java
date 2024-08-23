import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.awt.*;
import java.util.List;

import model.PictureModel;
import utility.DifferentShape;
import utility.ISnapshot;
import utility.Oval;
import utility.Point2D;
import utility.ShapeType;
import utility.Snapshot;

public class PictureModelTest {

  @Test
  public void testPictureModelBehavior() {
    PictureModel picture = new PictureModel();

    // Add some shapes to the picture
    picture.addShape(new Oval("Picture1", ShapeType.OVAL, new Point2D(1, 1), 5.0, 5.0, Color.BLACK));

    // Take a snapshot
    picture.takeSnapshot("1", "Initial state");

    // Apply transformation to a shape in the picture (e.g., change color)
    picture.color(picture.getShapes().getFirst(), Color.BLUE);

    // Apply transformation to a shape in the picture (e.g., move)
    picture.move(picture.getShapes().getFirst(), new Point2D(5, 5));

    // Remove a shape from the picture
    picture.removeShape(picture.getShapes().getFirst());

    // Add a new shape to the picture
    picture.addShape(new DifferentShape("Picture3", ShapeType.TRIANGLE,
            new Point2D(10, 10), 8, 8, Color.BLUE));

    // Take a snapshot
    picture.takeSnapshot("2", "Final state");

    // Assertions to verify the behavior of PictureModel after executing commands
    List<ISnapshot> snapshots = picture.getSnapshots();

    // Assert the number of snapshots taken
    assertEquals(2, snapshots.size(), "Incorrect number of snapshots");

    // Assert the properties of the first snapshot
    ISnapshot initialSnapshot = snapshots.getFirst();
    assertEquals("Initial state", initialSnapshot.getDescription(),
            "Incorrect description for initial snapshot");
    assertEquals(1, initialSnapshot.getShapes().size(),
            "Incorrect number of shapes in initial snapshot");

    // Assert the properties of the second snapshot
    ISnapshot finalSnapshot = snapshots.get(1);
    assertEquals("Final state", finalSnapshot.getDescription(),
            "Incorrect description for final snapshot");
    assertEquals(1, finalSnapshot.getShapes().size(),
            "Incorrect number of shapes in final snapshot");
  }
}