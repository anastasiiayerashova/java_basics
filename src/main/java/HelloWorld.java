public class HelloWorld {
    public static void main (String[] args) {
        System.out.println("  *  ");
        System.out.println(" *** ");
        System.out.println("*****");

        // Цілочисельні типи даних
        byte age = 18; // Діапазон значень – від -128 до 127
        short year = 2020; // Діапазон значень - від -32768 до 32767
        int userCount = 450000; // Діапазон значень - від -2147483648 до 2147483647
        long veryLongVariable = 223372036854L; // Діапазон значень – від –9 223 372 036 854 775 808 до 9 223 372 036 854 775 807

        // Числа з плаваючою комою
        float length = 50f; // Діапазон значень - від -3.4*1038 до 3.4*1038
        float weight = 3.5f;
        double x = 50.0; // Діапазон значень - від ±4.9*10-324 до ±1.8*10308

        // Особливості запису чисел
        long y = 50;
        long value = 100l;
        long anotherValue = 100L;

        float u = 5;
        float r = 5.0f;

        // Системи числення
        int valueOne = 015; // У десятковій системі значення це буде 13
        int valueTwo = 0xA; // У десятковій системі це буде 10
        int valueThree = 0b11; // У десятковій системі це буде 3

        // Символьний тип char
        char letter = 'x';
        char bigLetter = 'A';
        char unicodeExample = '\u0000';

        // Тип даних boolean
        boolean winterIsComing = true;
        boolean sunIsCold = false;

        long a = 1L;
        Integer b = Integer.parseInt("12");
        Boolean c = Boolean.FALSE;
        System.out.println(a + b);

        // Математичні оператори
        int change = 200 - 173;

        // Оператор присвоєння
        int appleCount = 3;
        int bananaCount = 5 + 6;
        int totalFruitCount = appleCount + bananaCount;

        // Бінарні оператори +, -, *, /
        int i = 7 / 4; // Буде 1, тому що від результату 1.75 відкинеться дробова частина

        int m = 1;
        int o = 2 + ++m; // Змінна o дорівнюватиме 4, змінна m - 2

        int q = 1;
        int w = 2 + q++; // Змінна b дорівнюватиме 3, змінна a - 2

        // Оператори віднімання і додавання з присвоєнням
        int kiwiCount = 5;
        kiwiCount += 2;
        int totalCount = 10;
        totalCount -= kiwiCount;

        // Залишок від ділення
        int notDistributedItems = 5 % 3; // Буде 2 - тому що 5 поділити на 3 буде 1, і залишок - 2
        int e = 10;
        int rest = e % 2;

        // Оператори порівняння
        int firstYear = 2020;
        int secondYear = 2020;
        boolean theSameYear = firstYear == secondYear;
        boolean isNotTheSameYear = firstYear != secondYear;

        // Оператори більше і менше >, >=, <, <=

        // Логічні оператори ||, &&, ^, !, &, |

        // Перетворення примітивних типів даних
        byte newAge = 18;
        int newIntAge = newAge; // Неявне приведення змінної newAge до потрібного типу - int

        // Тип даних String, Порівняння рядків
        String myName = "Anastasia";
        String anotherExample = new String("Anastasia");
        boolean isNameTheSame = myName.equals(anotherExample);
        // equalsIgnoreCase() порівнює рядки без врахування регістру

        // Довжина рядка
        int nameLength = myName.length();

        // Конкатенація
        String firstName = "Elon";
        String lastName = "Musk";
        String fullName = firstName + " " + lastName;
        String languageAndYear = "Java " + 1996;

        // Методи у рядків

        // Верхній та нижній регістри
        String phrase = "Back to the future";
        System.out.println(phrase.toUpperCase());
        System.out.println(phrase.toLowerCase());
        System.out.println("ivan".toUpperCase());

        // Чи є в рядку інший рядок
        String phraseTwo = "Java is great language";
        String word = "java";
        boolean phraseContainsWord = phraseTwo.toLowerCase().contains(word.toLowerCase());

        // З'єднання рядків
        String result = String.join(",", "apple", "kiwi", "pineapple");
        System.out.println(result);

        // Індекс символу
        String language = "spanish";
        char thirdChar = language.charAt(2);

        // Починається або закінчується рядок іншим рядком: методи startsWith() та endsWith()

        // Чи порожній рядок
        System.out.println("".isEmpty());
        System.out.println(" ".isEmpty());
        System.out.println("".isBlank()); // true
        System.out.println(" ".isBlank()); // true
        System.out.println("java".isBlank()); // false

        // Заміна підрядка, Замінюються всі входження
        String replaced = "my name is Ivan".replace("Ivan", "Anastasia");
        String source = "never never never";
        String replace = source.replace("n", ""); //Буде ever ever ever

        // Чищення рядка від стартових та фінальних пробілів
        System.out.println(" java ".trim());//java - пробіли видаляться
        String lang = "\\njava          \\n"; //Тут є два перенесення рядка і багато пробілів
        String cleanLang = lang.strip(); //java - все зайве видалиться на початку і наприкінці

        // Отримати підрядок
        System.out.println("pineapples".substring(4, 9));
        var item = (String) null;
        String itemTwo = null;
    }
}

// Область видимості класу

class MyClass {
    public static final String NAME = "John Doe";

    public static void main(String[] args) {
        System.out.println(NAME);
    }
}

// Область видимості методу

class MySecondClass {
    public static void main (String[] args) {
        methodA();
    }

    public static void methodA() {
        String name = "John Doe";
        System.out.println(name);
    }
//    public static void methodB() {
//        System.out.println(name);  // not ok
//    }
}

// Оголошення свого блоку видимості
// змінні name - різні для різних областей видимості, мають різні значення

class MyThirdClass {
    public static void main (String[] args) {
        {
            String name = "John Doe";
            System.out.println(name);
        }
        {
            String name = "Billy Star";
            System.out.println(name);
        }
    }
}

// Наслідування областей видимості змінних

class MyFourthClass {
    public static void main (String[] args) {
        String name = "Billy Star";

        {
            System.out.println(name);
        }
    }
}

class MathUtils {
    public int sum(int a, int b) {
        return a + b;

    }

    public int sub (int a, int b) {
        return a - b;
    }

    public float twice (float number) {
        return number / 0.50f;
    }

    public int twicedSum (int a, int b) {
        return sum(a, b) * 2;
    }

    public static void main(String[] args) {
        MathUtils math = new MathUtils();
        System.out.println("math.sum(3, 2) = " + math.sum(3, 2));
        System.out.println("math.sub(3, 2) = " + math.sub(3, 2));
        System.out.println("math.twice(7f) = " + math.twice(2f));
        System.out.println("math.twicedSum(2, 3) = " + math.twicedSum(2, 3));
    }
}

class MarsCalculator {
    public int sum(int a, int b, int c) {
        return a + b + c;
    }

    public int sub(int a, int b, int c) {
        return a - b - c;
    }

    public int multiply(int a, int b, int c) {
        return sum(a, b, c) * sub(a, b, c);
    }

    public float divide(int a, int b, int c) {
        return sum(a, b, c) / 10f;
    }
    public static void main (String[] args) {
        MarsCalculator calculator = new MarsCalculator();
        System.out.println(calculator.divide(1, 2, 3));
    }
}

class Counter {
    public long current(long number) {
        return number;
    }

    public long next(long number) {
        number ++;
        return number;
    }

    public long prev(long number) {
        number --;
        return number;
    }

    public static void main() {
        Counter newCounter = new Counter();
        System.out.println(newCounter.current(5));
        System.out.println(newCounter.next(5));
        System.out.println(newCounter.prev(5));
    }
}

class BrokenKeyboardCalculator {
    public int add(int a, int b) {
        a += b;
        return a;
    }

    public int sub(int a, int b) {
        a -= b;
        return a;
    }

    public int multiply(int a, int b) {
        a *= b;
        return a;
    }

    public int divide(int a, int b) {
        a /= b;
        return a;
    }

    public static void main (String[] args) {
        BrokenKeyboardCalculator broken = new BrokenKeyboardCalculator();
        System.out.println(broken.divide(2, 2));
    }
}

class DigitSplitter {
    public int getFirstDigit(int number) {
        return number / 10;
    }

    public int getSecondDigit(int number) {
        return number % 10;
    }

    public static void main (String[] args) {
        DigitSplitter splitter = new DigitSplitter();
        System.out.println(splitter.getFirstDigit(56));
    }
}

class MoonRobotVespenGasDetector {
    public boolean isAcidOk(int acidValue, int minAcid, int maxAcid) {
        return acidValue >= minAcid && acidValue <= maxAcid;
    }

    public boolean isDensityOk(int density) {
        return density >= 1000 && density <= 5000 || density >= 10000 && density <= 15000;
    }

    public boolean isTemperatureOk(boolean cold) {
        return !cold;
    }

    public boolean isGroundOkForVespenGas(int acidValue, int minAcid, int maxAcid, int density, boolean cold) {
        return isAcidOk(acidValue, minAcid, maxAcid) && isDensityOk(density) && isTemperatureOk(cold);
    }

    public static void main (String[] args) {
        MoonRobotVespenGasDetector detector = new MoonRobotVespenGasDetector();
        System.out.println(detector.isGroundOkForVespenGas(120, 75, 150, 7500, false));
    }
}

class MarsValueConverter {
    public int changeMoneyAmount(float startAmount, float toRemove) {
        return (int) (startAmount - toRemove);
    }

    public byte calculateMoneySum(int sum1, int sum2) {
        return (byte) (sum1 + sum2);
    }

    public short halfOfMoney(double startMoney) {
        return (short) (startMoney / 2);
    }
    public static void main (String[] args) {
        MarsValueConverter converter = new MarsValueConverter();
        System.out.println(converter.halfOfMoney(1000.9999));
    }
}

class ExonNames {
    public boolean areNamesEqual (String name1, String name2) {
        return name1 == name2;
    }

    public String makeFullName(String firstName, String lastName) {
        return firstName.toUpperCase() + " " + lastName.toLowerCase();
    }

    public boolean isNameLucky(String name) {
        return name.contains("A") || name.contains("O") || name.contains("a") || name.contains("o");
    }

    public String getNameCode(String name) {
        return name.length() == 1 ? name.toUpperCase() : ("" + name.substring(0, 1) + name.substring(name.length() - 1)).toUpperCase();
    }

    public boolean isMoneyName(String name) {
        return name.charAt(0) >= '0' && name.charAt(name.length() - 1) <= '9';
    }

    public boolean isInvisibleName(String name) {
//        return name.strip().isEmpty();
        return name.isBlank();
    }

    public String makeNamePositive(String name) {
        return name.replaceAll("(?i)no", "yes");
    }

    public String makeNameClean(String name) {
        return "CLEAN" + name.strip() + "CLEAN";
    }

    public String makeHalfOfName(String name) {
        return name.substring(0, name.length() / 2);
    }

    public static void main(String[] args) {
        ExonNames names = new ExonNames();

        //Should be true
        boolean namesEqual = names.areNamesEqual("nm", "nm");
        System.out.println("names.areNamesEqual(\"nm\", \"nm\") = " + namesEqual);

        String fullName = names.makeFullName("exor", "bigo");
        System.out.println("names.makeFullName(\"exor\", \"bigo\") = " + fullName);

        boolean isNameLucky = names.isNameLucky("Bigo");
        System.out.println("names.isNameLucky(\"Bigo\") = " + isNameLucky);

        String nameCode = names.getNameCode("z");
        System.out.println("names.getNameCode(\"boRA\") = " + nameCode);

        boolean isMoneyName = names.isMoneyName("31Boss31");
        System.out.println("names.isMoneyName(\"31Boss31\") = " + isMoneyName);

        boolean isInvisible = names.isInvisibleName(" ");
        System.out.println("names.isInvisibleName(\" \") = " + isInvisible);

        String positive = names.makeNamePositive("NoMont");
        System.out.println("names.makeNamePositive(\"NoMont\") = " + positive);

        String cleanName = names.makeNameClean(" dirty ");
        System.out.println("names.makeNameClean(\" dirty \") = " + cleanName);

        String halfOfName = names.makeHalfOfName("Javametro");
        System.out.println("names.makeHalfOfName(\"Gurk\") = " + names.makeHalfOfName("Javametro"));
    }
}

class NameEncoderDecoder {
    public String encode (String name) {
        return "NOTFORYOU" + name.replace("e", "1")
                .replace("u", "2")
                .replace("i", "3")
                .replace("o", "4")
                .replace("a", "5") + "YESNOTFORYOU";
    }

    public String decode (String name) {
        return name.replace("NOTFORYOU", "")
                .replace("YES", "")
                .replace("1", "e")
                .replace("2", "u")
                .replace("3", "i")
                .replace("4", "o")
                .replace("5", "a");
    }

    public static void main (String[] args) {
        NameEncoderDecoder example = new NameEncoderDecoder();
        System.out.println(example.encode("Crab"));
        System.out.println(example.decode("NOTFORYOUCr5bYESNOTFORYOU"));
        System.out.println(example.decode("NOTFORYOUNOTFORYOUYESNOTFORYOU"));
    }
}

