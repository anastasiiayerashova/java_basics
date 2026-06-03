import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Theme11 {
    public static void main (String[] args) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < 100000; i++) {
            result.append(i);
        }
        System.out.println(result);
//        byte[] bytes = {74, 97, 118, 97};
//        System.out.println(new String(bytes));
//        System.out.println(Arrays.toString("Java".getBytes()));
//        System.out.println(Arrays.toString("Java".toCharArray()));
//
//        String title = "Welcome";
//        String body = "You have successfully logged in.";
//
//        String html = "<html>\\n" +
//                "    <body>\\n" +
//                "        <h1>Hello, world!</h1>\\n" +
//                "    </body>\\n" +
//                "</html>\\n";
//
//        String html2 = String.format("""
//            <html>
//                <head><title>%s</title></head>
//                <body>
//                    <p>%s</>
//                </body>
//            </html>
//         """, title, body);
//
//        System.out.println(html2);

//        String result = "";
//        for(int i = 0; i < 100000; i++) {
//            result += i;
//        }
//
//        System.out.println(result);
    }
}


class GooWordStat {
    private String word;
    private int freq;
    public GooWordStat(String word, int freq) {
        this.word = word;
        this.freq = freq;
    }
    public String getWord() {
        return this.word;
    }
    public int getFreq() {
        return this.freq;
    }

    public String check (int incomeFreq) {
        if (incomeFreq < 1000) return "LOW";
        if (incomeFreq >= 1000 && incomeFreq < 100000) return "MEDIUM";
        if (incomeFreq >= 100000 && incomeFreq < 10000000) return "HIGH";
        return "EXTRA HIGHT";
    }

    @Override
    public String toString() {
        return "Word is [" + this.word + "], search freq is " + check(this.freq);
    }
}

class GooWordStatTest {
    public static void main(String[] args) {
        //Word is [human], search freq is LOW
        System.out.println(new GooWordStat("human", 10));

        //Word is [mars], search freq is MEDIUM
        System.out.println(new GooWordStat("mars", 10000));

        //Word is [space], search freq is HIGH
        System.out.println(new GooWordStat("space", 9965499));

        //Word is [life], search freq is EXTRA HIGH
        System.out.println(new GooWordStat("life", 564785654));
    }
}


class GooSearchResult {
    private String url;
    public GooSearchResult(String url) {
        this.url = url;
    }

    public String getUrl() {
        return this.url;
    }

    public String parseDomain() {
        // 1. Спочатку прибираємо протоколи, як і раніше
        String domain = this.url
                .replace("https://", "")
                .replace("http://", "");

        // 2. Шукаємо перше входження символу '/' або '?' у чистий домен
        int slashIndex = domain.indexOf("/");
        int questionIndex = domain.indexOf("?");

        // 3. Визначаємо найперший символ-роздільник, який зустрінеться
        int endIndex = -1;
        if (slashIndex != -1 && questionIndex != -1) {
            endIndex = Math.min(slashIndex, questionIndex);
        } else if (slashIndex != -1) {
            endIndex = slashIndex;
        } else if (questionIndex != -1) {
            endIndex = questionIndex;
        }

        // 4. Якщо роздільник знайдено, обрізаємо рядок до нього
        if (endIndex != -1) {
            domain = domain.substring(0, endIndex);
        }

        return domain;
    }
}


class GooSearchResultTest {
    public static void main(String[] args) {
        //test.com
        System.out.println(new GooSearchResult("https://test.com").parseDomain());

        //apple.in.mars
        System.out.println(new GooSearchResult("http://apple.in.mars").parseDomain());
    }
}


class Phrase {
    private String[] words;
    public Phrase(String[] words) {
        this.words = words != null ? Arrays.copyOf(words, words.length) : new String[0];
    }

    public String toString() {
        return String.join(" ", this.words);
    }
}


class PhraseTest {
    public static void main(String[] args) {
        String[] words = {"alpha", "beta", "gamma"};

        Phrase phrase = new Phrase(words);

        //alpha beta gamma
        System.out.println(phrase);

        words[0] = "zero";

        //alpha beta gamma
        System.out.println(phrase);
    }
}

class PunctuationMarkCounter {
    public int count(String phrase) {
        if (phrase == null || phrase.isEmpty()) {
            return 0;
        }

        int count = 0;
        for (int i = 0; i < phrase.length(); i++) {
            char ch = phrase.charAt(i);
            if (ch == '.' || ch == ',' || ch == '!' || ch == ':' || ch == ';') {
                count++;
            }
        }
        return count;
    }
}

class PunctuationMarkCounterTest {
    public static void main(String[] args) {
        PunctuationMarkCounter counter = new PunctuationMarkCounter();

        //2
        System.out.println(counter.count("Hello, world!"));

        //1
        System.out.println(counter.count("This is Sparta!"));

        //1
        System.out.println(counter.count("End."));
    }
}


class DoubleSpaceCleaner {
    public String clean(String phrase) {
        if (phrase == null) {
            return "";
        }

        // 1. .trim() прибирає пробіли на початку та в кінці рядка
        // 2. .replaceAll("\\s+", " ") знаходить будь-яку послідовність
        //    з одного або кількох пробілів підряд і замінює її на ОДИН пробіл
        return phrase.trim().replaceAll("\\s+", " ");
    }
}

// Перевірка роботи класу
class DoubleSpaceCleanerTest {
    public static void main(String[] args) {
        DoubleSpaceCleaner cleaner = new DoubleSpaceCleaner();

        // "Hello World"
        System.out.println(cleaner.clean("Hello World"));

        // "Hello World" (видалить пробіли з країв та стисне пробіли всередині)
        System.out.println(cleaner.clean("       Hello              World          "));

        // "This is a test"
        System.out.println(cleaner.clean("This    is   a      test"));
    }
}


class WordFreqCounter {
    public float countFreq (String phrase, String word) {
        if (phrase == null || phrase.isEmpty() || word == null || word.isEmpty()) {
            return 0f;
        }
        String lowerPhrase = phrase.toLowerCase();
        String lowerWord = word.toLowerCase();

        String[] words = lowerPhrase.split(" ");

        int count = 0;
        for (String w: words) {
            if (w.equals(lowerWord)) {
                count++;
            }
        }
        return (float) count / words.length;
    }
}

class WordFreqCounterTest {
    public static void main(String[] args) {
        WordFreqCounter freqCounter = new WordFreqCounter();

        //0.5
        System.out.println(freqCounter.countFreq("Hello Java", "java"));

        //0
        System.out.println(freqCounter.countFreq("Hello World", "java"));
    }
}

class StringByteWorker {
    public String process (byte[] startBytes) {
        String result = new String(startBytes);
        return result.toLowerCase();
    }
}

class StringByteWorkerTest {
    public static void main(String[] args) {
        byte[] startBytes = {74, 97, 86, 97};

        //java
        System.out.println(new StringByteWorker().process(startBytes));
    }
}

class ShortWordCounter {
    public int count (String phrase, int minLength) {
        String[] words = phrase.trim().split("\\s+");
        int count = 0;
        for (String w: words) {
            if (w.length() <= minLength) {
                count ++;
            }
        }
        return count;
    }
}


class ShortWordCounterTest {
    public static void main(String[] args) {
        //1
        System.out.println(new ShortWordCounter().count("Java is great language", 2));

        //2
        System.out.println(new ShortWordCounter().count("Java is great language", 4));

        //3
        System.out.println(new ShortWordCounter().count("Java is great language", 5));

        //4
        System.out.println(new ShortWordCounter().count("Java is great language", 100));
    }
}


class PalindromeCounter {
    public int count (String phrase) {
        if (phrase == null || phrase.trim().isEmpty()) {
            return 0;
        }
        String[] words = phrase.trim().split("\\s+");
        int count = 0;
        for (String word: words) {
            String cleanWord = word.replaceAll("[^a-zA-Z0-9]", "").toUpperCase();
            if (cleanWord.isEmpty()) {
                continue;
            }
            String reversedWord = new StringBuilder(cleanWord).reverse().toString();
            if (cleanWord.equals(reversedWord)) {
                count++;
            }
        }
        return count;
    }
}


class PalindromeCounterTest {
    public static void main(String[] args) {
        PalindromeCounter counter = new PalindromeCounter();

        //1
        System.out.println(counter.count("Level done!"));

        //0
        System.out.println(counter.count("No palindromes"));
    }
}

class UniqueCharCounter {
    public int count (String phrase) {
        Set<Character> uniqueChars = new HashSet<>();
        for (int i = 0; i < phrase.length(); i++) {
            char ch = phrase.charAt(i);
            uniqueChars.add(ch);
        }
        return uniqueChars.size();
    }
}

class UniqueCharCounterTest {
    public static void main(String[] args) {
        UniqueCharCounter charCounter = new UniqueCharCounter();

        //3
        System.out.println(charCounter.count("123"));

        //4
        System.out.println(charCounter.count("ab100"));

        //3
        System.out.println(charCounter.count("Java"));
    }
}

class WordDeleter {
    public String remove(String phrase, String[] words) {
        if (phrase == null || phrase.trim().isEmpty()) {
            return "";
        }
        if (words == null || words.length == 0) {
            return phrase.trim().replaceAll("\\s+", " ");
        }

        // 1. Перетворюємо масив слів для видалення у список (List),
        // щоб зручно перевіряти через .contains()
        List<String> wordsToDelete = Arrays.asList(words);

        // 2. Розбиваємо фразу на окремі слова
        String[] originalWords = phrase.trim().split("\\s+");

        // Список, куди будемо додавати тільки потрібні слова
        List<String> resultWords = new ArrayList<>();

        // 3. Фільтруємо слова
        for (String word : originalWords) {
            if (!wordsToDelete.contains(word)) {
                resultWords.add(word);
            }
        }

        // 4. Об'єднуємо слова назад у рядок, розділяючи їх одним пробілом
        return String.join(" ", resultWords);
    }
}

class WordDeleterTest {
    public static void main(String[] args) {
        WordDeleter wordDeleter = new WordDeleter();

        //Hello
        System.out.println(wordDeleter.remove("Hello Java", new String[] {"Java"}));

        //This Sparta
        System.out.println(wordDeleter.remove("This is Sparta", new String[] {"is"}));
    }
}

class SensitiveDataSearcher {
    public boolean isSensitiveDataPresent (String phrase) {
        String[] sensitiveWords = {"pass", "key", "login", "email"};
        String[] words = phrase.toLowerCase().trim().split("\\s+");
        for (String word: words) {
            String cleanWord = word.replaceAll("[^a-z0-9]", "");
            for (String sensitive: sensitiveWords) {
                if (cleanWord.equals(sensitive)) {
                    return true;
                }
            }
        }
        return false;
    }
}


class SensitiveDataSearcherTest {
    public static void main(String[] args) {
        SensitiveDataSearcher searcher = new SensitiveDataSearcher();

        //false
        System.out.println(searcher.isSensitiveDataPresent("Hello world"));

        //true
        System.out.println(searcher.isSensitiveDataPresent("Pass: swordfish"));
    }
}

class DigitText {
    public boolean detect (String text) {
        return text.matches("[0-9 ]+");
    }
}

class DigitTextTest {
    public static void main(String[] args) {
        //true
        System.out.println(new DigitText().detect("23 50"));

        //false
        System.out.println(new DigitText().detect("Year 1990"));
    }
}

class SummaryCreator {
    public String create (String text) {
        if (text.length() <= 15) {
            return text;
        }
        String chopped = text.substring(0, 15);
        if (text.charAt(15) != ' ') {
            return chopped + "...";
        }
        return chopped;
    }
}

class SummaryCreatorTest {
    public static void main(String[] args) {
        SummaryCreator summaryCreator = new SummaryCreator();

        //Mars
        String shortPhrase = "Mars";
        System.out.println(summaryCreator.create(shortPhrase));

        //Java is very po...
        String longPhrase = "Java is very popular language";
        System.out.println(summaryCreator.create(longPhrase));
    }
}

class MathDetector {
    public boolean isMath (String text) {
        if (!text.contains("=")) {
            return false;
        }
        if (!text.contains("+") && !text.contains("-") && !text.contains("*") && !text.contains("/")) {
            return false;
        }
        int digitCount = 0;
        for (int i = 0; i < text.length(); i++) {
            if (Character.isDigit(text.charAt(i))) {
                digitCount ++;
            }
            if (digitCount >= 2) {
                break;
            }
        }
        if (digitCount < 2) {
            return false;
        }
        return true;
    }
}

class MathDetectorTest {
    public static void main(String[] args) {
        //true
        System.out.println(new MathDetector().isMath("2+2=4"));

        //false
        System.out.println(new MathDetector().isMath("1992 is great year"));

        //false
        System.out.println(new MathDetector().isMath("Venus vs Earth"));
    }
}

class AvgWordLength {
    public double count (String phrase) {
        String[] words = phrase.trim().split("\\s+");
        double count = 0;
        for (String word: words) {
            count += word.length();
        }
        return (double) count / words.length;
    }
}

class AvgWordLengthTest {
    public static void main(String[] args) {
        //6
        System.out.println(new AvgWordLength().count("Launch Rocket"));

        //4.5
        System.out.println(new AvgWordLength().count("Life is strange thing"));
    }
}

class DigitExtracter {
    public int[] extract(String text) {
        int digitCount = 0;
        for (int i = 0; i < text.length(); i++) {
            if (Character.isDigit(text.charAt(i))) {
                digitCount ++;
            }
        }
        int[] result = new int[digitCount];
        int index = 0;
        for (int i = 0; i < text.length(); i ++) {
            char ch = text.charAt(i);
            if (Character.isDigit(ch)) {
                result[index] = Character.getNumericValue(ch);
                index ++;
            }
        }
        return result;
    }
}

class DigitExtracterTest {
    public static void main(String[] args) {
        DigitExtracter digitExtracter = new DigitExtracter();

        int[] extracted = digitExtracter.extract("april 5, year 2000");

        //[5, 2, 0, 0, 0]
        System.out.println(Arrays.toString(extracted));
    }
}

class BigOrSmall {
    public String calculate (String text) {
        if (text == null || text.isEmpty()) {
            return "Same"; // Якщо текст порожній, кількість літер 0 і 0 (тобто рівна)
        }
        int lowerCount = 0;
        int upperCount = 0;
        for (int i = 0; i < text.length(); i ++) {
            if (Character.isLowerCase(text.charAt(i))) {
                lowerCount ++;
            } else if (Character.isUpperCase(text.charAt(i))) {
                upperCount ++;
            }
        }

        if (lowerCount > upperCount) {
            return "Small";
        } else if (upperCount > lowerCount) {
            return "Big";
        }
        else {
            return "Same";
        }
    }
}


class BigOrSmallTest {
    public static void main(String[] args) {
        //Small
        System.out.println(new BigOrSmall().calculate("Java"));

        //Big
        System.out.println(new BigOrSmall().calculate("JAVA"));

        //Same
        System.out.println(new BigOrSmall().calculate("jAvA"));
    }
}

class WordCombine {
    public boolean canCombine (String sourceWord, String targetWord) {
        String source = sourceWord.toLowerCase();
        String target = targetWord.toLowerCase();

        for (int i = 0; i < target.length(); i ++) {
            char ch = target.charAt(i);
            String letter = String.valueOf(ch);
            if (!source.contains(letter)) {
                return false;
            }
        }
        return true;
    }
}

class WordCombineTest {
    public static void main(String[] args) {
        //true
        System.out.println(new WordCombine().canCombine("Forest", "tor"));

        //true
        System.out.println(new WordCombine().canCombine("Magic", "Mama"));

        //false
        System.out.println(new WordCombine().canCombine("War", "Piece"));
    }
}

class WaterCounter {
    public double count (String text) {
        int count = 0;
        for (int i = 0; i < text.length(); i ++) {
            if (text.charAt(i) == ' ') {
                count ++;
            }
        }
        return (double) count / text.length();
    }
}

class WaterCounterTest {
    public static void main(String[] args) {
        //0.07692307692307693
        System.out.println(new WaterCounter().count("Moon invaders"));

        //0
        System.out.println(new WaterCounter().count("NoWater"));
    }
}

class EmailDetector {
    public boolean isPresent (String text) {
        String emailRegex = "\\S{2,}@\\S{2,}";

        Pattern pattern = Pattern.compile(emailRegex);
        Matcher matcher = pattern.matcher(text);
        return matcher.find();
    }
}

class EmailDetectorTest {
    public static void main(String[] args) {
        //true
        System.out.println(new EmailDetector().isPresent("This email is no-reply@goo.com"));

        //false
        System.out.println(new EmailDetector().isPresent("No email present, but @ there"));
    }
}

class NameCounter {
    public int count (String text) {
        String[] words = text.trim().split("\\s+");
        int nameCount = 0;
        for (int i = 0; i < words.length; i ++) {
            String word = words[i];
            if (word.length() >= 2) {
                char firstChar = word.charAt(0);
                String remainder = word.substring(1);
                if (Character.isUpperCase(firstChar) && remainder.matches("^[a-z]+$")) {
                    nameCount ++;
                }
            }
        }
        return nameCount;
    }
}

class NameCounterTest {
    public static void main(String[] args) {
        //1
        System.out.println(new NameCounter().count("Mars is great planet"));

        //2
        System.out.println(new NameCounter().count("Moon is near Earth"));

        //0
        System.out.println(new NameCounter().count("SPACE IS GREAT"));
    }
}

class NumberJoiner {
    public String join(int[] numbers) {
        StringBuilder builder = new StringBuilder();
        for(int number: numbers) {
            builder.append(number);
        }
        return builder.toString();
    }
}

class NumberJoinerTest {
    public static void main(String[] args) {
        //102030
        System.out.println(new NumberJoiner().join(new int[] {10, 20, 30}));
    }
}

//class PhraseMaker {
//    public String join(String[] words) {
//        String result = "";
//        for(int i = 0; i < words.length; i++) {
//            String word = words[i];
//            if (word.length() <= 3) {
//                word = word.toUpperCase();
//            } else {
//                word = word.toLowerCase();
//            }
//
//            result += word;
//            if (i != words.length - 1) {
//                result += " ";
//            }
//        }
//        return result;
//    }
//}
//
//class PhraseMakerTest {
//    public static void main(String[] args) {
//        String[] words = {"Life", "is", "great", "thing"};
//
//        //life IS great thing
//        System.out.println(new PhraseMaker().join(words));
//    }
//}

class PhraseMaker {
    public String join(String[] words) {
        StringBuilder builder = new StringBuilder();
        for(int i = 0; i < words.length; i++) {
            String word = words[i];
            if (word.length() <= 3) {
                word = word.toUpperCase();
            } else {
                word = word.toLowerCase();
            }

            builder.append(word);
            if (i != words.length - 1) {
                builder.append(" ");
            }
        }
        return builder.toString();
    }
}

class PhraseMakerTest {
    public static void main(String[] args) {
        String[] words = {"Life", "is", "great", "thing"};

        //life IS great thing
        System.out.println(new PhraseMaker().join(words));
    }
}

class PalindromeDetector {
    public boolean isPalindrome(String word) {
        return word.equalsIgnoreCase(reverse(word));
    }

    private String reverse(String word) {
        return new StringBuilder(word).reverse().toString();
    }
}

class PalindromeDetectorTest {
    public static void main(String[] args) {
        //false
        System.out.println(new PalindromeDetector().isPalindrome("Java"));

        //true
        System.out.println(new PalindromeDetector().isPalindrome("Noon"));
    }
}

class ObjectWorker {
    public String join(Object[] objects) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < objects.length; i ++) {
            builder.append(objects[i]);
            if (i != objects.length - 1) {
                builder.append(" ");
            }
        }
        return builder.toString();
    }
}

class ObjectWorkerTest {
    public static void main(String[] args) {
        Object[] data = {"Hello", 20L, 3.14f, true};

        //Hello 20 3.14 true
        System.out.println(new ObjectWorker().join(data));
    }
}

class NameParser {
    public String parse(String[] names) {
        StringBuilder builder = new StringBuilder();

        for(int i = 0; i < names.length; i++) {
            String firstName = names[i].split(" ")[0];

            builder.append(firstName);
            if (i != names.length - 1) {
                builder.append(", ");
            }
        }

        return builder.toString();
    }
}

class NameParserTest {
    public static void main(String[] args) {
        String[] names = {"John Doe", "Bill Mask", "Nigua Joshua"};

        //John, Bill, Nigua
        System.out.println(new NameParser().parse(names));
    }
}

//class Solution1 {
//    private String reverse(String word) {
//        return new StringBuilder(word).reverse().toString();
//    }
//    public String reverseWords(String s) {
//        String[] words = s.trim().split("\\s+");
//        StringBuilder builder = new StringBuilder();
//        for (int i = 0; i < words.length; i ++) {
//            String reversedWord = reverse(words[i]);
//            builder.append(reversedWord);
////            if (words[i].charAt(i) != words.length - 1) {
////                builder.append(" ");
////            }
//            if (i != words.length - 1) {
//                builder.append(" ");
//            }
//        }
//        return builder.toString().trim();
//    }
//}
//
//class Solution1Test {
//    public static void main (String[] args) {
//        Solution1 solution1 = new Solution1();
//        System.out.println(solution1.reverseWords("Let's take LeetCode contest"));
//    }
//}

//class Solution1 {
//    public String longestCommonPrefix(String[] strs) {
//        // Якщо масив порожній, спільного префікса бути не може
//        if (strs == null || strs.length == 0) {
//            return "";
//        }
//
//        // Беремо перше слово як початковий орієнтир для префікса
//        String prefix = strs[0];
//
//        // Проходимо по всіх інших словах у масиві, починаючи з індексу 1
//        for (int i = 1; i < strs.length; i++) {
//            // Метод indexOf(prefix) повертає 0, якщо strs[i] починається з prefix.
//            // Поки strs[i] НЕ починається з нашого префікса (індекс не дорівнює 0):
//            while (strs[i].indexOf(prefix) != 0) {
//                // Скорочуємо префікс на одну літеру з кінця
//                prefix = prefix.substring(0, prefix.length() - 1);
//
//                // Якщо префікс став порожнім, то спільного початку немає взагалі
//                if (prefix.isEmpty()) {
//                    return "";
//                }
//            }
//        }
//
//        return prefix;
//    }
//}
//
//class Solution1Test {
//    public static void main (String[] args) {
//        Solution1 solution1 = new Solution1();
//        System.out.println(solution1.longestCommonPrefix(new String[]{"flower","flow","flight"}));
//    }
//}

//class Solution1 {
//    public int strStr (String haystack, String needle) {
//        return haystack.indexOf(needle);
//    }
//}
//
//class Solution1Test {
//    public static void main (String[] args) {
//        Solution1 solution1 = new Solution1();
//        System.out.println(solution1.strStr("sadbutsad", "sad"));
//    }
//}

//class Solution1 {
//    public boolean isAnagram(String s, String t) {
//
//        if (s.length() != t.length()) {
//            return false;
//        }
//
//        char[] sChars = s.toCharArray();
//        char[] tChars = t.toCharArray();
//
//        Arrays.sort(sChars);
//        Arrays.sort(tChars);
//
//        return Arrays.equals(sChars, tChars);
//    }
//}
//
//class Solution1Test {
//    public static void main (String[] args) {
//        Solution1 solution1 = new Solution1();
//        System.out.println(solution1.isAnagram("anagram", "nagaram"));
//    }
//}


//class Solution1 {
//    public boolean isAnagram(String s, String t) {
//        if (s.length() != t.length()) {
//            return false;
//        }
//
//        // Масив для 26 літер англійського алфавіту
//        int[] counter = new int[26];
//
//        for (int i = 0; i < s.length(); i++) {
//            // s.charAt(i) - 'a' дає індекс від 0 до 25
//            counter[s.charAt(i) - 'a']++;
//            counter[t.charAt(i) - 'a']--;
//        }
//
//        // Перевіряємо, чи всі комірки повернулися до нуля
//        for (int count : counter) {
//            if (count != 0) {
//                return false;
//            }
//        }
//
//        return true;
//    }
//}
//
//class Solution1Test {
//    public static void main (String[] args) {
//        Solution1 solution1 = new Solution1();
//
//        // true
//        System.out.println(solution1.isAnagram("anagram", "nagaram"));
//        // false
//        System.out.println(solution1.isAnagram("rat", "car"));
//    }
//}

class Solution1 {
    public List<String> fizzBuzz(int n) {
        // Створюємо список, куди будемо додавати результати
        List<String> answer = new ArrayList<>();

        // Задача 1-indexed, тому цикл починаємо з 1 і йдемо до n включно
        for (int i = 1; i <= n; i++) {

            // 1. Спочатку перевіряємо ділення і на 3, і на 5 (тобто на 15)
            if (i % 3 == 0 && i % 5 == 0) {
                answer.add("FizzBuzz");
            }
            // 2. Якщо ні, перевіряємо ділення лише на 3
            else if (i % 3 == 0) {
                answer.add("Fizz");
            }
            // 3. Якщо ні, перевіряємо ділення лише на 5
            else if (i % 5 == 0) {
                answer.add("Buzz");
            }
            // 4. Якщо жодна умова не підійшла, додаємо саме число у вигляді рядка
            else {
                answer.add(String.valueOf(i));
            }
        }

        return answer;
    }
}

class Solution1Test {
    public static void main (String[] args) {
        Solution1 solution1 = new Solution1();

        System.out.println(solution1.fizzBuzz(15));
        System.out.println(solution1.fizzBuzz(5));
    }
}


