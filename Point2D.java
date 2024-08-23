package utility;

/**
 * The type Point 2 d.
 */
public class Point2D {

  /**
   * The X.
   */
  private int x, y;


  /**
   * Instantiates a new Point 2 d.
   *
   * @param x the x
   * @param y the y
   */
  public Point2D(int x, int y) {
    this.x = x;
    this.y = y;
  }

  /**
   * Copy point 2 d.
   *
   * @return the point 2 d
   */
  public Point2D copy(){
    return new Point2D(this.x, this.y);
}

  /**
   * Instantiates a new Point 2 d.
   */
  public Point2D() {
    this.x = this.y = 0;
  }

  /**
   * Instantiates a new Point 2 d.
   *
   * @param orignal the orignal
   */
  public Point2D(Point2D orignal) {
    this.x = orignal.x;
    this.y = orignal.y;
  }

  /**
   * Get x int.
   *
   * @return the int
   */
  public int getX() {
    return x;
  }

  /**
   * Get y int.
   *
   * @return the int
   */
  public int getY() {
    return y;
  }

  /**
   * Sets x.
   *
   * @param x the x
   */
  public void setX(int x) {
    this.x = x;
  }

  /**
   * Sets y.
   *
   * @param y the y
   */
  public void setY(int y) {
    this.y = y;
  }

  @Override
  public String toString() {
    return "(" + x + ", " + y + ")";
  }
}
