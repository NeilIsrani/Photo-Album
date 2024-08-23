import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.IOException;

import controller.GraphicalController;

class GraphicalControllerTest {

  @Test
  void testGo() {
    // Prepare test data
    File inputFile = new File("demo_input.txt");
    int defaultXframe = 1000;
    int defaultYframe = 600; // Updated Y frame for testing
    GraphicalController controller = new GraphicalController(inputFile, defaultXframe,
            defaultYframe);

    // Execute the method under test
    assertDoesNotThrow(() -> controller.go(),
            "An exception was thrown while executing go()");

  }
}