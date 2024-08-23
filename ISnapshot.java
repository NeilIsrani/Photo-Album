package utility;

import java.util.List;

import utility.Shape;

/**
 * The interface Snapshot.
 */
public interface ISnapshot {
  /**
   * Gets id.
   *
   * @return the id
   */
  String getId();

  /**
   * Gets timestamp.
   *
   * @return the timestamp
   */
  String getTimestamp();

  /**
   * Gets description.
   *
   * @return the description
   */
  String getDescription();

  /**
   * Gets shapes.
   *
   * @return the shapes
   */
  List<Shape> getShapes();
}
