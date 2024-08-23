import java.io.File;
import java.io.IOException;

import controller.GraphicalController;
import controller.WebController;

/**
 * The type Photo album main.
 */
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class PhotoAlbumMain {

  /**
   * The entry point of application.
   *
   * @param args the input arguments
   */

  public static void main(String[] args) {
    if (args.length < 4 || args.length > 7) {
        System.out.println("Invalid number of arguments.");
        System.out.println("Expected: -in \"name-of-command-file\" -view \"type-of-view\" [-out \"where-output-should-go\"] [xmax] [ymax]");
        return;
      }
    System.out.println("test 1");
      // Set default parameters
      String commandFile = null;
      String viewType = null;
      String outputFile = null;
      int xmax = 800;
      int ymax = 800;

    // Check for labels
    for (int i = 0; i < args.length; i += 2) {
        switch (args[i]) {
          case "-in":
            commandFile = args[i + 1];
            break;
          case "-v":
            viewType = args[i + 1];
            break;
          case "-out":
            outputFile = args[i + 1];
            break;
          default:
            continue;
        }
      }
    // Error messages for missing vital info
    if (commandFile == null || viewType == null) {
        System.out.println("Missing required arguments.");
        System.out.println("Usage: -in \"name-of-command-file\" -v \"type-of-view\" [-out \"where-output-should-go\"] [xmax] [ymax]");
        return;
      }
    // Default for output file name
    if (outputFile == null && viewType.equalsIgnoreCase("web")) {
      outputFile = "unnamedfile.html";
    }

    if (args.length >= 6 && viewType.equalsIgnoreCase("graphical")) {
        try {
          xmax = Integer.parseInt(args[args.length - 2]);
          ymax = Integer.parseInt(args[args.length - 1]);
        } catch (NumberFormatException e) {
          System.out.println("Invalid value for xmax or ymax.");
          return;
        }
    }

      System.out.println("Command File: " + commandFile);
      System.out.println("View Type: " + viewType);
      System.out.println("Output File: " + outputFile);
      System.out.println("Xmax: " + xmax);
      System.out.println("Ymax: " + ymax);

      if (!commandFile.isEmpty() && viewType.equalsIgnoreCase("graphical")){
        GraphicalController controller = new GraphicalController(new File(commandFile), xmax, ymax);
        try {
          controller.go();
        } catch (IOException e) {
          throw new RuntimeException(e);
        }
      } else if (!commandFile.isEmpty() && viewType.equalsIgnoreCase("web")){
        WebController controller = new WebController(new File(commandFile), outputFile);
        try {
          controller.go();
        } catch (IOException e) {
          throw new RuntimeException(e);
        }
      }


/*
    // Uncomment this section to run provided command texts manually (without command line)

    controller.GraphicalController controller = new controller.GraphicalController(new File("buildings.txt"), 800, 800);
    controller.GraphicalController controller2 = new controller.GraphicalController(new File("teris_wallpaper.txt"), 800, 800);
    controller.GraphicalController controller3 = new controller.GraphicalController(new File("hoops.txt"), 800, 800);
    controller.WebController controller4 = new controller.WebController(new File("buildings.txt"), "buildingsOut.html");
    controller.WebController controller5 = new controller.WebController(new File("teris_wallpaper.txt"), "teris_out.html");
    controller.WebController controller6 = new controller.WebController(new File("hoops.txt"), "hoops_out.html");
    try {
      controller.go();
      controller2.go();
      controller3.go();
      controller4.go();
      controller5.go();
      controller6.go();
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
*/
  }
  }
