package model;

import java.awt.*;
import java.util.List;

import utility.ISnapshot;
import utility.Point2D;
import utility.Shape;

/**
 * The interface Picture.
 */
public interface IPicture {
  /**
   * Add shape.
   *
   * @param shape the shape
   */
  // Method to add a shape to the picture
  void addShape(Shape shape);

  /**
   * Remove shape.
   *
   * @param shape the shape
   */
  // Method to remove a shape from the picture
  void removeShape(utility.Shape shape);

  /**
   * Color.
   *
   * @param shape the shape
   * @param color the color
   */
  // Method to apply color transformation to a shape
  void color(utility.Shape shape, Color color);

  /**
   * Move.
   *
   * @param shape the shape
   * @param newX  the new x
   */
  // Method to apply move transformation to a shape
  void move(utility.Shape shape, Point2D newX);

  /**
   * Gets shapes.
   *
   * @return the shapes
   */
  List<utility.Shape> getShapes();

  /**
   * Resize.
   *
   * @param shape       the shape
   * @param scaleFactor the scale factor
   */
  // Method to apply scaling transformation to a shape
  void resize(utility.Shape shape, double scaleFactor);

  /**
   * Take snapshot.
   *
   * @param id          the id
   * @param description the description
   */
  // Method to capture a snapshot of the picture's state
  void takeSnapshot(String id, String description);

  /**
   * Gets snapshots.
   *
   * @return the snapshots
   */
  List<ISnapshot> getSnapshots();

  /**
   * Print snapshot.
   */
  // Method to print the current snapshot
  void printSnapshot();
}