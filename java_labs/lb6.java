import javax.swing.*;
import java.awt.*;

public class lb6 extends JFrame {
    private DrawingPanel drawingPanel;
    private String currentShape = "";

    public lb6() {
        setTitle("Малювання фігур");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());


        JPanel buttonPanel = new JPanel();

        JButton triangleButton = new JButton("Намалювати трикутник");
        JButton rectangleButton = new JButton("Намалювати прямокутник");
        JButton ellipseButton = new JButton("Намалювати еліпс");

        buttonPanel.add(triangleButton);
        buttonPanel.add(rectangleButton);
        buttonPanel.add(ellipseButton);

        add(buttonPanel, BorderLayout.SOUTH);


        drawingPanel = new DrawingPanel();
        add(drawingPanel, BorderLayout.CENTER);


        triangleButton.addActionListener(e -> {
            currentShape = "triangle";
            drawingPanel.repaint();
        });

        rectangleButton.addActionListener(e -> {
            currentShape = "rectangle";
            drawingPanel.repaint();
        });

        ellipseButton.addActionListener(e -> {
            currentShape = "ellipse";
            drawingPanel.repaint();
        });
    }


    private class DrawingPanel extends JPanel {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.setColor(Color.BLUE);

            int width = getWidth();
            int height = getHeight();

            switch (currentShape) {
                case "triangle":
                    int[] xPoints = {width / 2, width / 2 - 50, width / 2 + 50};
                    int[] yPoints = {50, 150, 150};
                    g.fillPolygon(xPoints, yPoints, 3);
                    break;
                case "rectangle":
                    g.fillRect(width / 2 - 60, 80, 120, 80);
                    break;
                case "ellipse":
                    g.fillOval(width / 2 - 60, 80, 120, 80);
                    break;
            }
        }
    }


    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            lb6 frame = new lb6();
            frame.setVisible(true);
        });
    }
}
