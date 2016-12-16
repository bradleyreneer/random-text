//package org.reneer.verse;
//
//import javax.swing.*;
//import java.awt.*;
////import java.awt.Graphics2D;
//import java.awt.event.*;
//import java.awt.image.*;
//import javax.swing.border.*;
//
//public class VersesApplet extends JApplet {
//
//    final static String finishMessage = "Close and Return";
//    final static String mapTitle = "Verses";
//
//    BookOfMormon bookOfMormon;
//
//    JComboBox fractalMethodList;
//    BevelBorder edge = new BevelBorder(BevelBorder.RAISED);
//    JComboBox widthCombo = new JComboBox();
//    JComboBox heightCombo = new JComboBox();
//    JTextField islandRemovalLevelField;
//    int islandRemovalLevel;
//
//    JButton doButton;
//
//    class ButtonControlHandler implements ActionListener {
//        public void actionPerformed(ActionEvent ae) {
//            JLabel descriptionLabel = new JLabel();
////            descriptionLabel.setText(mapDescription);
////            mapDialog = new MapDialog(mapView.getBufferedImage(), descriptionLabel);
//        }
//    }
//
//    public void init() {
//        SpringLayout layout = new SpringLayout();
//
//        // count the labeled pairs
//        int numPairs = 0;
//
//        // Create and populate the panel.
//        JPanel jPanel = new JPanel(layout);
//
//        JLabel jLabel;
//        JTextField jTextField;
//
//        jLabel = new JLabel("Map Generator");
//        jPanel.add(jLabel);
////        jLabel = new JLabel("Version "+ mapProperties.getVersion());
//        jPanel.add(jLabel);
//        numPairs++;
//
//        jLabel = new JLabel("Map Width");
//        jPanel.add(jLabel);
//        jPanel.add(widthCombo);
//        numPairs++;
//
//        jLabel = new JLabel("Map Height");
//        jPanel.add(jLabel);
//        jPanel.add(heightCombo);
//        numPairs++;
//
//
//        doButton = new JButton("Generate Map");
//        doButton.setBorder(edge);
//        ButtonControlHandler buttonHandler = new ButtonControlHandler();
//        doButton.addActionListener(buttonHandler);
//        jLabel = new JLabel(" ");
//        jPanel.add(doButton);
//        jPanel.add(jLabel);
//        numPairs++;
//
//        // Lay out the panel.
//        SpringLayoutUtilities.makeCompactGrid(jPanel, numPairs, 2, // rows, cols
//                                              6, 6, // initX, initY
//                                              6, 6); // xPad, yPad
//
//        // Create and set up the window.
//        JFrame frame = new JFrame("Map Generator");
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//
//        // Set up the content pane.
//        jPanel.setOpaque(true); // content panes must be opaque
//        frame.setContentPane(jPanel);
//
//        // Display the window.
//        frame.pack();
//        frame.setVisible(true);
//    }
//
//    class MapDialog extends JDialog implements ActionListener {
//
//        JScrollPane mapScrollPane;
//        JPanel mapPanel;
//
//        public MapDialog(BufferedImage mapBI, JLabel descriptionLabel) {
//            super();
//            this.setTitle(mapTitle);
//            JPanel infoPane = new JPanel();
//            infoPane.add(descriptionLabel);
//            getContentPane().add(infoPane, BorderLayout.NORTH);
//
//            JPanel finishButtonPane = new JPanel();
//            JButton finishButton = new JButton(finishMessage);
//            finishButtonPane.add(finishButton);
//            finishButton.addActionListener(this);
//            getContentPane().add(finishButtonPane, BorderLayout.SOUTH);
//
//            Icon icon = new ImageIcon(mapBI);
//            JLabel mapLabel = new JLabel(icon);
//            mapPanel = new JPanel();
//            mapPanel.add(mapLabel);
//            System.out.println("mapPanel "+mapPanel);
//            mapScrollPane = new JScrollPane(mapPanel, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
//                            JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
//            getContentPane().add(mapScrollPane, BorderLayout.CENTER);
//            System.out.println("mapBI "+mapBI);
//            System.out.println("");
//
//            setDefaultCloseOperation(DISPOSE_ON_CLOSE);
//            pack();
//            setVisible(true);
//        }
//
//        // public void paint(Graphics g) {
//        // Graphics2D g2 = (Graphics2D)g;
//        // g2.drawImage(mapBI, 0, 0, mapPane);
//
//        // pack();
//        // }
//
//        public void actionPerformed(ActionEvent ae) {
//            setVisible(false);
//            dispose();
//        }
//    }
//}
