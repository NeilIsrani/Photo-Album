import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.awt.Color;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import utility.ISnapshot;
import utility.Oval;
import utility.Point2D;
import utility.Rectangle;
import utility.Shape;
import utility.ShapeType;
import utility.Snapshot;
import view.WebView;

public class WebViewTest {

  @Test
  public void testWebView() throws IOException {
    // Create Shape objects for snapshots
    Shape[] shapes1 = {
            new Rectangle("Rectangle", ShapeType.RECTANGLE, new Point2D(2,3), 10, 5, Color.BLACK),
    };
    Shape[] shapes2 = {
            new Oval("Oval", ShapeType.OVAL, new Point2D(4,5), 5, 7, Color.BLUE),
    };

    // Create Snapshot objects with shapes
    Snapshot snapshot1 = new Snapshot("1", "2024-04-14", "Snapshot 1", List.of(shapes1));
    Snapshot snapshot2 = new Snapshot("2", "2024-04-15", "Snapshot 2", List.of(shapes2));

    // Create WebView instance
    WebView webView = new WebView("output.html");

    // Call start method with snapshots
    webView.start(List.of(snapshot1, snapshot2));

    // Read the content of the generated HTML file
    String expectedHTML = """
                <!DOCTYPE html>
                <html>
                <head>
                <title>cs5004 Shapes Photo Album Viewer</title>
                </head>
                <body>
                <div>
                <h3>Snapshot 1</h3>
                <ul>
                <svg width='100%' height='100%' viewBox='0 0 800 800'>
                <rect x='2' y='3' width='10.000000' height='5.000000' fill='rgb(0,0,0)' />
                </svg>
                </ul>
                <div>
                <h3>Snapshot 2</h3>
                <ul>
                <svg width='100%' height='100%' viewBox='0 0 800 800'>
                <ellipse cx='4' cy='5' rx='5.000000' ry='7.000000' fill='rgb(0,0,255)' />
                </svg>
                </ul>
                </div>
                </body>
                </html>
                """;

    // Read the content of the generated HTML file
    String actualHTML = new String(java.nio.file.Files.readAllBytes(java.nio.file.Paths.get("output.html")));

    // Assert the content of the HTML file
    assertEquals(expectedHTML.strip(), actualHTML.strip());
  }
}