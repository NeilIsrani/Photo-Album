package view;
import utility.ISnapshot;
import java.util.List;

/**
 * The interface View.
 */
public interface IView {

  /**
   * Display the view with the given snapshots.
   *
   * @param snapshots the list of snapshots to display
   */
  void start(List<ISnapshot> snapshots);

}