package utility;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.awt.Color;

import utility.DifferentShape;
import model.PictureModel;
import utility.ShapeType;
//import static jdk.internal.foreign.SystemLookup.WindowsFallbackSymbols.printf;

/**
 * The type Command reader.
 */
public class CommandReader {
  private PictureModel pictureModel;

  private int snapcount = 0;

  /**
   * Instantiates a new Command reader.
   *
   * @param pictureModel the picture model
   */
  public CommandReader(PictureModel pictureModel) {

    this.pictureModel = pictureModel;
  }

  /**
   * Process commands from file.
   *
   * @param filePath the file path
   */
  public void processCommandsFromFile(java.io.File filePath) {
    try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
      String line;
      while ((line = reader.readLine()) != null) {
        processLine(line);
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
    pictureModel.printAllSnapshots();
  }

  private Color convertToColor(int color1, int color2, int color3) {
    // Create a Color object using the RGB values
    return new Color(color1, color2, color3);
  }
  private void processLine(String line) {
    if (line.startsWith("#")) {
      // Skip comments
      return;
    }

    Scanner scanner = new Scanner(line);

    while (scanner.hasNext()) {
      //int i++;
      String commandType = scanner.next();

      switch (commandType) {
        case "shape":
          String name = scanner.next();
          String shape = scanner.next();
          int x = scanner.nextInt();
          int y = scanner.nextInt();
          double width = scanner.nextDouble();
          double height = scanner.nextDouble();
          int color1 = scanner.nextInt();
          //System.out.println(color1);
          int color2 = scanner.nextInt();
          //System.out.println(color2);
          int color3 = scanner.nextInt();
          //System.out.println(color3);

          if (shape.equalsIgnoreCase("rectangle")) {
            pictureModel.addShape(new Rectangle(name, ShapeType.RECTANGLE, new Point2D(x, y), width, height, convertToColor(color1, color2, color3)));
          } else if (shape.equalsIgnoreCase("oval")) {
            pictureModel.addShape(new Oval(name, ShapeType.OVAL, new Point2D(x, y), width, height, convertToColor(color1, color2, color3)));
          } // add additional else
          break;
        case "snapshot":
          this.snapcount++;
          //String snapshotName = scanner.nextLine().trim();
         //System.out.println(commandType);
          LocalDateTime currentTime = LocalDateTime.now();
          DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
          String id1 = currentTime.format(formatter);

          pictureModel.takeSnapshot("Snapshot" + snapcount , "Snapshot");
          break;
        case "move": //odd occurrences
          String shapeType = scanner.next(); // Read the shape type
          // Find the shape with the matching type and move it
          for (Shape thisshape : pictureModel.getShapes()) {
            if (thisshape.getName().equals(shapeType)) {
              // Read new position coordinates
              if (scanner.hasNextInt()) {
                int newX = scanner.nextInt();
                if (scanner.hasNextInt()) {
                  int newY = scanner.nextInt();
                  // Move the shape
                  pictureModel.move(thisshape, new Point2D(newX, newY));
                }
                break; // Exit the loop after moving the first matching shape
              }
            }
          }
          break;

        case "resize": // needs testing
          String resizeShapeType = scanner.next();
          double newwidth = scanner.nextDouble();
          double newheight = scanner.nextDouble();
            for (Shape resizeshape : pictureModel.getShapes()) {
              if (resizeshape.getName().equals(resizeShapeType)) {
                if (resizeshape instanceof Rectangle) {
                  Rectangle rectangle = (Rectangle) resizeshape;
                  rectangle.setWidth(newwidth);
                  rectangle.setHeight(newwidth);
                  break;
                  //pictureModel.resize(resizeshape, newwidth, newheight);
                } else if (resizeshape instanceof Oval) {
                  Oval oval = (Oval) resizeshape;
                  oval.setxRadius(newwidth);
                  oval.setyRadius(newheight);
                  break;
                  //pictureModel.resize(resizeshape, newwidth, newheight);
                } else if (resizeshape instanceof DifferentShape){
                  DifferentShape differentShape = (DifferentShape) resizeshape;
                  differentShape.setWidth(newwidth);
                  differentShape.setHeight(newwidth);
                  break;
                }
                break;
              }
            }
          break;
        case "remove":
          String removeShapeType = scanner.next();
          for (Shape removeshape : pictureModel.getShapes()) {
            if (removeshape.getName().equals(removeShapeType)) {
              pictureModel.removeShape(removeshape);
              break;
            }
          }
          break;
        default:
          // Ignore unsupported commands
          break;
      }
    }
    scanner.close();
  }
}
