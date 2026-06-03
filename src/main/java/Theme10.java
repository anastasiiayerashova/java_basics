import java.util.Arrays;

public class Theme10 {
}

class Test1 {
    public Test1() {
        System.out.println("Hello");
    }

    public static void main(String[] args) {
        new Test1();
    }
}

class Person1 {
    public Person1 (String name) {
        System.out.println("Name is " + name);
    }
    public Person1 (String firstName, String lastName) {
        System.out.println("First name is " + firstName + ", last name is " + lastName);
    }
    public static void main (String[] args) {
        new Person1("Elon");
        new Person1("Elon", "Musk");
    }
}

//class Shape1 {
//    private String name;
//    public Shape1(String name) {
//        this.name = name;
//        System.out.println("Call in Shape1");
//    }
//}
//
//class Circle1 extends Shape1 {
//    private float radius;
//    public Circle1 (float radius) {
//        super("Circle1");
//        this.radius = radius;
//        System.out.println("Call in Circle1");
//    }
//}
//
//class Launcher {
//    public static void main(String[] args) {
//        new Circle1(5);
//    }
//}
//
//class SpaceObject1 {
//    public SpaceObject1() {
//        System.out.println("Space Object1 Constructor");
//    }
//}
//
//class Star extends SpaceObject1 {
//    public Star() {
//        System.out.println("Star Constructor");
//    }
//}
//
//class Launcher1 {
//    public static void main(String[] args) {
//        new Star();
//    }
//}


class Shape1 {
    private String name;
    public Shape1 (String name) {
        this.name = name;
        System.out.println("Shape: " + name);
    }
}

class Circle1 extends Shape1 {
    private float radius;
    public Circle1 (float radius) {
        if (radius <= 0){
            throw new IllegalArgumentException("Радіус має бути > 0");
        }
        super("Circle15");
        this.radius = radius;
        System.out.println("Call in Circle" + " " + this.radius);
    }
}

class Launcher {
    public static void main (String[] args) {
        new Circle1(5);
    }
}

class User {
    private boolean admin;
    private String name;

    public User (String name) {
        this(name, false);
    }

    public User (String name, boolean admin) {
        this.name = name;
        this.admin = admin;
        System.out.println("Name is " + name + ", is admin: " + admin);
    }
}

class Launcher1 {
    public static void main (String[] args) {
        new User("Max");
        new User("Max", true);
    }
}

class Rocket1 {
    {
        System.out.println("Ready...");
    }
    {
        System.out.println("Set...");
    }
    {
        System.out.println("Init rocket1 in init block");
    }
    public Rocket1() {
        System.out.println("Init rocket1 in constructor");
    }
}

class RocketLauncher1 {
    public static void main(String[] args) {
        new Rocket1();
    }
}

class Database {
    public Database() {}
    static {
        System.out.println("Init connection");
    }
}

class DatabaseTest {
    public static void main (String[] args) {
        new Database();
        new Database();
    }
}


class Parent {
    public Parent() {
        System.out.println("Parent Constructor");
    }
    static {
        System.out.println("Parent static block");
    }
    {
        System.out.println("Parent initialisation  block");
    }
}

class Child extends Parent {
    {
        System.out.println("Child initialisation block");
    }
    static {
        System.out.println("Child static block");
    }
    public Child() {
        System.out.println("Child Constructor");
    }
    public static void main (String[] args) {
        new Child();
    }
}


class ExTest {
    private static void divide(int a, int b) {
        try {
            System.out.println(a / b);
        }
        catch (ArithmeticException e) {
            System.out.println("Не можна ділити на нуль");
        }
        finally {
            System.out.println("Завжди буде виводитися");
        }
    }
    public static void main(String[] args) {
        divide(1, 0);
        divide(1, 1);
    }
}


//class Main1 {
//
//    public static void main(String[] args) {
//        divide(1, 0);
//    }
//
//    private static void divide(int a, int b) {
//        try {
//            System.out.println(a / b);
//        } catch (ArithmeticException e) {
//            throw new IllegalZeroDivideException();
//        }
//    }
//}
//
//class IllegalZeroDivideException extends RuntimeException {
//    IllegalZeroDivideException() {
//        super("Ви намагаєтесь поділити на 0!");
//    }
//}

class Main1 {

    public static void main(String[] args) throws IllegalZeroDivideException {
        divide(1, 0);
    }

    private static void divide(int a, int b) throws IllegalZeroDivideException {
        try {
            System.out.println(a / b);
        } catch (ArithmeticException e) {
            throw new IllegalZeroDivideException();
        }
    }
}

class IllegalZeroDivideException extends Exception {
    IllegalZeroDivideException() {
        super("Ви намагаєтесь поділити на 0!");
    }
}


class Hero {
    public String name;
    public int hp;

    public Hero() {
        this.name = "Paratrooper";
        this.hp = 100;
    }

    public String getName() {
        return this.name;
    }

    public int getHp() {
        return this.hp;
    }
}

class HeroTest {
    public static void main(String[] args) {
        Hero hero = new Hero();

        //Expect Paratrooper
        System.out.println(hero.getName());

        //Expect 100
        System.out.println(hero.getHp());
    }
}


class BFG {
    private int ammo;
    private int damage;
    private String name;

    public int getAmmo() {
        return this.ammo;
    }
    public int getDamage() {
        return this.damage;
    }
    public String getName() {
        return this.name;
    }

    public BFG(int ammo, int damage, String name) {
        this.ammo = ammo;
        this.damage = damage;
        this.name = name;
    }

    public BFG(int ammo, int damage) {
        this(ammo, damage, "BFG");
    }

    public BFG(int ammo) {
        this(ammo, 50, "BFG");
    }

    public BFG() {
        this(1000, 50, "BFG");
    }

    @Override
    public String toString() {
        return this.name + ", ammo: " + this.ammo + ", damage: " + this.damage;
    }
}

class BfgTest {
    public static void main(String[] args) {
        //ExtraGun, ammo: 10000, damage: 300
        System.out.println(new BFG(10000, 300, "ExtraGun"));

        //BFG, ammo: 5000, damage: 200
        System.out.println(new BFG(5000, 200));

        //BFG, ammo: 2000, damage: 50
        System.out.println(new BFG(2000));

        //BFG, ammo: 1000, damage: 50
        System.out.println(new BFG());

    }
}


class PowTable {
    public static final int[] POWERS_2;

    static {
        POWERS_2 = new int[10];
        for (int i = 0; i < POWERS_2.length; i++) {
            int number = i + 1;
            POWERS_2[i] = number * number;
        }
    }
}

class PowTableTest {
    public static void main(String[] args) {
        //[1, 4, 9, 16, 25, 36, 49, 64, 81, 100]
        System.out.println(Arrays.toString(PowTable.POWERS_2));
    }
}


class Distance {
    private int startX;
    private int startY;
    private int endX;
    private int endY;

    public Distance(int startX, int startY, int endX, int endY) {
        this.startX = startX;
        this.startY = startY;
        this.endX = endX;
        this.endY = endY;
    }

    public int getDistance() {
        double deltaX = this.startX - this.endX;
        double deltaY = this.startY - this.endY;

        double distance = Math.sqrt(deltaX * deltaX + deltaY * deltaY);

        return (int) Math.round(distance);
    }
}

class DistanceTest {
    public static void main(String[] args) {
        //Expect 14
        System.out.println(new Distance(10, 10, 20, 20).getDistance());

        //Expect 23
        System.out.println(new Distance(10, 10, 27, 25).getDistance());
    }
}


class TargetFinder {
    public int[] findTarget(int[] aiCoords, int[][] targets) {
        // Якщо цілей немає, повертаємо порожній масив або null
        if (targets == null || targets.length == 0) {
            return new int[0];
        }

        // Початково вважаємо першу ціль найближчою
        int[] closestTarget = targets[0];
        long minSquaredDistance = getSquaredDistance(aiCoords, targets[0]);

        // Перебираємо всі інші цілі, починаючи з індексу 1
        for (int i = 1; i < targets.length; i++) {
            long currentSquaredDistance = getSquaredDistance(aiCoords, targets[i]);

            // Якщо знайшли ціль, яка ближче, оновлюємо дані
            if (currentSquaredDistance < minSquaredDistance) {
                minSquaredDistance = currentSquaredDistance;
                closestTarget = targets[i];
            }
        }

        return closestTarget;
    }

    // Допоміжний метод для обчислення КВАДРАТА відстані між двома точками
    private long getSquaredDistance(int[] p1, int[] p2) {
        long deltaX = p2[0] - p1[0];
        long deltaY = p2[1] - p1[1];
        return deltaX * deltaX + deltaY * deltaY;
    }
}

class TargetFinderTest {
    public static void main(String[] args) {
        int[] aiCoords = {10, 10};
        int[][] targets = {
                {20, 20},
                {15, 14},
                {30, 5}
        };

        TargetFinder targetFinder = new TargetFinder();
        int[] nearestTarget = targetFinder.findTarget(aiCoords, targets);

        // Виведе у консоль: [15, 14]
        System.out.println(Arrays.toString(nearestTarget));
    }
}

class LevelLoader {
    private static LevelLoader instance = new LevelLoader();

    public String load(String levelName) {
        return "Loading level " + levelName + " ...";
    }

    public static LevelLoader getInstance() {
        return instance;
    }
}

class LevelLoaderTest {
    public static void main(String[] args) {
        //Loading level Startlevel ...
        System.out.println(LevelLoader.getInstance().load("StartLevel"));
    }
}

class TexturePool {
    // 1. Створюємо єдиний статичний екземпляр класу
    private static final TexturePool instance = new TexturePool();

    // 2. Закриваємо конструктор (тепер new TexturePool() ззовні не скомпілюється)
    private TexturePool() {}

    // 3. Глобальна точка доступу до цього єдиного об'єкта
    public static TexturePool getInstance() {
        return instance;
    }

    public String getTexture(String textureName) {
        return "Get texture " + textureName;
    }
}

class TexturePoolTest {
    public static void main(String[] args) {
        // Виведе у консоль: Get texture MainHero
        System.out.println(TexturePool.getInstance().getTexture("MainHero"));

        // Перевірка: чи повертається один і той самий об'єкт (виведе true)
        System.out.println(TexturePool.getInstance() == TexturePool.getInstance());

        // Код нижче не скомпілюється, якщо його розкоментувати (як і вимагає завдання):
        // TexturePool pool = new TexturePool(); // Помилка: TexturePool() has private access
    }
}

class AvgDamageCalculator {
    public int calculateAvg(int[] samples) {
        try {
            int sum = 0;
            for(int sampleValue: samples) {
                sum += sampleValue;
            }

            return sum / samples.length;
        }
        catch (ArithmeticException e) {
            return 0;
        }
    }
}

class AvgDamageCalculatorTest {
    public static void main(String[] args) {
        //5
        System.out.println(new AvgDamageCalculator().calculateAvg(new int[] {2, 4, 6, 8}));

        //0
        System.out.println(new AvgDamageCalculator().calculateAvg(new int[0]));
    }
}


class ArrayWorker {
    public void printElement(int[] array, int index) {
        try {
            System.out.println("value is " + array[index]);
        }
        catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("wrong index");
        }
        finally {
            System.out.println("index is " + index);
        }
    }
}


class TotalScore {
    public int sum(int[] scores) {
        int result = 0;
        int index = 0;

        while(index < scores.length) {
            result += scores[index++];
        }

        return result;
    }
}

class TotalScoreTest {
    public static void main(String[] args) {
        int[] score = {10, 20, 100};

        //130
        System.out.println(new TotalScore().sum(score));
    }
}

class ArrayWorkerTest {
    public static void main(String[] args) {
        int[] array = {1, 2, 3};

        //value is 1
        //index is 0
        new ArrayWorker().printElement(array, 0);

        //wrong index
        //index is 10
        new ArrayWorker().printElement(array, 10);
    }
}


class Level {
    private int width;
    private int height;

    public Level(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}

class LevelLoader1 {
    // Метод тепер перевіряє площу рівня перед завантаженням
    public void load(Level level) throws LevelTooBigException {
        // Рахуємо площу рівня (ширина * висота)
        // Використовуємо long, щоб уникнути переповнення int при множенні великих чисел
        long area = (long) level.getWidth() * level.getHeight();

        // Якщо площа більша за 100 000 — кидаємо виняток
        if (area > 100000) {
            throw new LevelTooBigException();
        }

        // Якщо все добре — завантажуємо
        System.out.println("Level loaded");
    }
}

// Перевіряємий (checked) виняток
class LevelTooBigException extends Exception {
    public LevelTooBigException() {
        super("Level too big");
    }
}

class LevelLoaderTest1 {
    public static void main(String[] args) {
        // Тест 1: площа 10 * 20 = 200 (менше 100 000). Виведе: Level loaded
        try {
            new LevelLoader1().load(new Level(10, 20));
        } catch (LevelTooBigException ex) {
            System.out.println("Level too big");
        }

        // Тест 2: площа 10000 * 2000 = 20 000 000 (більше 100 000). Виведе: Level too big
        try {
            new LevelLoader1().load(new Level(10000, 2000));
        } catch (LevelTooBigException ex) {
            System.out.println("Level too big");
        }
    }
}







