import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.io.File;

import model.PictureModel;
import utility.CommandReader;

class CommandReaderTest {

  @Test
  public void testProcessCommandsFromFile() {
    // Create a PictureModel instance
    PictureModel pictureModel = new PictureModel();
    // Create a CommandReader instance with the PictureModel
    CommandReader commandReader = new CommandReader(pictureModel);
    // Provide the path to your input file
    File inputFile = new File("demo_input.txt");

    // Process commands from the input file
    commandReader.processCommandsFromFile(inputFile);

    // Example assertions for testing the creation of two shapes but deletion of one
    assertEquals(1, pictureModel.getShapes().size(),
            "Expected number of shapes not found in PictureModel");
  }
}