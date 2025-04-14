import javax.swing.*;
import java.awt.*;

public class lb5 {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {

            JFrame frame = new JFrame("Бланк замовлення");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(500, 400);
            frame.setLocationRelativeTo(null);


            JPanel panel = new JPanel();
            panel.setLayout(new GridBagLayout());
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.insets = new Insets(10, 10, 10, 10);
            gbc.anchor = GridBagConstraints.WEST;


            JLabel title = new JLabel("Бланк замовлення");
            title.setFont(new Font("Arial", Font.BOLD, 20));
            title.setForeground(new Color(0, 102, 204));
            gbc.gridwidth = 2;
            gbc.gridx = 0;
            gbc.gridy = 0;
            panel.add(title, gbc);


            gbc.gridwidth = 1;
            gbc.gridy++;
            panel.add(new JLabel("Назва продукції"), gbc);
            gbc.gridx = 1;
            panel.add(new JTextField(20), gbc);


            gbc.gridx = 0;
            gbc.gridy++;
            panel.add(new JLabel("Формат паперу"), gbc);
            gbc.gridx = 1;
            panel.add(new JComboBox<>(new String[]{"A4", "A5", "A3"}), gbc);


            gbc.gridx = 0;
            gbc.gridy++;
            panel.add(new JLabel("Кількість сторінок"), gbc);
            gbc.gridx = 1;
            panel.add(new JTextField(10), gbc);


            gbc.gridx = 0;
            gbc.gridy++;
            panel.add(new JLabel("Кількість екземплярів"), gbc);
            gbc.gridx = 1;
            panel.add(new JTextField(10), gbc);


            gbc.gridx = 0;
            gbc.gridy++;
            panel.add(new JLabel(""), gbc); // Пустий простір
            gbc.gridx = 1;

            JRadioButton pickup = new JRadioButton("Хочу забрати замовлення самостійно");
            JRadioButton courier = new JRadioButton("Доставка замовлення кур'єром");
            JRadioButton post = new JRadioButton("Доставка замовлення УкрПоштою");

            ButtonGroup group = new ButtonGroup();
            group.add(pickup);
            group.add(courier);
            group.add(post);

            courier.setSelected(true);

            gbc.gridy++;
            panel.add(pickup, gbc);
            gbc.gridy++;
            panel.add(courier, gbc);
            gbc.gridy++;
            panel.add(post, gbc);


            JButton submitButton = new JButton("Оформити замовлення");
            submitButton.setBackground(Color.GREEN.darker());
            submitButton.setForeground(Color.BLACK);
            gbc.gridy++;
            gbc.anchor = GridBagConstraints.CENTER;
            panel.add(submitButton, gbc);



            frame.add(panel);
            frame.setVisible(true);


        });
    }
}
