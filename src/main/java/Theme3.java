// Введення/виведення через консоль
import java.util.Scanner;
import java.util.Arrays;
import java.util.*;

public class Theme3 {
    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//
//        System.out.print("Input name: ");
//        String name = in.nextLine();
//
//        System.out.print("Input age: ");
//        int age = in.nextInt();
//
//        System.out.print("Input height: ");
//        float height = in.nextFloat();
//
//        System.out.println("Name: " + name + "  Age: " + age + "  Height: " + height);
//        in.close();


        // Масиви

        // Ініціалізація масиву
        int[] months = new int[12];
        int[] planets;
        planets = new int[9];

        // Ініціалізація масиву з наповненням значеннями
        int[] prices = {100, 999, 799}; // не використовували оператор new, тому що ми одразу вказали вміст масиву

        // Запис елемента за індексом
        float[] weights = new float[3];
        weights[0] = 1f;
        weights[1] = 5f;
        weights[2] = 7f;

        // Читання елемента за індексом
        byte[] kilobyte = new byte[1024];
        byte firstByte = kilobyte[0];

        // Довжина масиву, 2 147 483 647 - це максимальна довжина масиву
        boolean[] lights = {true, false, true};
        int lightCount = lights.length;

        // Останній елемент масиву
        char[] letters = {'a', 'b', 'c'};
        char lastLetter = letters[letters.length - 1];

        // Багатовимірні масиви
        char[][] chessboard = new char[8][8];
        chessboard[0][0] = 'k';
//        System.out.println(chessboard[0][0]);

        // Копіювання масиву
        int[] arrSource = {1, 2, 3, 4, 5};
        int[] arrTarget = Arrays.copyOf(arrSource, arrSource.length);
        arrSource[0] = 10;
        System.out.println(arrTarget[0]);
        System.out.println(Arrays.toString(arrTarget));

//      int[] arrTargetSecond = new int[arrSource.length];
//      System.arraycopy(arrSource, 0, arrTargetSecond, 0, arrSource.length);

//      int[] arrTargetSecond = new int[3];
//      System.arraycopy(arrSource, 1, arrTargetSecond, 0, 3);
//      System.out.println(Arrays.toString(arrTargetSecond));
    }
}

// Умовний оператор if, else, if else
// Guard clause

class Example {
    public static void main (String[] args) {
        int finalPrice = calculateFinalPrice(100, true, false);
        System.out.println(finalPrice);

        int anotherPrice = anotherMethod(100, true, false);
        System.out.println(anotherPrice);
    }
        public static int calculateFinalPrice (int price, boolean isOutlet, boolean isBlackFriday) {
            int result = price;
            if (isBlackFriday) {
                result = price / 2;
            }
            else {
                if (isOutlet) {
                    result = price * 9 / 10;
                }
                else {
                    result = price;
                }
            }
            return result;
        }

        public static int anotherMethod (int price, boolean isOutlet, boolean isBlackFriday) {
        if (isBlackFriday) return price / 2;
        if (isOutlet) return price * 9 / 10;
        return price;
        }
    }

// Тернарний оператор

class ExampleTwo {
    public static void main (String[] args) {
        System.out.println(checkAccess(20));
        System.out.println(getEvenOrOdd(20));
        System.out.println(max(20, 50));
        System.out.println(maxFrom3(20, 50, 55));
        System.out.println(exampleSC(0));
        System.out.println(numLettersMethod("TUESDAY"));
        System.out.println(formatter(2));
    }

    public static String checkAccess (int age) {
        String accessAllowed = age >= 18 ? "yes" : "no";
        return accessAllowed;
    }

    public static String getEvenOrOdd (int num) {
        return num % 2 == 0 ? "even" : "odd";
    }

    public static int max (int a, int b) {
        return a > b ? a : b;
    }

    public static int maxFrom3 (int a, int b, int c) {
        int max = a > b ? a : b;
        return max > c ? max : c;
    }

    public static String exampleSC (int digit) {
        String whatDigit = "";

        switch (digit) {
            case 0:
                whatDigit = "zero";
                break;
            case 1:
                whatDigit = "one";
                break;
        }
        return whatDigit;
    }

    public static int numLettersMethod (String word) {
        int numLetters = switch (word) {
            case "MONDAY", "FRIDAY", "SUNDAY" -> 6;
            case "TUESDAY" -> 7;
            case "THURSDAY", "SATURDAY" -> 8;
            case "WEDNESDAY" -> 9;
            default -> 0;
        };
        return numLetters;
    }

    public static String formatter (Object obj) {
        return switch (obj) {
            case Integer i -> "Це ціле число: " + i;
            case String s -> "Це рядок довжини: " + s.length();
            case null -> "null";
            default -> "Невідомий тип";
        };
    }
}

class MoonComputerTests {
    public void testBasicInputOutput() {
        Scanner scanner = new Scanner(System.in);

        String phrase = scanner.nextLine();
        System.out.println(phrase);

        scanner.close();
    }

    public void testMath() {
        Scanner scanner = new Scanner(System.in);

        int first = scanner.nextInt();
        int second = scanner.nextInt();
        System.out.println((first + second) + " " + (first - second) + " " + (first * second) + " " + (first / second));

        scanner.close();
    }

    public void testLogicalOperators() {
        Scanner scanner = new Scanner(System.in);

        boolean a = scanner.nextBoolean();
        boolean b = scanner.nextBoolean();
        boolean c = scanner.nextBoolean();
        boolean resultOne = a || b || c;
        boolean resultSecond = a && b && c;

        System.out.println(resultOne + " " + resultSecond);

        scanner.close();
    }

    public static void main(String[] args) {
//      MoonComputerTests computerTests = new MoonComputerTests();
//      computerTests.testBasicInputOutput();

//      new MoonComputerTests().testMath();
//      new MoonComputerTests().testLogicalOperators();
    }
}

class PassportFormCreator {
    public void createForms() {
        Scanner scanner = new Scanner(System.in);

        String name = scanner.next();
        String lastName = scanner.next();
        String ageInput = scanner.next();

        int age = 0;

        try {
            age = Integer.parseInt(ageInput);
        }
        catch (NumberFormatException e) {
            age = 0; // если не число — считаем возраст 0
        }

        System.out.println(name + " " + lastName + " " + (age * 10));
        System.out.println(name.toUpperCase());
        System.out.println(lastName.toUpperCase());
        System.out.println(age * 10);

        scanner.close();
    }

//    public static void main (String[] args) {
//        new PassportFormCreator().createForms();
//    }
}

class HarekCity {
    public String[] createEmptyNameArray() {
        String[] result = new String[0]; // инициализация пустого массива строк
        return result;
    }

    public int[] createAgeArray(int age1, int age2, int age3, int age4) {
        int[] result = {age1, age2, age3, age4};
        return result;
    }

    public void fixNames(String[] names, String[] toReplace) {
        names[1] = toReplace[0];
        names[3] = toReplace[1];
    }

    public String firstAndLastTogether(String[] names) {
        String result = names[0] + " AND " + names[names.length - 1] + " TOGETHER";
        return result;
    }

    public void changeElectResult(String[] results) {
        String temp = results[0];
        results[0] = results[results.length - 1];
        results[results.length - 1] = temp;
    }

    public String[] changeElectResultAgain(String[] results) {
        String[] newArray = new String[3];
        System.arraycopy(results, 2, newArray, 0, 3);
        return newArray;
    }

    public char[][] createKeyboard() {
        char[][] newArray = {
                {'1', '2', '3'},
                {'4', '5', '6'},
                {'7', '8', '9'},
                {'*', '0', '#'}
        };
        return newArray;
    }

    public void printKeyboard() {
        char[][] result = createKeyboard();
        System.out.println(Arrays.toString(result[0]));
        System.out.println(Arrays.toString(result[1]));
        System.out.println(Arrays.toString(result[2]));
        System.out.println(Arrays.toString(result[3]));
    }

    public String[] makeCopy(String[] names) {
        String[] newArray = Arrays.copyOf(names, names.length);
        System.out.println("Copied!");
        return newArray;
    }

    public static void main(String[] args) {
        String[] arr = new HarekCity().createEmptyNameArray();
        System.out.println(Arrays.toString(arr));

        int[] ageArray = new HarekCity().createAgeArray(1, 2, 3, 4);
        System.out.println(Arrays.toString(ageArray));

        String[] names = new String[]{"mixa", "ukio", "barek", "krou", "fiha"};
        String[] toReplace = new String[]{"lopr", "boki"};
        new HarekCity().fixNames(names, toReplace);
        System.out.println(Arrays.toString(names));

        String[] names2 = new String[]{"io", "pu", "re", "max", "kok", "mis", "hit", "kio", "pax", "rew"};
        System.out.println(new HarekCity().firstAndLastTogether(names2));

        String[] results = new String[]{"miho", "hut"};
        new HarekCity().changeElectResult(results);
        System.out.println(Arrays.toString(results));

        String[] results2 = new String[]{"mix", "max", "pex", "fux", "rox"};
        String[] changedResults = new HarekCity().changeElectResultAgain(results2);
        System.out.println(Arrays.toString(changedResults));

//        char[][] keyboard = new HarekCity().createKeyboard();
//        for (int i = 0; i < keyboard.length; i++) {
//            System.out.println(Arrays.toString(keyboard[i]));
//        }

//        new HarekCity().printKeyboard();

        String[] source = new String[] {"Hero", "Mihu"};
        String[] copy = new HarekCity().makeCopy(source);

        source[0] = "CHANGED!"; //Мы меняем исходный массив, но на копии это не отображается

        System.out.println(Arrays.toString(copy));
    }
}

class HarekDataMaker {
    public String aggregateSingle(String name, String age, String planet) {
        return "name - " + name + "," + " age - " + age + "," + " planet - " + planet;
    }

//    public String[] aggregateAll(String[] names, int[] ages, String[] planets) {
//        String[] newArray = new String[3];
//        String newLine = aggregateSingle(names[0], Integer.toString(ages[0]), planets[0]);
//        String newLine1 = aggregateSingle(names[1], Integer.toString(ages[1]), planets[1]);
//        String newLine2 = aggregateSingle(names[2], Integer.toString(ages[2]), planets[2]);
//        newArray[0] = newLine;
//        newArray[1] = newLine1;
//        newArray[2] = newLine2;
//        return newArray;
//    }

    public String[] aggregateAll(String[] names, int[] ages, String[] planets) {
        String[] result = new String[names.length];
        for (int i = 0; i < names.length; i++) {
            result[i] = aggregateSingle(names[i], Integer.toString(ages[i]), planets[i]);
        }
        return result;
    }

    public static void main (String[] args) {
        String[] names = new String[] {"hter", "pou", "diz"};
        int[] ages = new int[] {30, 35, 70};
        String[] planets = new String[] {"Mars", "Earth", "Jupiter"};

        HarekDataMaker harekDataMaker = new HarekDataMaker();
        System.out.println(harekDataMaker.aggregateSingle(names[0], Integer.toString(ages[0]), planets[0]));
        System.out.println("###");

        System.out.println(Arrays.toString(harekDataMaker.aggregateAll(names, ages, planets)));
    }
}

class SaveStarShip {
    public int calculateDistance(int distance) {
        return distance < 0 ? -distance : distance;
    }

    public String[] getPlanets (String name) {
        String[] result1 = new String[] {"Fobius", "Demius"};
        String[] result2 = new String[] {"Earth", "Mars", "Jupiter"};
        String[] result3 = new String[] {"Maux", "Reux", "Piax"};
//        switch (name) {
//            case "DangerBanger":
//                return result1;
//            case "Milkyway":
//                return result2;
//            case "Miaru":
//                return result3;
//        }
//        return new String[] {};

        if (name.equals("DangerBanger")) {
            return result1;
        }
        if (name.equals("Milkyway")) {
            return  result2;
        }
        if (name.equals("Miaru")) {
            return result3;
        }
        return new String[] {};
    }

    public String choosePlanet(long distanceToEarth) {
        if (distanceToEarth < 45677) {
            return "Earth";
        }
        else {
            return "Pern";
        }
    }

    public int calculateFuelPrice(String fuel, int count) {
        int price = 50;

        if (fuel.equals("STAR100")) {
            price = 70;
        }
        else if (fuel.equals("STAR500")) {
            price = 120;
        }
        else if (fuel.equals("STAR1000")) {
            price = 200;
        }
        return price * count;
    }

    public int roundSpeed(int speed) {
        return Math.round(speed / 10.0f) * 10;
    }

    public int calculateNeededFuel(int distance) {
        int fuel = 1000;
        if (distance <= 20) {
            return fuel;
        }
        else {
            fuel = 1000 + (distance - 20) * 5;
        }
        return fuel;
    }

    public void calculateMaxPower() {
        Scanner scanner = new Scanner(System.in);
        float one = scanner.nextFloat();
        float two = scanner.nextFloat();
        float three = scanner.nextFloat();

        float maxPower = Math.max(one, (Math.max(two, three)));
        float coefficient;

        if (maxPower < 10) {
            coefficient = 0.7f;
        }
        else if (maxPower <= 100 && maxPower >= 10) {
            coefficient = 1.2f;
        }
        else {
            coefficient = 2.1f;
        }
        float result = maxPower * coefficient;
        System.out.println(result);
        scanner.close();
    }

    public String getMyPrizes(int ticket) {
        String result = "";

        if (ticket % 10 == 0) {
            result += "crystall";
        }
        if (ticket % 10 == 7) {
            if (!result.isEmpty()) {
                result += " ";
            }
            result += "chip";
        }
        if (ticket > 200) {
            if (!result.isEmpty()) {
                result += " ";
            }
            result += "coin";
        }

        return result;
    }

    public boolean isHangarOk(int side1, int side2, int price) {
        int area = side1 * side2;
        int bigger = Math.max(side1, side2);
        int smaller = Math.min(side1, side2);
        return area >= 1500 && bigger <= smaller * 2 && price <= area * 1000;
    }

    public static void main(String[] args) {
        SaveStarShip ship = new SaveStarShip();

        System.out.println(ship.calculateDistance(-10));
        System.out.println(Arrays.toString(ship.getPlanets("DangerBanger")));
        System.out.println(ship.choosePlanet(10));
        System.out.println(ship.calculateFuelPrice("STAR100", 10));
        System.out.println(ship.roundSpeed(55));
        System.out.println(ship.calculateNeededFuel(63));
//        ship.calculateMaxPower();
        System.out.println(ship.getMyPrizes(390));
        System.out.println(ship.isHangarOk( 60, 104, 9516000));
    }
}

class QuadraticEquationSolver {
    public double[] solve(int a, int b, int c) {
        double discriminant = Math.pow(b, 2) - 4 * a * c;

        if (discriminant > 0) {
            double firstX = (-b + Math.sqrt(discriminant)) / (2 * a);
            double secondX = (-b - Math.sqrt(discriminant)) / (2 * a);
            return new double[]{firstX, secondX};
        }
        if (discriminant == 0) {
            double x = -(b / 2 * a);
            return new double[]{x};
        }
        return new double[]{};
    }

    public static void main (String[] args) {
        QuadraticEquationSolver solver = new QuadraticEquationSolver();
        System.out.println(Arrays.toString(solver.solve(9, -63, 54)));
    }
}

class CaptainDispute {
    public String evenOrOdd(int number) {
        return number % 2 == 0 ? "even" : "odd";
    }

    public static void main(String[] args) {
        CaptainDispute captainDispute = new CaptainDispute();
        System.out.println(captainDispute.evenOrOdd(10));
        System.out.println(captainDispute.evenOrOdd(5));
    }
}

class CaptainDisputeAgain {
    public int findMin(int[] triple) {
        int max = triple[0] < triple[1] ? triple[0] : triple[1];

        return max < triple[2] ? max : triple[2];
    }

    public static void main (String[] args) {
        CaptainDisputeAgain captainDisputeAgain = new CaptainDisputeAgain();
        System.out.println(captainDisputeAgain.findMin(new int[] {1, 10, 3}));
    }
}

class NumberTranslator {
    public int translate(String romanNumber) {
        String cleanData = romanNumber.strip().toUpperCase();
        switch (cleanData) {
            case ("I"):
                return 1;
            case ("II"):
                return 2;
            case ("III"):
                return 3;
            case ("IV"):
                return 4;
            case ("V"):
                return 5;
            case ("VI"):
                return 6;
            case ("VII"):
                return 7;
            case ("VIII"):
                return 8;
            case ("IX"):
                return 9;
            case ("X"):
                return 10;
            case ("XI"):
                return 11;
            case ("XII"):
                return 12;
        }
        return -1;
//        return switch (cleanData) {
//            case "I" -> 1;
//            case "II" -> 2;
//            case "III" -> 3;
//            case "IV" -> 4;
//            case "V" -> 5;
//            case "VI" -> 6;
//            case "VII" -> 7;
//            case "VIII" -> 8;
//            case "IX" -> 9;
//              case "X" -> 10;
//              case "XI" -> 11;
//              case "XII" -> 12;
//            default -> -1;
//        };

    }

    public static void main (String[] args) {
        NumberTranslator numberTranslator = new NumberTranslator();
        System.out.println(numberTranslator.translate("vi"));
    }
}
