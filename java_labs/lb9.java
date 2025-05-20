import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.*;

public class lb9 extends JFrame {

    private JTable table;
    private DefaultTableModel model;
    private Connection connection;

    public lb9() {
        super("Автовокзал");

        connectToDatabase();
        initUI();
        loadData();
    }

    private void connectToDatabase() {
        try {
            connection = DriverManager.getConnection("jdbc:sqlite:bus_station.db");

            String createTableSQL = "CREATE TABLE IF NOT EXISTS buses (" +
                    "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                    "destination TEXT NOT NULL," +
                    "departure_time TEXT NOT NULL," +
                    "platform INTEGER NOT NULL)";
            Statement stmt = connection.createStatement();
            stmt.execute(createTableSQL);
        } catch (SQLException e) {
            showError("DB connection error: " + e.getMessage());
        }
    }

    private void initUI() {
        model = new DefaultTableModel(new String[]{"ID", "Пункт призначення", "Час", "Платформа"}, 0);
        table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);

        JButton addButton = new JButton("Додати");
        addButton.addActionListener(e -> addBus());

        JButton deleteButton = new JButton("Видалити");
        deleteButton.addActionListener(e -> deleteSelectedBus());

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(addButton);
        buttonPanel.add(deleteButton);

        this.setLayout(new BorderLayout());
        this.add(scrollPane, BorderLayout.CENTER);
        this.add(buttonPanel, BorderLayout.SOUTH);

        this.setSize(600, 400);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
    }

    private void loadData() {
        try {
            model.setRowCount(0);
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM buses");

            while (rs.next()) {
                model.addRow(new Object[]{
                        rs.getInt("id"),
                        rs.getString("destination"),
                        rs.getString("departure_time"),
                        rs.getInt("platform")
                });
            }
        } catch (SQLException e) {
            showError("Loading error: " + e.getMessage());
        }
    }

    private void addBus() {
        JTextField destinationField = new JTextField();
        JTextField timeField = new JTextField();
        JTextField platformField = new JTextField();

        Object[] message = {
                "Пункт призначення:", destinationField,
                "Час відправлення:", timeField,
                "Платформа:", platformField
        };

        int option = JOptionPane.showConfirmDialog(this, message, "Додати рейс", JOptionPane.OK_CANCEL_OPTION);
        if (option == JOptionPane.OK_OPTION) {
            try {
                String destination = destinationField.getText();
                String time = timeField.getText();
                int platform = Integer.parseInt(platformField.getText());

                PreparedStatement ps = connection.prepareStatement("INSERT INTO buses (destination, departure_time, platform) VALUES (?, ?, ?)");
                ps.setString(1, destination);
                ps.setString(2, time);
                ps.setInt(3, platform);
                ps.executeUpdate();

                loadData();
            } catch (Exception e) {
                showError("Помилка додавання: " + e.getMessage());
            }
        }
    }

    private void deleteSelectedBus() {
        int selectedRow = table.getSelectedRow();
        if (selectedRow >= 0) {
            int busId = (int) model.getValueAt(selectedRow, 0);
            try {
                PreparedStatement ps = connection.prepareStatement("DELETE FROM buses WHERE id = ?");
                ps.setInt(1, busId);
                ps.executeUpdate();

                loadData();
            } catch (SQLException e) {
                showError("Помилка видалення: " + e.getMessage());
            }
        } else {
            showError("Оберіть рядок для видалення.");
        }
    }

    private void showError(String message) {
        JOptionPane.showMessageDialog(this, message, "Помилка", JOptionPane.ERROR_MESSAGE);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new lb9().setVisible(true));
    }
}
