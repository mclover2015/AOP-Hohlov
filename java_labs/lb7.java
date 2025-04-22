import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class lb7 extends JFrame {

    public lb7() {
        setTitle("О, щасливчик!");
        setSize(500, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());


        JLabel questionLabel = new JLabel("Хто є автором твору 'Кобзар'?", SwingConstants.CENTER);
        questionLabel.setFont(new Font("Arial", Font.BOLD, 18));
        questionLabel.setFont(new Font("Verdana", Font.BOLD, 22));
        add(questionLabel, BorderLayout.NORTH);


        JPanel answerPanel = new JPanel();
        answerPanel.setLayout(new GridLayout(2, 2, 10, 10));



        JButton btn1 = new JButton("Іван Франко");
        JButton btn2 = new JButton("Тарас Шевченко");
        JButton btn3 = new JButton("Леся Українка");
        JButton btn4 = new JButton("Микола Гоголь");


        answerPanel.add(btn1);
        answerPanel.add(btn2);
        answerPanel.add(btn3);
        answerPanel.add(btn4);

        add(answerPanel, BorderLayout.CENTER);


        ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JButton source = (JButton) e.getSource();
                String selected = source.getText();

                if (selected.equals("Тарас Шевченко")) {
                    JOptionPane.showMessageDialog(lb7.this, "Так! Це правильна відповідь.");
                } else {
                    JOptionPane.showMessageDialog(lb7.this, "Ні! Неправильна відповідь.");
                }
            }
        };


        btn1.addActionListener(listener);
        btn2.addActionListener(listener);
        btn3.addActionListener(listener);
        btn4.addActionListener(listener);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            lb7 game = new lb7();
            game.setVisible(true);
        });
    }
}
