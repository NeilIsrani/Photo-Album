package controller;

import java.io.File;
import java.io.IOException;
import model.IPicture;
import model.PictureModel;
import utility.CommandReader;
import view.GraphicalView;
import view.IView;

/**
 * The controller for the PhotoAlbum.
 */
public class GraphicalController {

  private final IPicture model;
  private final IView view;

  private final File inputFile;
  private int defaultXframe = 800;
  private int defaultYframe = 800;

  /**
   * Constructor for the controller.
   *
   * @param inputFile the input file
   * @param xframe    the xframe
   * @param yframe    the yframe
   */
  public GraphicalController(File inputFile, int xframe, int yframe) {
    this.inputFile = inputFile;
    this.defaultXframe = xframe;
    this.defaultYframe = yframe;
    model = new PictureModel(); // Instantiate using model.IPicture interface
    view = new GraphicalView(defaultXframe, defaultYframe);
  }

  /**
   * Go.
   *
   * @throws IOException              the io exception
   * @throws IllegalArgumentException the illegal argument exception
   */
  public void go() throws IOException, IllegalArgumentException {
    CommandReader fp = new CommandReader((PictureModel) model);
    fp.processCommandsFromFile(inputFile);
    view.start(model.getSnapshots());
  }

}


