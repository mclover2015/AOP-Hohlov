import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("which lab?");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                lb1 lab1 = new lb1();
                lab1.start();
                break;
            case 2:
                lb2 lab2 = new lb2(1, 2, 3, 4);
                lab2.start();
                break;
            case 3:
                lb3 lab3 = new lb3();
                lab3.start();
                break;
            case 4:
                lb4 lab4 = new lb4();
                lab4.start();
                break;
            default:
                System.out.println("invalid lab number!!!");
        }

        scanner.close();
    }
}
