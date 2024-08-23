package utility;

import java.awt.*;

/**
 * The type utility.Shape.
 */
public abstract class Shape {
  /**
   * The Corner.
   */
  protected Point2D corner;
  /**
   * The Name.
   */
  protected String name;
  /**
   * The Type.
   */
  protected ShapeType type;
  /**
   * The Color.
   */
  protected Color color;

  /**
   * Instantiates a new utility.Shape.
   *
   * @param name   the name
   * @param type   the type
   * @param corner the corner
   * @param color  the color
   */
// Constructor
  public Shape(String name, ShapeType type, Point2D corner, Color color) {
    this.name = name;
    this.type = type;
    this.corner = corner;
    this.color = color; // Default color
  }


  /**
   * Gets name.
   *
   * @return the name
   */
  public String getName() {
    return name;
  }

  /**
   * Sets name.
   *
   * @param name the name
   */
  public void setName(String name) {
    this.name = name;
  }

  /**
   * Gets type.
   *
   * @return the type
   */
  public ShapeType getType() {
    return type;
  }

  /**
   * Sets type.
   *
   * @param type the type
   */
  public void setType(ShapeType type) {
    this.type = type;
  }

  /**
   * Gets color.
   *
   * @return the color
   */
  public Color getColor() {
    return color;
  }

  /**
   * Sets color.
   *
   * @param color the color
   */
  public void setColor(Color color) {
    this.color = color;
  }


  /**
   * Gets corner.
   *
   * @return the corner
   */
  public Point2D getCorner() {
    return corner;
  }

  /**
   * Sets corner.
   *
   * @param corner the corner
   */
  public void setCorner(Point2D corner) {
    this.corner = corner;
  }

  @Override
  public String toString() {
    if (this instanceof Oval oval) {
      return String.format("Name: %s\nType: %s\nCenter: %s, X radius: %.1f, Y radius: %.1f, Color: %s",
              name, type, corner, oval.getxRadius(), oval.getyRadius(), color);
    } else if (this instanceof Rectangle rectangle) {
      return String.format("Name: %s\nType: %s\nMin corner: %s, Width: %.1f, Height: %.1f, Color: %s",
              name, type, corner, rectangle.getWidth(), rectangle.getHeight(), color);
    } else {
      DifferentShape differentShape = (DifferentShape) this;
      return String.format("Name: %s\nType: %s\nMin corner: %s, Width: %.1f, Height: %.1f, Color: %s",
              name, type, corner, differentShape.getWidth(), differentShape.getHeight(), color);
    }
  }

  /**
   * Copy shape.
   *
   * @return the shape
   */
  public abstract Shape copy();
}