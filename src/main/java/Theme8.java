//public class Theme8 {
//    public static void main (String[] args) {
//        System.out.println("hi");
//    }
//}

interface Flyable {
    default void fly() {
        System.out.println("Fly");
    };
}

interface Swimable {
    void swim();
}

interface Driveable {
    void drive();
}

class Rocket8 implements Flyable, Swimable {
    public void fly() {
        System.out.println("Fly, rocket, fly!");
    }

    public void swim() {
        System.out.println("Swim, rocket, swim!");
    }

    public static void main (String[] args) {
        new Rocket8().fly();
    }
}

abstract class AbstractCar implements Driveable {}

interface CanTransferViaInternet {}

class TcpPacket implements CanTransferViaInternet {}

class Tester {
    static void main(String[] args) {
        Object item = new TcpPacket();
        System.out.println(item instanceof CanTransferViaInternet);
    }
}

interface UniversalTransport extends Flyable, Swimable {
    String getName();
}

class Amphibian implements UniversalTransport {
    public void fly() {
        System.out.println(getName() + " fly");
    }

    public void swim() {
        System.out.println(getName() + " swim");
    }

    @Override
    public String getName() {
        return "Amphibian";
    }
}

class AmphibianTest {
    static void main(String[] args) {
        Amphibian amphibian = new Amphibian();
        amphibian.fly();
        amphibian.swim();
    }
}

interface Plantable {
    void plant();
}

class Apple implements Plantable {
    public void plant() {
        System.out.println("Plant apple");
    }
}

class Garden {
    public void addPlant (Plantable plant) {
        plant.plant();
    }
}

class GardenTest {
    static void main(String[] args) {
        new Garden().addPlant(new Apple());
    }
}