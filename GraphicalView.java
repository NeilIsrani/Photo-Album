package view;

import java.awt.*;
import java.util.List;
import javax.swing.*;
import utility.ISnapshot;
import utility.ISnapshot;
import utility.Oval;
import utility.Point2D;
import utility.Rectangle;
import utility.Shape;
import utility.Snapshot;

/**
 * The type Graphical view.
 */
public class GraphicalView implements IView {

  private JLabel description;
  private final JFrame frame;
  private int currentSnapshotIndex;
  private int defaultXframe = 800;
  private int defaultYframe = 800;

  /**
   * Instantiates a new Graphical view.
   *
   * @param Xframe the xframe
   * @param Yframe the yframe
   */
  public GraphicalView(int Xframe, int Yframe) {
    if (Xframe > 0) {
      defaultXframe = Xframe;
    }
    if (Yframe > 0) {
      defaultYframe = Yframe;
    }
    currentSnapshotIndex = 0;
    frame = new JFrame();
    frame.setTitle("cs5004 Shapes Photo Album Viewer");
    frame.setPreferredSize(new Dimension(defaultXframe, defaultYframe));
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }

  @Override
  public void start(List<ISnapshot> snapshots) {
    createBackground();
    createButtons(snapshots);
    drawImages(snapshots);

    frame.pack();
    frame.setVisible(true);
  }

  private void createBackground() {
    JPanel labelPanel = new JPanel();
    description = new JLabel();
    description.setFont(new Font("Calibre", Font.ITALIC, 16));

    labelPanel.add(description);
    labelPanel.setBackground(new Color(130, 130, 130));
    frame.getContentPane().add(labelPanel, BorderLayout.NORTH);
  }

  private void createButtons(List<ISnapshot> snapshots) {
    JPanel panel = new JPanel();

    // Was not sure what the select button was for so made a drop-down menu instead
    JComboBox<String> snapshotCombo = new JComboBox<>();
    for (ISnapshot snapshot : snapshots) {
      snapshotCombo.addItem(snapshot.getId());
    }

    snapshotCombo.addActionListener(e -> {
      currentSnapshotIndex = snapshotCombo.getSelectedIndex();
      frame.repaint();
    });

    JButton prevButton = new JButton("<< Prev <<");
    prevButton.addActionListener(e -> {
      if (currentSnapshotIndex > 0) {
        snapshotCombo.setSelectedItem(snapshots.get(--currentSnapshotIndex).getId());
        frame.repaint();
      } else {
        JOptionPane.showMessageDialog(frame, "No more previous snapshots");
      }
    });
    frame.getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(
            KeyStroke.getKeyStroke("LEFT"), "prev");
    frame.getRootPane().getActionMap().put("prev", new AbstractAction() {
      @Override
      public void actionPerformed(java.awt.event.ActionEvent e) {
        prevButton.doClick();
      }
    });

    JButton nextButton = new JButton(">> Next >>");
    nextButton.addActionListener(e -> {
      if (currentSnapshotIndex < snapshots.size() - 1) {
        snapshotCombo.setSelectedItem(snapshots.get(++currentSnapshotIndex).getId());
        frame.repaint();
      } else {
        JOptionPane.showMessageDialog(frame, "End of photo album. No snapshots to show " +
                "beyond this one.");
      }
    });

    frame.getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(
            KeyStroke.getKeyStroke("RIGHT"), "next");
    frame.getRootPane().getActionMap().put("next", new AbstractAction() {
      @Override
      public void actionPerformed(java.awt.event.ActionEvent e) {
        nextButton.doClick();
      }
    });

    JButton quitButton = new JButton("xx Quit xx");
    quitButton.addActionListener(e -> {
      int quitmessage = JOptionPane.showConfirmDialog(frame, "Do want to quit?", "Quit",
              JOptionPane.YES_NO_OPTION);
      if (quitmessage == JOptionPane.YES_OPTION) {
        System.exit(0);
      }
    });

    panel.add(prevButton);
    panel.add(snapshotCombo);
    panel.add(nextButton);
    panel.add(quitButton);
    frame.getContentPane().add(panel, BorderLayout.SOUTH);
  }
  private void drawImages(List<ISnapshot> snapshots) {
    JPanel images = new JPanel() {
      @Override
      public void paintComponent(Graphics g) {
        super.paintComponent(g);
        ISnapshot snapshot = snapshots.get(currentSnapshotIndex);
        for (Shape shape : snapshot.getShapes()) {
          g.setColor(shape.getColor());

          if (shape instanceof Rectangle) {
            Rectangle rectangle = (Rectangle) shape;
            Point2D corner = rectangle.getCorner();
            g.fillRect((int) corner.getX(), (int) corner.getY(),
                    (int) rectangle.getWidth(), (int) rectangle.getHeight());
          } else if (shape instanceof Oval) {
            Oval oval = (Oval) shape;
            Point2D corner = oval.getCorner();
            g.fillOval((int) (corner.getX() - oval.getxRadius()) , (int) (corner.getY()
                            - oval.getyRadius()),
                    (int) oval.getxRadius() * 2, (int) oval.getyRadius() * 2);
          }
        }

        String labelText = "<html><div>" + snapshot.getId() + "</div></html>";
        description.setText(labelText);
      }
    };

    frame.getContentPane().add(images, BorderLayout.CENTER);
  }
}

