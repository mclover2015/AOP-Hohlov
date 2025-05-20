package lb10;

import java.io.*;

public class lb10 {
    public static void main(String[] args) {
        String inputFile = lb10.class.getResource("input.txt").getFile();
        String outputFile = "OUTPUT.txt";
        double totalSum = 0;

        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile))) {
            String line;
            System.out.println("Список покупок:");
            while ((line = reader.readLine()) != null) {
                String[] parts = line.trim().split("\\s+");
                if (parts.length != 3) continue;

                String item = parts[0];
                int quantity = Integer.parseInt(parts[1]);
                double price = Double.parseDouble(parts[2]);

                double itemTotal = quantity * price;
                totalSum += itemTotal;

                System.out.printf("%s — %d шт. × %.2f грн = %.2f грн%n", item, quantity, price, itemTotal);
            }
        } catch (IOException e) {
            System.err.println("Помилка при зчитуванні файлу: " + e.getMessage());
            return;
        }


        try (PrintWriter writer = new PrintWriter(new FileWriter("OUTPUT.txt"))) {
            writer.printf("Загальна сума покупки: %.2f грн%n", totalSum);
            System.out.printf("Загальна сума покупки: %.2f грн записана в OUTPUT.txt%n", totalSum);
        } catch (IOException e) {
            System.err.println("Помилка при записі у файл OUTPUT.txt: " + e.getMessage());
        }
    }
}
