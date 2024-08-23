package model;

import java.awt.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import utility.ISnapshot;
import utility.Oval;
import utility.Point2D;
import utility.Rectangle;
import utility.Shape;
import utility.Snapshot;

/**
 * The type Picture model.
 */
public class PictureModel implements IPicture {
  private final List<ISnapshot> snapshots;
  private final List<utility.Shape> shapes;
  private Snapshot currentSnapshot;

  /**
   * Instantiates a new Picture model.
   */
  public PictureModel() {
    shapes = new ArrayList<>();
    snapshots = new ArrayList<>();
    currentSnapshot = null;
  }

  public void addShape(Shape shape) {
    shapes.add(shape);
  }

  public void removeShape(utility.Shape shape) {
    shapes.remove(shape);
  }

  public void color(utility.Shape shape, Color color) {
    shape.setColor(color);
  }

  public void move(utility.Shape shape, Point2D newX) {

    shape.setCorner(new Point2D(newX.getX(), newX.getY()));
  }


  /**
   * Apply scaling transformation to a shape.
   *
   * @param shape       the shape to be resized
   * @param scaleFactor the factor by which to scale the shape (must be greater than 0)
   * @throws IllegalArgumentException if the scaleFactor is not greater than 0
   */
  // Apply scaling transformation for a rectangle
  public void resize(utility.Shape shape, double scaleFactor) {
    if (shape instanceof Rectangle rectangle) {
      rectangle.setWidth(rectangle.getWidth() * scaleFactor);
      rectangle.setHeight(rectangle.getHeight() * scaleFactor);
    } else if (shape instanceof Oval oval) {
      oval.setxRadius(oval.getxRadius() * scaleFactor);
      oval.setyRadius(oval.getyRadius() * scaleFactor);
    }
  }

  /**
   * Resize.
   *
   * @param shape        the shape
   * @param xScaleFactor the x scale factor
   * @param yScaleFactor the y scale factor
   */
// Apply scaling transformation for an oval (using radii)
  public void resize(utility.Shape shape, double xScaleFactor, double yScaleFactor) {
    if (shape instanceof Oval oval) {
      oval.setxRadius(oval.getxRadius() * xScaleFactor);
      oval.setyRadius(oval.getyRadius() * yScaleFactor);
    } else {
      System.out.println("Resize operation not supported for this shape type.");
    }
  }

  /**
   * Capture a snapshot of the picture's state.
   *
   * @param id          the unique identifier for the snapshot
   * @param description a description of the snapshot
   */
  // Method to capture a snapshot of the picture's state
  public void takeSnapshot(String id, String description) {
    LocalDateTime currentTime = LocalDateTime.now();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    String timestamp = currentTime.format(formatter);

    currentSnapshot = new Snapshot(id, timestamp, description, shapes);
    snapshots.add(currentSnapshot);
  }

  // Method to get the list of shapes
  public List<utility.Shape> getShapes() {
    return shapes;
  }

  /**
   * Print the current snapshot or all shapes if no snapshot is available.
   *
   */
  // Method to print the current snapshot
  public void printSnapshot() {
    if (currentSnapshot != null) {
      System.out.println("Printing utility.Snapshot");
      System.out.println("Snapshot ID: " + currentSnapshot.getId());
      System.out.println("Timestamp: " + currentSnapshot.getTimestamp());
      System.out.println("Description: " + currentSnapshot.getDescription());
      System.out.println("Shape Information:");
      for (utility.Shape shape : currentSnapshot.getShapes()) {
        System.out.println(shape); // make sure this prints the tostring
      }
      System.out.println();
    } else {
      for (utility.Shape shape : shapes) {
        System.out.println(shape); // make sure this prints the tostring
      }
      System.out.println();
    }
  }

  public List<ISnapshot> getSnapshots() {
    return snapshots;
  }

  /**
   * Print all snapshots.
   */
  // Method to print all snapshots taken
  public void printAllSnapshots() {
    System.out.println("Printing all snapshots:");
    // System.out.println(snapshots.size());
    for (ISnapshot snapshot : snapshots) {
      System.out.println("utility.Snapshot ID: " + snapshot.getId());
      System.out.println("Timestamp: " + snapshot.getTimestamp());
      System.out.println("Description: " + snapshot.getDescription());
      System.out.println("utility.Shape Information:");
      for (utility.Shape shape : snapshot.getShapes()) {
        System.out.println(shape);
      }
      System.out.println();
    }
  }
}
