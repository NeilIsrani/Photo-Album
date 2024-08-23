package controller;

import java.io.IOException;

/**
 * The interface Controller.
 */
public interface IController {
  /**
   * Processes commands and displays snapshots.
   *
   * @throws IOException              if an I/O error occurs
   * @throws IllegalArgumentException if the input contains invalid commands
   */
  void go() throws IOException, IllegalArgumentException;
}
