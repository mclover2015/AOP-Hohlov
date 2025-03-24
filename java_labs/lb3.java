
interface Run {
    void move();
}


abstract class Mashine implements Run {

    public static final int MAX_SPEED = 200;
    public static final int MIN_SPEED = 0;
    public static final int MAX_PASSENGERS = 50;
    public static final int MIN_PASSENGERS = 1;


    protected String name;
    protected int speed;


    public Mashine(String name, int speed) {
        this.name = name;
        this.speed = speed;
    }


    public void printName() {
        System.out.println("назва транспорту: " + name);
    }
}


class Car extends Mashine {
    private int passengers;

    public Car(String name, int speed, int passengers) {
        super(name, speed);
        if (passengers >= MIN_PASSENGERS && passengers <= MAX_PASSENGERS) {
            this.passengers = passengers;
        } else {
            System.out.println("некоректна кількість пасажирів!");
            this.passengers = MIN_PASSENGERS;
        }
    }


    @Override
    public void move() {
        System.out.println(name + " рухається зі швидкістю " + speed + " км/год з " + passengers + " пасажирами.");
    }
}


public class lb3 {
    public void start() {

        Car car = new Car("Toyota", 120, 4);
        car.printName();
        car.move();

        Car bus = new Car("Bus", 80, 40);
        bus.printName();
        bus.move();
    }
}

