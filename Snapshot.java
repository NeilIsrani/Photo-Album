package utility;

import java.util.ArrayList;
import java.util.List;

/**
 * The type utility.Snapshot.
 */
public class Snapshot implements ISnapshot {
  private final String id;
  private final String timestamp;
  private final String description;
  private final List<Shape> shapes;


  /**
   * Instantiates a new utility.Snapshot.
   *
   * @param id          the id
   * @param timestamp   the timestamp
   * @param description the description
   * @param shapes      the shapes
   */
  public Snapshot(String id, String timestamp, String description, List<Shape> shapes) {
    this.id = id;
    this.timestamp = timestamp;
    this.description = description;
    this.shapes = new ArrayList<>();
    for (Shape shape : shapes){
      this.shapes.add(shape.copy());
    }
  }

  /**
   * Gets id.
   *
   * @return the id
   */
  public String getId() {
    return id;
  }

  /**
   * Gets timestamp.
   *
   * @return the timestamp
   */
  public String getTimestamp() {
    return timestamp;
  }

  /**
   * Gets description.
   *
   * @return the description
   */
  public String getDescription() {
    return description;
  }

  /**
   * Gets shapes.
   *
   * @return the shapes
   */
  public List<Shape> getShapes() {
    return new ArrayList<>(shapes);
  }

  /**
   * Print snapshot.
   */
// Method to print the snapshot
  public void printSnapshot() {
    System.out.println("Printing Snapshot");
    System.out.println("Snapshot ID: " + id);
    System.out.println("Timestamp: " + timestamp);
    System.out.println("Description: " + description);
    System.out.println("Shape Information:");
    for (Shape shape : shapes) {
      System.out.println(shape);
    }
    System.out.println();
  }
}
