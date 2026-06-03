enum TrueOrFalse {
    yes,
    no
}

public class Theme13 {
}

//class Seasons {
//    public static final int SUMMER = 1;
//    public static final int AUTUMN = 2;
//    public static final int WINTER = 3;
//    public static final int SPRING = 4;
//
//    public String getSeason(int season) {
//        switch(season) {
//            case SUMMER: return "Summer";
//            case AUTUMN: return "Autumn";
//            case WINTER: return "Winter";
//            case SPRING: return "Spring";
//        }
//        throw new IllegalArgumentException("Unknown season id: " + season);
//    }
//
//    public static void main(String[] args) {
//        Seasons seasons = new Seasons();
//        System.out.println(seasons.getSeason(Seasons.WINTER));
//    }
//}

enum SeasonEnum {
    Summer,
    Autumn,
    Winter,
    Spring
}

enum Planet1 {
    Earth,
    Mars;

    @Override
    public String toString() {
        switch(this) {
            case Earth: return "Земля";
            case Mars: return "Марс";
        }
        return super.toString();
    }
}

class SeasonFormatter {
    public String getSeasonName(SeasonEnum season) {
        switch(season) {
            case Summer: return "Summer";
            case Autumn: return "Autumn";
            case Winter: return "Winter";
            case Spring: return "Spring";
        }
        throw new IllegalArgumentException("Unknown season id: " + season);
    }

    public static void main(String[] args) {
        SeasonFormatter seasonFormatter = new SeasonFormatter();
        System.out.println(seasonFormatter.getSeasonName(SeasonEnum.Winter));

        String yesName = TrueOrFalse.yes.name();
        TrueOrFalse value = TrueOrFalse.valueOf("yes");
        System.out.println(yesName);
        System.out.println(value);
        System.out.println(Planet1.Earth);
        System.out.println(Planet1.Mars.ordinal());

        for(Planet1 planet1: Planet1.values()) {
            System.out.println(planet1.name());
        }

        int earthIndex = Planet1.Earth.ordinal();
        Planet1 earth = Planet1.values()[earthIndex];
        System.out.println(earth.name());

    }
}

class ColdDetector {
    public boolean isCold(SeasonEnum season) {
        if (season == SeasonEnum.Winter || season == SeasonEnum.Autumn) {
            return true;
        }
        return false;
    }
}

enum DeveloperLevel {
    Junior(0) {
        @Override
        public boolean isJunior() {
            return true;
        }
    },
    Middle(2) {
        @Override
        public boolean isMiddle() {
            return true;
        }
    },
    Senior(5) {
        @Override
        public boolean isSenior() {
            return true;
        }
    };
    private int yearsOfExperience;

    public boolean isJunior() {return false;}
    public boolean isMiddle() {return false;}
    public boolean isSenior() {return false;}

    public int getYearsOfExperience() {
        return yearsOfExperience;
    }

    DeveloperLevel (int yearsOfExperience) {
        this.yearsOfExperience = yearsOfExperience;
    }
}

class TypeArrayPrinter {
    public <T extends Number & Comparable> void printArray(T[] data) {
        for(T item: data) {
            System.out.println(item);
        }
    }
}

class TypeArrayPrinterTest {
    public static void main(String[] args) {
        String[] items = {"Hello", "Java"};
        Integer[] years = {2000, 3000};
        Float[] nums = {15f, 12f};

        TypeArrayPrinter typeArrayPrinter = new TypeArrayPrinter();
//        typeArrayPrinter.printArray(items);
        typeArrayPrinter.printArray(years);
        typeArrayPrinter.printArray(nums);
    }
}

class KeyValuePair<K, V> {
    private K key;
    private V value;

    public K getKey() {
        return key;
    }
    public V getValue() {
        return value;
    }
    public void setKey(K key) {
        this.key = key;
    }
    public void setValue(V value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return key + " = " + value;
    }
}

class KeyValueTest {
    public static void main(String[] args) {
        KeyValuePair<String, Integer> keyValuePair = new KeyValuePair<String, Integer>();
        KeyValuePair<Integer, Float> yearAvgTemperature = new KeyValuePair<Integer, Float>();

        keyValuePair.setKey("anastasia");
        keyValuePair.setValue(5);
        System.out.println(keyValuePair.getKey());
        System.out.println(keyValuePair.getValue());
        System.out.println(keyValuePair);

        yearAvgTemperature.setKey(3200);
        yearAvgTemperature.setValue(15f);
        System.out.println(yearAvgTemperature);
    }
}





