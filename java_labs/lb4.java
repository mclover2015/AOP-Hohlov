import javax.swing.*;
import java.awt.*;

public class lb4 extends JFrame {

    public lb4() {

        setTitle("прямокутники з написом");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);


        add(new RectanglePanel());
    }


    private class RectanglePanel extends JPanel {

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);


            g.setColor(Color.RED);
            g.fillRect(50, 50, 300, 200);


            g.setColor(Color.GREEN);
            g.fillRect(100, 100, 200, 150);


            g.setColor(Color.BLUE);
            g.fillRect(150, 150, 100, 100);


            g.setColor(Color.WHITE);
            g.setFont(new Font("Arial", Font.ITALIC, 18));
            g.drawString("Розробник: Кирило", 120, 250);
        }
    }


    public void start() {
        SwingUtilities.invokeLater(() -> {
            lb4 app = new lb4();
            app.setVisible(true);
        });
    }
}
