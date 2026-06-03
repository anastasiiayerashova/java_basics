import java.util.Objects;

public class Theme7 {
    public static void main (String[] args) {
        System.out.println("hi");
    }
}

//class Rocket1 {
//    public String toString () {
//        return "I am rocket";
//    }
//
//    public static void main (String[] args) {
//        System.out.println(new Rocket1());
//
//        Class rocketClass = new Rocket1().getClass();
//        System.out.println(rocketClass.getSimpleName());
//
//        Class rocketClass2 = Rocket1.class;
//        System.out.println(rocketClass2.getSimpleName());
//    }
//}

class PointAnother {
    private int x;
    private int y;

    public int getX () {
        return x;
    }

    public void setX (int x) {
        this.x = x;
    }

    public int getY () {
        return y;
    }

    public void setY (int y) {
        this.y = y;
    }

    @Override
    public boolean equals (Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PointAnother point1 = (PointAnother) o;
        return x == point1.x && y == point1.y;
    }

    @Override
    public int hashCode () {
        return Objects.hash(x, y);
    }

    public static void main (String[] args) {
        PointAnother pointAnother1 = new PointAnother();
        pointAnother1.setX(10);
        pointAnother1.setY(5);

        PointAnother pointAnother2 = new PointAnother();
        pointAnother2.setX(10);
        pointAnother2.setY(5);

        PointAnother pointAnother3 = new PointAnother();
        pointAnother3.setX(100);
        pointAnother3.setY(50);

        System.out.println(pointAnother1.equals(pointAnother2));
        System.out.println(pointAnother1.equals(pointAnother3));
    }
}

class Printer {
    void print(long a)   { System.out.println("long"); }
    void print(double a) { System.out.println("double"); }
}

class Test {
    public static void main(String[] args) {
        new Printer().print(5);   // int → long: виведе "long"
        new Printer().print(5L);  // точний збіг до long: "long"
        new Printer().print(5.0); // точний збіг до double: "double"
    }
}

class Demo {
    void f(Integer x) { System.out.println("Integer"); }
    void f(int... xs) { System.out.println("varargs"); }

    public static void main(String[] args) {
        new Demo().f(5); // "Integer": автобоксинг кращий, ніж varargs
    }
}

class Demo2 {
    void g(Object o)  { System.out.println("Object"); }
    void g(int... xs) { System.out.println("varargs"); }

    public static void main(String[] args) {
        new Demo2().g(5); // "Object": 5 боксується в Integer, далі upcast до Object.
        // Звичайний виклик кращий, ніж varargs.
    }
}

//class Printer2 {
//    void print(long a, float b) { System.out.println("long,float"); }
//    void print(float a, long b) { System.out.println("float,long"); }
//
//    public static void main(String[] args) {
//        // Обидва кандидати придатні для (int, int):
//        // int→long + int→float проти int→float + int→long.
//        // Жоден не виглядає більш специфічним — компілятор повідомить про неоднозначність.
//        new Printer2().print(1, 1); // ❌ ambiguous
//    }
//}

//class Over {
//    void f(Integer x) {}
//    void f(Long x) {}
//
//    public static void main(String[] args) {
//        new Over().f(null); // ❌ ambiguous: null підходить і до Integer, і до Long
//    }
//}




