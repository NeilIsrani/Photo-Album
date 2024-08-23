import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.IOException;

import controller.WebController;

class WebControllerTest {

  @Test
  void testGo() {
    // Prepare test data
    File inputFile = new File("demo_input.txt"); // Assuming there's a test input file
    String outputFile = "test_output.html"; // Output file for the web view
    WebController controller = new WebController(inputFile, outputFile);

    // Execute the method under test
    assertDoesNotThrow(() -> controller.go(), "An exception was thrown while executing go()");

  }
}