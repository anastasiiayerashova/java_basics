class Quad {
    protected int side;

    public void setSide (int side) {
        this.side = side;
    }

    public int getArea () {
        return side * side;
    }
}

class Qube extends Quad {
    public int getVolume () {
        return side * side * side;
    }
}

class Shape {
    public float getArea () {
        return - 1f;
    }
}

class Quad1 extends Shape {
    private int side;

    public void setSide (int side) {
        this.side = side;
    }

    @Override
    public float getArea () {
        return side * side;
    }
}

class Circle extends Shape {
    private float radius;

    public void setRadius (float radius) {
        this.radius = radius;
    }

    public float getArea () {
        return radius * radius * radius;
    }
}

class AreaPrinter {
    public void printArea(Shape shape) {
        System.out.println(shape.getArea());
    }

    public void sayHello (String name, int count) {
        for (int i = 0; i < count; i ++) {
            System.out.println("Hello " + name);
        }
    }

    public void printNumbers (int start, int end) {
        int current = start;

        while (true) {
            System.out.println(current);
            current ++;
            if (current > end) {
                return;
            }
        }
    }
}

class Starship {
    int fuel;
}

class Human {
    String name;

    public void printName (String name) {
        System.out.println(name + " " + this.name);
    }
}

class Rocket {
    private String serialNumber;

    public String getSerialNumber () {
        return serialNumber;
    }

    public void setSerialNumber (String serialNumber) {
        if (serialNumber != null && !serialNumber.isBlank()) {
            this.serialNumber = serialNumber;
        }
    }
}

class QuadSummator {
    public int sumQuads (int n) {
        int result = 0;

        for (int i = 1; i < n; i ++) {
            result += pow2(i);
        }

        return result;
    }

    private int pow2 (int number) {
        return number * number;
    }
}

public class Theme6 {
    public static void main (String[] args) {
//        Quad quad = new Quad();
//        quad.setSide(2);
//        System.out.println(quad.getArea());
//
//        Qube qube = new Qube();
//        qube.setSide(5);
//        System.out.println(qube.getArea());
//        System.out.println(qube.getVolume());

//        Quad1 quad1 = new Quad1();
//        quad1.setSide(5);

//        AreaPrinter areaPrinter = new AreaPrinter();
//        areaPrinter.printArea(quad1);
//
//        Circle circle = new Circle();
//        circle.setRadius(2);
//
//        areaPrinter.printArea(circle);

//        areaPrinter.sayHello("apple", 4);
//        areaPrinter.printNumbers(1, 6);

//        Starship starship = new Starship();
//        starship.fuel = 100;
//        System.out.println(starship.fuel);

//        Human human = new Human();
//        human.name = "apple";
//        human.printName("kiwi");

//        Rocket rocket = new Rocket();
//        rocket.setSerialNumber("abc");
//        System.out.println(rocket.getSerialNumber());

        QuadSummator quadSummator = new QuadSummator();
        System.out.println(quadSummator.sumQuads(3));
    }
}
