package view;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import utility.ISnapshot;
import utility.Oval;
import utility.Rectangle;
import utility.Shape;
import utility.Snapshot;


/**
 * The type Web view.
 */
public class WebView implements IView {

  private final String fileOutput;
  /**
   * The Html.
   */
  StringBuilder html;

  /**
   * Constructs a view.WebView with the given file output.
   *
   * @param fileOutput the file to write to
   * @throws IllegalArgumentException the illegal argument exception
   */
  public WebView(String fileOutput) throws IllegalArgumentException {
    this.fileOutput = fileOutput;
    html = new StringBuilder();
  }

  @Override
  public void start(List<ISnapshot> snapshots) {

    // HTML metadata
    html.append("""
            <!DOCTYPE html>
            <html>
            <head>
            <title>cs5004 Shapes Photo Album Viewer</title>
            </head>
            <body>
            """);
    drawImages(snapshots);

    html.append("""
              </body>
              </html>
              """);

    fileWriter();

  }

  private void drawImages(List<ISnapshot> snapshots){
    for (ISnapshot snapshot : snapshots) {
      html.append("<div>\n");
      html.append(String.format("<h3>%s</h3>\n", snapshot.getDescription()));
      html.append("""
              <ul>
              <svg width='100%' height='100%' viewBox='0 0 800 800'>
              """);
      for (Shape shape : ((Snapshot)snapshot).getShapes()) {
        String shapetext = "";
        // Creating html based on shape types
        if (shape instanceof Rectangle) {
          Rectangle rectangle = (Rectangle) shape;
          shapetext = String.format(
                  "<rect x='%d' y='%d' width='%f' height='%f' fill='rgb(%d,%d,%d)' />%n",
                  rectangle.getCorner().getX(),
                  rectangle.getCorner().getY(),
                  rectangle.getWidth(),
                  rectangle.getHeight(),
                  rectangle.getColor().getRed(),
                  rectangle.getColor().getGreen(),
                  rectangle.getColor().getBlue()
          );
        } else if (shape instanceof Oval) {
          Oval oval = (Oval) shape;
          shapetext = String.format(
                  "<ellipse cx='%d' cy='%d' rx='%f' ry='%f' fill='rgb(%d,%d,%d)' />%n",
                  oval.getCorner().getX(),
                  oval.getCorner().getY(),
                  oval.getxRadius(),
                  oval.getyRadius(),
                  oval.getColor().getRed(),
                  oval.getColor().getGreen(),
                  oval.getColor().getBlue()
          );
        }
        html.append(shapetext);
      }

      html.append("""
              </svg>
              </ul>
              """);
    }
    html.append("</div>\n");
  }

  private void fileWriter() {
    try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileOutput))){
      writer.write(html.toString());
    } catch (IOException e) {
      System.out.println("Error encountered while creating file: " + e.getMessage());
    }
  }

  @Override
  public String toString() {
    return html.toString();
  }
}