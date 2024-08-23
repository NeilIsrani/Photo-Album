package controller;

import java.io.File;
import java.io.IOException;
import model.IPicture;
import model.PictureModel;
import utility.CommandReader;
import view.IView;
import view.WebView;

/**
 * The type Web controller.
 */
public class WebController {

  private final IPicture model;
  private final IView webView;
  private final File inputFile;
  private final String outputFile;

  /**
   * Constructor for the web controller.
   *
   * @param inputFile  the input file
   * @param outputFile the output file for the web view
   */
  public WebController(File inputFile, String outputFile) {
    this.inputFile = inputFile;
    this.outputFile = outputFile;
    model = new PictureModel();
    webView = new WebView(outputFile);
  }

  /**
   * Method to process commands and display snapshots in the web view.
   *
   * @throws IOException              if an I/O error occurs
   * @throws IllegalArgumentException if the input file is invalid
   */
  public void go() throws IOException, IllegalArgumentException {
    CommandReader commandReader = new CommandReader((PictureModel) model);
    commandReader.processCommandsFromFile(inputFile);
    model.getSnapshots();
    webView.start(model.getSnapshots());
  }
}
