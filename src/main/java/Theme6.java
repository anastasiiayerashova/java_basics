import java.util.*;

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

class SpaceShip {
    private String name;
    private String serialNumber;

    public String getName () {
        return this.name;
    }

    public void setName (String name) {
        if (name.isBlank() || name.length() >= 100) {
            return;
        }

        this.name = name;
    }

    public String getSerialNumber () {
        return this.serialNumber;
    }

    public void setSerialNumber (String serialNumber) {
        if (serialNumber.length() > 8 || !serialNumber.substring(0, 2).equals("SN")) {
            return;
        }

        this.serialNumber = serialNumber;
    }

    public void printInfo () {
        String res = String.format("Name is %s, serial number is %s", this.name, this.serialNumber);
        System.out.println(res);
    }


    public static void main(String[] args) {
        SpaceShip ship = new SpaceShip();

        ship.setSerialNumber("SN506788");
        System.out.println(ship.getSerialNumber());

        ship.setSerialNumber("EE123456");
        System.out.println(ship.getSerialNumber());

        ship.printInfo();
    }
}

class SpaceRocketLauncher {
    private int bigRocketCount;
    private int smallRocketCount;

    public int getBigRocketCount () {
        return this.bigRocketCount;
    }

    public void setBigRocketCount (int bigRocketCount) {
        if (bigRocketCount < 0 || bigRocketCount > 100) return;

        this.bigRocketCount = bigRocketCount;
    }

    public int getSmallRocketCount () {
        return this.smallRocketCount;
    }

    public void setSmallRocketCount (int smallRocketCount) {
        if (smallRocketCount < 0 || smallRocketCount > 100) return;

        this.smallRocketCount = smallRocketCount;
    }

    public void launchBigRocket () {
        if (bigRocketCount > 0) {
            this.bigRocketCount --;
            System.out.println("Launch big rocket");
        }
    }

    public void launchSmallRocket () {
        if (smallRocketCount > 0) {
            this.smallRocketCount --;
            System.out.println("Launch small rocket");
        }
    }

    public int getTotalPower () {
        return bigRocketCount * 100 + smallRocketCount * 50;
    }

    public static void main (String[] args) {
        SpaceRocketLauncher launcher = new SpaceRocketLauncher();
        launcher.setBigRocketCount(5);
        launcher.setSmallRocketCount(10);

        System.out.println("Power is " + launcher.getTotalPower());

        launcher.launchBigRocket();
        System.out.println("Big rocket count is " + launcher.getBigRocketCount());

        launcher.launchSmallRocket();
        System.out.println("Small rocket count is " + launcher.getSmallRocketCount());
    }
}

class Engine {
    private int power;

    public void setPower(int power) {
        this.power = power;
    }

    public int getPower() {
        return this.power;
    }

    public String getFuelType() {
        return "A500";
    }

    public static void main(String[] args) {
        Engine basicEngine = new Engine();
        System.out.println(basicEngine.getFuelType()); //A500

        Engine xFuelEngine = new XFuelEngine();
        System.out.println(xFuelEngine.getFuelType()); //XFuel
    }
}

class XFuelEngine extends Engine {
    protected String serialNumber;

    public void setSerialNumber (String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getFuelType () {
        return "XFuel";
    }
}

class AdvancedXFuelEngine extends XFuelEngine {
    public void printInfo () {
       System.out.println("Serial number is " + serialNumber + ", " + "power is " + getPower());
    }

    public static void main (String[] args) {
        AdvancedXFuelEngine engine = new AdvancedXFuelEngine();
        engine.setPower(1000);
        engine.setSerialNumber("SN504030");
        engine.printInfo(); //Serial number is SN504030, power is 1000
    }
}

class Tanker {
    private String serialNumber;

    public String getSerialNumber () {
        return this.serialNumber;
    }

    public void setSerialNumber (String serialNumber) {
        this.serialNumber = serialNumber;
    }

    protected String getFuelType () {
        return "A500";
    }

    public void refuel (int amount) {
        System.out.println("Add " + amount + " of " + getFuelType() + ", tanker serial number is " + serialNumber);
    }

    public static void main (String[] args) {
//        Tanker tanker = new Tanker();
//        tanker.setSerialNumber("SN504030");
//        tanker.refuel(300);

//        Tanker tanker = new XFuelTanker();
//        tanker.setSerialNumber("SN504030");
//        tanker.refuel(300);

        Tanker tanker = new MX200Tanker();
        tanker.setSerialNumber("SN504030");
        tanker.refuel(300);
    }
}

class XFuelTanker extends Tanker {
    protected String getFuelType () {
        return "XFuel";
    }
}

class MX200Tanker extends XFuelTanker {
    protected String getFuelType () {
        return "MX200";
    }
}

abstract class Passenger {
    public abstract String getType();

    public abstract int getTicketPrice();
}

class RegularPassenger extends Passenger {
    public String getType () {
        return "Regular";
    }

    public int getTicketPrice () {
        return 199;
    }

    public static void main (String[] args) {
        RegularPassenger regularPassenger = new RegularPassenger();
        System.out.println(regularPassenger.getType());
        System.out.println(regularPassenger.getTicketPrice());
    }
}

class VIPPassenger extends Passenger {
    public String getType () {
        return "VIP";
    }

    public int getTicketPrice () {
        return 399;
    }

    public static void main (String[] args) {
        VIPPassenger vipPassenger = new VIPPassenger();
        System.out.println(vipPassenger.getType());
        System.out.println(vipPassenger.getTicketPrice());
    }
}

class LaunchCalculator {
    public int calculateTotalPrice (Spaceport spaceport, int passengerCount) {
        return spaceport.calculateTotalPrice(passengerCount);
    }

    public static void main(String[] args) {
        LaunchCalculator calculator = new LaunchCalculator();

        int jupiterStarPrice = calculator.calculateTotalPrice(new JupiterStar(), 100);
        System.out.println("JupiterStar price = " + jupiterStarPrice); //700

        int mercuryBeatPrice = calculator.calculateTotalPrice(new MercuryBeat(), 100);
        System.out.println("MercuryBeat price = " + mercuryBeatPrice); //1500

        int sunHeavenPrice = calculator.calculateTotalPrice(new SunHeaven(), 100);
        System.out.println("SunHeaven price = " + sunHeavenPrice); //2000
    }
}

abstract class Spaceport {
    public abstract int calculateTotalPrice (int passengerCount);
}

class JupiterStar extends Spaceport {
    public int calculateTotalPrice (int passengerCount) {
        return 500 + (2 * passengerCount);
    }
}

class MercuryBeat extends Spaceport {
    public int calculateTotalPrice (int passengerCount) {
        return 15 * passengerCount;
    }
}

class SunHeaven extends Spaceport {
    public int calculateTotalPrice (int passengerCount) {
        return 2000;
    }
}

class Planets {
    public static final String MERCURY = "Mercury";
    public static final String VENUS = "Venus";
    public static final String EARTH = "Earth";
    public static final String MARS = "Mars";
    public static final String JUPITER = "Jupiter";
    public static final String SATURN = "Saturn";
    public static final String URANUS = "Uranus";
    public static final String NEPTUNE = "Neptune";

    public static void main (String[] args) {
        System.out.println(Planets.MARS);
    }
}

class SpaceportMessages {
    public static String generateLandingMessage (String shipName, String spaceport, String time) {
        return "Spaceship " + shipName + " landing at " + spaceport + ", time is " + time;
    }

    public static void main (String[] args) {
        System.out.println(SpaceportMessages.generateLandingMessage("SunFlower", "EarthKeeper", "20:40"));
    }
}

class SpaceUtils {
    public static final int PLANET_COUNT = 8;
    public static final String HOME_PLANET_NAME = "Earth";
    public static final String HOME_STAR_NAME = "Sun";

    public static String pluralPlanets (int planetCount) {
        if (planetCount == 1) {
            return planetCount + " planet";
        }
        return planetCount + " planets";
    }

    public static String generateStartMessage (String shipName, String time) {
        return "Ship " + shipName + " start at " + time;
    }

    public static void main (String[] args) {
        System.out.println(SpaceUtils.PLANET_COUNT);
        System.out.println(SpaceUtils.pluralPlanets(5));
    }
}

class Point {
    private int x;
    private int y;
    private int z;

    public int getX () {
        return this.x;
    }

    public int getY () {
        return this.y;
    }

    public int getZ () {
        return this.z;
    }

    public void setX (int x) {
        this.x = x;
    }

    public void setY (int y) {
        this.y = y;
    }

    public void setZ (int z) {
        this.z = z;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;

        if (obj == null || getClass() != obj.getClass()) return false;

        Point point = (Point) obj;

        return x == point.x && y == point.y && z == point.z;
    }

    @Override
    public int hashCode () {
        return Objects.hash(x, y, z);
    }
}

//class PointTest {
//    public static void main(String[] args) {
//        Point p1 = new Point();
//        p1.setX(1);
//        p1.setY(1);
//        p1.setZ(1);
//
//        Point p2 = new Point();
//        p2.setX(1);
//        p2.setY(1);
//        p2.setZ(1);
//
//        System.out.println(p1.equals(p2));
//        System.out.println(p1.hashCode() == p2.hashCode());
//
//    }
//}

class StarTrack {
    private Point start;
    private Point finish;

    public Point getStart () {
        return this.start;
    }

    public Point getFinish () {
        return this.finish;
    }

    public void setStart (Point point) {
        this.start = point;
    }

    public void setFinish (Point finish) {
        this.finish = finish;
    }

    @Override
    public boolean equals (Object obj) {
        if (this == obj) return true;

        if (obj == null || getClass() != obj.getClass()) return false;

        StarTrack starTrack = (StarTrack) obj;

        return Objects.equals(start, starTrack.start) && Objects.equals(finish, starTrack.finish);
    }

    @Override
    public int hashCode () {
        return Objects.hash(start, finish);
    }

    public static void main (String[] args) {
        Point p1 = new Point();
        p1.setX(143);
        p1.setY(453);
        p1.setZ(830);

        Point p2 = new Point();
        p1.setX(1);
        p1.setY(1);
        p1.setZ(1);

        Point p3 = new Point();
        p1.setX(1);
        p1.setY(2);
        p1.setZ(1);

        StarTrack track1 = new StarTrack();
        track1.setStart(p1);
        track1.setFinish(p2);

        StarTrack track2 = new StarTrack();
        track2.setStart(p1);
        track2.setFinish(p2);

        StarTrack track3 = new StarTrack();
        track3.setStart(p1);
        track3.setFinish(p3);

        System.out.println(track1.equals(track2)); //Should be true
        System.out.println(track1.equals(track3)); //Should be false
        System.out.println(track1.hashCode() == track2.hashCode()); //Should be true
    }
}

class RocketLauncher {
    private String size;
    private int rocketCount;

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public int getRocketCount() {
        return rocketCount;
    }

    public void setRocketCount(int rocketCount) {
        this.rocketCount = rocketCount;
    }

    @Override
    public String toString() {
        return "Size is " + size + ", rocket count is " + rocketCount;
    }

    public static void main(String[] args) {
        RocketLauncher launcher = new RocketLauncher();
        launcher.setSize("big");
        launcher.setRocketCount(50);

        //Should be - Size is big, rocket count is 50
        System.out.println(launcher);
    }
}

class Stars {
    private int count;

    public int getCount () {
        return this.count;
    }

    public void setCount (int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        int stars = count;
        StringBuilder result = new StringBuilder();

        int x = stars / 1000;
        stars %= 1000;

        int y = stars / 100;
        stars %= 100;

        int z = stars / 10;
        stars %= 10;

        int s = stars;

        result.append("X".repeat(x));
        result.append("Y".repeat(y));
        result.append("Z".repeat(z));
        result.append("*".repeat(s));

        return result.toString();
    }

    public static void main (String[] args) {
        Stars stars1 = new Stars();
        stars1.setCount(102);
        System.out.println(stars1);
        System.out.println(stars1.getCount());
    }
}

abstract class SpaceObject {}

abstract class Planet extends SpaceObject {}

class Mars extends Planet {}

class Moon extends SpaceObject {}

class PlanetTester {
    public String test (SpaceObject object) {
        if (object instanceof Planet) {
            return "planet";
        }
        return "not planet";
    }

    public static void main (String[] args) {
        PlanetTester tester = new PlanetTester();
        System.out.println(tester.test(new Mars()));
    }
}

class FirNum {
    public int calc (int n) {
        return n;
    }
}

class FirNumSum extends FirNum {
    @Override
    public int calc (int n) {
        int res = 0;
        for (int i = 1; i <= n; i ++) {
            res += i;
        }
        return res;
    }
}

class FirNumFactorial extends FirNum {
    @Override
    public int calc (int n) {
        int res = 1;
        for (int i = 1; i <= n; i ++) {
            res *= i;
        }
        return res;
    }
}

class FirNumMultiplyOdd extends FirNum {
    @Override
    public int calc (int n) {
        int res = 1;
        for (int i = 1; i <= n; i += 2) {
            res *= i;
        }
        return res;
    }
}

class FirNumFizzBuzz extends FirNum {
    @Override
    public int calc (int n) {
        int result = 0;
        for (int i = 1; i <= n; i ++) {
            if (i % 3 == 0 ^ i % 5 == 0) {
                result += i;
            }
        }
        return result;
    }
}

class FirNumBasis extends FirNum {
    @Override
    public int calc (int n) {
        int sum = 0;
        for (int i = 0; i <= n; i += 2) {
            sum += i;
        }
        return sum / 2;
    }
}

//class FirTest {
//    public int test(FirNum firNum, int number) {
//        return firNum.calc(number);
//    }
//
//    public static void main(String[] args) {
//        FirNum firNum = new FirNum();
//        FirTest firTest = new FirTest();
//        FirNumSum firNumSum = new FirNumSum();
//        FirNumFactorial firNumFactorial = new FirNumFactorial();
//        FirNumMultiplyOdd firNumMultiplyOdd = new FirNumMultiplyOdd();
//        FirNumFizzBuzz firNumFizzBuzz = new FirNumFizzBuzz();
//        FirNumBasis firNumBasis = new FirNumBasis();
//
//        //Should be 10
//        System.out.println(firTest.test(firNum, 10));
//        System.out.println(firNumSum.calc(3));
//        System.out.println(firNumFactorial.calc(4));
//        System.out.println(firNumMultiplyOdd.calc(4));
//        System.out.println(firTest.test(firNumFizzBuzz, 20));
//        System.out.println(firTest.test(firNumBasis, 9));
//    }
//}
//
//class SeasonTest {
//    public String test(Seasons season) {
//        return season.getName() + (season.isCold() ? " is cold" : " is warm");
//    }
//
//    public static void main(String[] args) {
//        SeasonTest seasonTest = new SeasonTest();
//
//        //Should be winter is cold
//        System.out.println(seasonTest.test(new Winter()));
//
//        //Should be spring is warm
//        System.out.println(seasonTest.test(new Spring()));
//
//        //Should be summer is warm
//        System.out.println(seasonTest.test(new Summer()));
//
//        //Should be autumn is cold
//        System.out.println(seasonTest.test(new Autumn()));
//    }
//}
//
//abstract class Season {
//    public abstract String getName();
//    public abstract boolean isCold();
//}
//
//class Winter extends Seasons {
//    public final String getName () {
//        return "winter";
//    }
//
//    public final boolean isCold () {
//        return true;
//    }
//}
//
//class Spring extends Seasons {
//    public final String getName () {
//        return "spring";
//    }
//
//    public final boolean isCold () {
//        return false;
//    }
//}
//
//class Summer extends Seasons {
//    public final String getName () {
//        return "summer";
//    }
//
//    public final boolean isCold () {
//        return false;
//    }
//}
//
//class Autumn extends Seasons {
//    public final String getName () {
//        return "autumn";
//    }
//
//    public final boolean isCold () {
//        return true;
//    }
//}
//
//class Solution2 {
//    public void reverseString (char[] s) {
//        int left = 0;
//        int right = s.length - 1;
//
//        while (left < right) {
//            char temp = s[left];
//            s[left] = s[right];
//            s[right] = temp;
//
//            left ++;
//            right --;
//        }
//    }
//    public static void main (String[] args) {
//        Solution2 solution2 = new Solution2();
//        char[] s = new char[] {'a', 'p', 'p', 'l', 'e'};
//        System.out.println(s);
//        solution2.reverseString(s);
//        System.out.println(s);
//    }
//}
//
//class Solution3 {
//    public String reverseWords (String s) {
//        StringBuilder sb = new StringBuilder();
//        String[] a = s.split(" ");
//        int n = a.length;
//        for(int i  = 0;i < n;i++){
//            StringBuilder sb1 = new StringBuilder(a[i]);
//            sb1.reverse();
//            sb.append(sb1.toString());
//            if(i != n-1){
//                sb.append(" ");
//            }
//            sb1.setLength(0);
//        }
//        return sb.toString();
//    }
//
//    public static void main (String[] args) {
//        Solution3 solution3 = new Solution3();
//        System.out.println(solution3.reverseWords("hi me apple"));
//    }
//}


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

//        QuadSummator quadSummator = new QuadSummator();
//        System.out.println(quadSummator.sumQuads(3));
    }
}
