public class Theme4 {
    public static void main (String[] args) {

        // Цикл for
//        for (int i = 0; i < 10; i ++) {
//            System.out.println("#" + i);
//        }

//        int month = 1;
//        for (; month <= 12; month ++) {
//            System.out.println(month);
//        }

//        int year = 1900;
//        for (;;) {
//            System.out.println(year);
//            year ++;
//            if (year > 2000) {
//                break;
//            }
//        }

        // Ключове слово continue
        for(int i = 1; i < 100; i++) {
            if (i % 10 == 0) {
                continue;
            }
            System.out.println(i);
        }
    }
}
