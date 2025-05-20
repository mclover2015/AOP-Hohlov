import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.function.Supplier;

public class lb8 extends JFrame {

    private String currentShape = "";

    public lb8() {
        setTitle("Shape Drawer");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        DrawingPanel drawingPanel = new DrawingPanel();
        add(drawingPanel);

        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("Фігури");

        JMenuItem triangleItem = new JMenuItem("Намалювати трикутник");
        triangleItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_T, ActionEvent.CTRL_MASK));
        triangleItem.addActionListener(e -> {
            currentShape = "triangle";
            drawingPanel.repaint();
        });

        JMenuItem rectangleItem = new JMenuItem("Намалювати прямокутник");
        rectangleItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R, ActionEvent.CTRL_MASK));
        rectangleItem.addActionListener(e -> {
            currentShape = "rectangle";
            drawingPanel.repaint();
        });

        JMenuItem ellipseItem = new JMenuItem("Намалювати еліпс");
        ellipseItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, ActionEvent.CTRL_MASK));
        ellipseItem.addActionListener(e -> {
            currentShape = "ellipse";
            drawingPanel.repaint();
        });

        menu.add(triangleItem);
        menu.add(rectangleItem);
        menu.add(ellipseItem);
        menuBar.add(menu);
        setJMenuBar(menuBar);


        drawingPanel.setShapeSupplier(() -> currentShape);
    }

    class DrawingPanel extends JPanel {
        private Supplier<String> shapeSupplier;

        public void setShapeSupplier(Supplier<String> supplier) {
            this.shapeSupplier = supplier;
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            if (shapeSupplier == null) return;

            String shape = shapeSupplier.get();
            Graphics2D g2 = (Graphics2D) g;
            g2.setStroke(new BasicStroke(2));
            g2.setColor(Color.BLUE);

            int w = getWidth();
            int h = getHeight();

            switch (shape) {
                case "triangle":
                    int[] x = {w / 2, w / 2 - 100, w / 2 + 100};
                    int[] y = {100, 300, 300};
                    g2.drawPolygon(x, y, 3);
                    break;
                case "rectangle":
                    g2.drawRect(w / 2 - 100, h / 2 - 50, 200, 100);
                    break;
                case "ellipse":
                    g2.drawOval(w / 2 - 100, h / 2 - 50, 200, 100);
                    break;
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new lb8().setVisible(true);
        });
    }
}
