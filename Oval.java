package utility;

import java.awt.*;

/**
 * The type utility.Oval.
 */
// Concrete utility.Oval class representing an oval
public class Oval extends Shape {
  private double xRadius;
  private double yRadius;
private Color color;

  /**
   * Instantiates a new utility.Oval.
   *
   * @param name    the name
   * @param type    the type
   * @param corner  the corner
   * @param radiusX the radius x
   * @param radiusY the radius y
   * @param color   the color
   */
  public Oval(String name, ShapeType type, Point2D corner, double radiusX, double radiusY, Color color) {
    super(name, type, corner, color);
    //this.color = color;
    this.xRadius = radiusX;
    this.yRadius = radiusY;
  }
  public Oval copy() {
    return new Oval(this.getName(),this.getType(), this.getCorner().copy(),this.getxRadius(),
            this.getyRadius(),this.getColor());
  }

  /**
   * Gets radius.
   *
   * @return the radius
   */
  public double getxRadius() {
    return xRadius;
  }

  /**
   * Sets radius.
   *
   * @param xRadius the x radius
   */
  public void setxRadius(double xRadius) {
    this.xRadius = xRadius;
  }

  /**
   * Gets radius.
   *
   * @return the radius
   */
  public double getyRadius() {
    return yRadius;
  }

  /**
   * Sets radius.
   *
   * @param yRadius the y radius
   */
  public void setyRadius(double yRadius) {
    this.yRadius = yRadius;
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
    return super.toString(); // will automatically print as utility.Oval
  }
}

