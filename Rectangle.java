package utility;

import java.awt.*;

/**
 * The type utility.Rectangle.
 */
// Concrete utility.Rectangle class representing a rectangle
public class Rectangle extends Shape {
  private double width;
  private double height;

  private Color color;

  /**
   * Instantiates a new utility.Rectangle.
   *
   * @param name   the name
   * @param type   the type
   * @param corner the corner
   * @param width  the width
   * @param height the height
   * @param color  the color
   */
  public Rectangle(String name, ShapeType type, Point2D corner, double width, double height, Color color) {
    super(name, type, corner, color);
    //this.color = color;
    this.width = width;
    this.height = height;
  }

  public Rectangle copy() {
    return new Rectangle(this.getName(),this.getType(), this.getCorner().copy(),this.getWidth(),
            this.getHeight(),this.getColor());
  }

  /**
   * Gets width.
   *
   * @return the width
   */
  public double getWidth() {
    return width;
  }

  /**
   * Sets width.
   *
   * @param width the width
   */
  public void setWidth(double width) {
    this.width = width;
  }

  /**
   * Gets height.
   *
   * @return the height
   */
  public double getHeight() {
    return height;
  }

  /**
   * Sets height.
   *
   * @param height the height
   */
  public void setHeight(double height) {
    this.height = height;
  }

  public void setColor(Color color) {
    this.color = color;
  }
  @Override
  public Point2D getCorner() {
    return super.getCorner();
  }
  @Override
  public String toString() {
    return super.toString(); // will automatically print as utility.Rectangle
  }
}