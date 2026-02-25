import java.util.*;

public class Theme4 {
    public boolean isArrayContainsValue(String[] names, String searchName) {
        for(String name: names) {
            if (name.equals(searchName)) {
                return true;
            }
        }
        return false;
    }

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
//        for(int i = 1; i < 100; i++) {
//            if (i % 10 != 0) {
//                continue;
//            }
//            System.out.println(i);
//        }

        // Цикл while
//        int number = 1;
//        while (number < 10) {
//            System.out.println(number);
//            number ++;
//        }

        // Цикл do..while
//        int number = 1;
//        do {
//            System.out.println(number);
//            number ++;
//        }
//        while (number < 10);

        // Цикл foreach
//        String[] seasons = {"winter", "spring", "summer", "autumn"};
//        for (String season: seasons) {
//            System.out.println(season);
//        }

//        String[] seasons = {"winter", "spring", "summer", "autumn"};
//        for (int i = 0; i < seasons.length; i ++) {
//            System.out.println(seasons[i]);
//        }
//        System.out.println(new Theme4().isArrayContainsValue(new String[]{"hello", "world", "hi"}, "world"));

        // Перебирання масиву
//        int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
//        for (int i = 0; i < numbers.length; i ++) {
//            if (i % 2 == 1) {
//                System.out.println(numbers[i]);
//            }
//        }

//        int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
//        for (int i = 1; i < numbers.length; i += 2) {
//            System.out.println(numbers[i]);
//        }
    }
}

// Робити якусь дію, доки виконується певна умова

class ElectroCar {
    int energy = 5;
    public int getBatteryEnergy () {

        //...обчислюємо заряд батареї
        return energy;
    }

    public void decreaseEnergy () {
        //...зменшуємо заряд батареї
        energy -= 1;
    }

    public static void main (String[] args) {
        ElectroCar electroCar = new ElectroCar();

        while (electroCar.getBatteryEnergy() > 0) {
            System.out.println("Drive... Energy: " + electroCar.getBatteryEnergy());
            electroCar.decreaseEnergy();
        }
    }
}

// Сортування. Приклад сортування бульбашкою

class ExampleSort {

    public static void main (String[] args) {
//        int[] numbers = {3, 1, 7};
//        Arrays.sort(numbers);
//
//        System.out.println(Arrays.toString(numbers));
//
//        for (int num: numbers) {
//            System.out.println(num);
//        }
        int[] arr = {11, 3, 14, 16, 7};
        boolean isSorted = false;
        int buf;

        while (!isSorted) {
            isSorted = true;
            for (int i = 0; i < arr.length - 1; i ++) {
                if (arr[i] > arr[i + 1]) {
                    isSorted = false;
                    buf = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = buf;
                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }
}


class UberShop {
    public void printPrices(float[] prices) {
        for (int i = 0; i < prices.length; i ++) {
            System.out.println(prices[i] + " jup.");
        }
    }

    public void multiplyPrices(float[] prices) {
        for (int i = 0; i < prices.length; i++) {
            float price = prices[i];

            if (price < 1000) {
                prices[i] *= 2;
            }
            if (price >= 1000) {
                prices[i] *= 1.5f;
            }
        }
    }

//    public int[] findMinMaxPrices(int[] prices) {
//        Arrays.sort(prices);
//
//        for (int i = 0; i < prices.length; i ++) {
//            if (prices[0] == prices[1]) {
//                return new int[] {prices[0]};
//            }
//            if (prices.length == 2) {
//                return prices;
//            }
//            if (prices.length >= 2) {
//                return new int[]{prices[0], prices[prices.length - 1]};
//            }
//        }
//        return new int[]{};
//    }

    public int[] findMinMaxPrices(int[] prices) {
        if (prices.length == 0) {
            return new int[0];
        }

        int min = prices[0];
        int max = prices[0];

        for (int price: prices) {
            if (price > max) {
                max = price;
            }

            if (price < min) {
                min = price;
            }
        }

        if (min == max) {
            return new int[] {min};
        }

        return new int[] {min, max};
    }

    public int getMinPriceCount(int[] prices) {

        if (prices.length == 0) {
            return 0;
        }

        int min = prices[0];

        for (int i = 0; i < prices.length - 1; i ++) {
            int price = prices[i];
            if (price < min) {
                min = price;
            }
        }

        int count = 0;
        for (int price: prices) {
            if (price == min) {
                count += 1;
            }
        }
        return count;
    }

    public int[] removePrice(int[] prices, int toRemove) {

//        int count = 0;
//        for (int i = 0; i < prices.length; i++) {
//            if (prices[i] == toRemove) {
//                count ++;
//            }
//        }
//
//        int[] result = new int[prices.length - count];
//        int index = 0;
//        for (int i = 0; i < prices.length; i++) {
//            if (prices[i] != toRemove) {
//                result[index] = prices[i];
//                index ++;
//            }
//        }
//
//        return result;

        int count = 0;
        for (int price: prices) {
            if (price == toRemove) {
                count ++;
            }
        }

        int[] result = new int[prices.length - count];
        int index = 0;
        for (int price: prices) {
            if (price != toRemove) {
                result[index] = price;
                index ++;
            }
        }
        return result;
    }

    public int[] leavePrice9(int[] prices) {

        int count = 0;
        for (int price: prices) {
            if (price % 10 != 9) {
                count ++;
            }
        }

        int[] result = new int[prices.length - count];
        int index = 0;
        for (int price: prices) {
            if (price % 10 == 9) {
                result[index] = price;
                index ++;
            }
        }
        return result;
    }

    public String[] mergeStocks(String[] showcaseStocks, String[] warehouseStocks) {
//        int count1 = 0;
//        for (String item: showcaseStocks) {
//            count1 ++;
//        }
//
//        int count2 = 0;
//        for (String item: warehouseStocks) {
//            count2 ++;
//        }
//
//        String[] result = new String[count1 + count2];
//        int index = 0;
//        for (int item = 0; item < showcaseStocks.length; item ++) {
//            result[index] = showcaseStocks[item];
//            index ++;
//        }
//        int index2 = result.length - warehouseStocks.length;
//        for (int item = 0; item < warehouseStocks.length; item ++) {
//            result[index2] = warehouseStocks[item];
//            index2 ++;
//        }
//        return result;

//        String[] result = new String[showcaseStocks.length + warehouseStocks.length];
//        for (int i = 0; i < showcaseStocks.length; i ++) {
//            result[i] = showcaseStocks[i];
//        }
//        for (int i = 0; i < warehouseStocks.length; i ++) {
//            result[showcaseStocks.length + i] = warehouseStocks[i];
//        }
//        return result;

        String[] result = new String[showcaseStocks.length + warehouseStocks.length];

        int index = 0;
        for (String item: showcaseStocks) {
            result[index] = item;
            index ++;
        }

        for (String item: warehouseStocks) {
            result[index] = item;
            index ++;
        }
        return result;
    }

    public int getPricesSum(int[] prices, int minPrice, int maxPrice) {
        int resultPrice = 0;
        for (int price: prices) {
            if (price >= minPrice && price <= maxPrice) {
                resultPrice += price;
            }
        }
        return resultPrice;
    }

    public static void main(String[] args) {
        UberShop shop = new UberShop();

//        float[] prices = new float[] {100f, 23.5f, 400f};
//        shop.printPrices(prices);

//        float[] prices2 = new float[] {100f, 1500f};
//        shop.multiplyPrices(prices2);
//        System.out.println(Arrays.toString(prices2));

//        int[] prices = new int[] {66, 88, 8, 90};
//        int[] minMax = shop.findMinMaxPrices(prices);
//        System.out.println(Arrays.toString(minMax));

//        int[] prices = new int[] {5, 5, 5, 5, 7, 88};
//        System.out.println(shop.getMinPriceCount(prices));

//        int[] prices = new int[] {5, 4, 3, 5, 8, 6, 5, 88};
//        System.out.println(Arrays.toString(shop.removePrice(prices, 5)));

//        int[] prices = new int[] {};
//        System.out.println(Arrays.toString(shop.leavePrice9(prices)));

//        String[] showcaseStocks = new String[] {"firegun", "go"};
//        String[] warehouseStocks = new String[] {"j"};
//        System.out.println(Arrays.toString(shop.mergeStocks(showcaseStocks, warehouseStocks)));

//        int[] prices = new int[] {500, 400, 200};
//        System.out.println(shop.getPricesSum(prices, 20, 50));
    }
}

class CheapStocks {
    public String getCheapStocks(String[] stocks) {
        int maxPrice = 200;
        String result = "";

        for (String phrase: stocks) {
            String[] parts = phrase.split(" ");
            int price = Integer.parseInt(parts[1]);

            if (price < maxPrice) {
                result += parts[0] + " ";
            }
        }
        return result;
    }

    public static void main (String[] args) {
        CheapStocks cheapStocks = new CheapStocks();

        String[] phrases = new String[]{"gun 500", "firebow 70", "pixboom 200", "fabu 40"};
        System.out.println(cheapStocks.getCheapStocks(phrases));

    }
}

class ArlanHelper {
    public String drawQuad(int n) {
        String result = "";
        int row = 0;

        while (row < n) {

            int col = 0;

            while (col < n) {
                result += "*";
                col ++;
            }
            result += "\n";
            row ++;
        }
        return result;
    }

//    public String drawRect(int width, int height, char c) {
//        StringBuilder result = new StringBuilder();
//
//        int row = 0;
//        while (row < height) {
//            int col = 0;
//            while (col < width) {
//                result.append(c);
//                col ++;
//            }
//            result.append("\n");
//            row ++;
//        }
//        return result.toString();
//    }

    public String drawRect(int width, int height, char c) {
        String result = "";

        int lines = height;

        while(lines > 0) {
            lines--;

            int columns = width;
            while(columns > 0) {
                result += c;
                columns--;
            }
            result += "\n";
        }
        return result;
    }

    public String drawLine(int length) {
//        String result = "";
//        int i = 0;
//        while (i < length) {
//            if (i % 2 == 0) {
//                result += "*";
//            }
//            else {
//                result += "#";
//            }
//            i ++;
//        }
//        return result;

        String result = "";
        boolean star = true;

        while (length > 0) {
            result += star ? "*" : "#";
            star = !star;
            length --;
        }
        return result;
    }

    public String drawPattern(char[] pattern, int repeatCount) {
        String result = "";
        int repeat = 0;

        while (repeat < repeatCount) {

            int i = 0;
            while (i < pattern.length) {
                result += pattern[i];
                i ++;
            }
            repeat ++;
        }
        return result;
    }

    public static void main(String[] args) {
        ArlanHelper helper = new ArlanHelper();

//        System.out.println(helper.drawQuad(4));
//        System.out.println(helper.drawRect(3, 2, 'X'));
//        System.out.println(helper.drawLine(5));
        System.out.println(helper.drawPattern(new char[] {'J', 'a', 'v', 'a'}, 3));
    }
}

class TriangleDrawer {
    public String drawTriangle(int side) {
        String result = "";

        int row = side;

        while (row > 0) {

            int col = 0;

            while (col < row) {
                result += "*";
                col ++;
            }

            if (row > 1) {
                result += "\n";
            }

            row --;
        }

        return result;
    }

    public static void main (String[] args) {
        System.out.println(new TriangleDrawer().drawTriangle(5));
    }
}

class TrurlBank {
    public int sumQuads(int n) {
        int result = 0;

        while (n > 0) {
            result += n * n;
            n --;
        }

        return result;
    }

    public int countSumOfDigits(int number) {
        int sum = 0;

        while (number > 0) {
            sum += number % 10;
            number /= 10;
        }

        return sum;
    }

    public static void main(String[] args) {
        TrurlBank bank = new TrurlBank();
//        System.out.println(bank.sumQuads(3));
        System.out.println(bank.countSumOfDigits(547));
    }
}

class ATM {
    public int countBanknotes(int sum) {
        int[] notes = {500, 200, 100, 50, 20, 10, 5, 2, 1};
        int count = 0;
        int i = 0;

        while (sum > 0) {

            while (sum >= notes[i]) {
                sum -= notes[i];
                count ++;
            }

            i ++;
        }

        return count;
    }

    public static void main (String[] args) {
        ATM atm = new ATM();
        System.out.println(atm.countBanknotes(578));
    }
}

//class Solution {
//    public int countOdds(int low, int high) {
//
//        int result = 0;
//
//        for (int i = low; i <= high; i++) {
//            if (i % 2 != 0) {
//                result ++;
//            }
//        }
//
//        return result;
//    }
//
//    public static void main (String[] args) {
//        Solution solution = new Solution();
//        System.out.println(solution.countOdds(8, 10 ));
//    }
//}

//class Solution {
//    public int[] runningSum(int[] nums) {
//
//        for (int i = 1; i < nums.length; i ++) {
//            nums[i] += nums[i - 1];
//        }
//
//        return nums;
//    }
//
//    public static void main (String[] args) {
//        Solution solution = new Solution();
//
//        int[] numbers = new int[]{1,1,1,1,1};
//        int[] result = solution.runningSum(numbers);
//        System.out.println(Arrays.toString(result));
//    }
//}

//class Solution {
//    public int[] buildArray(int[] nums) {
//
//        int[] ans = new int[nums.length];
//        int index = 0;
//
//        while (index < nums.length) {
//            ans[index] = nums[nums[index]];
//            index ++;
//        }
//
//        return ans;
//    }
//
//    public static void main (String[] args) {
//        Solution solution = new Solution();
//
//        int[] numbers = new int[]{0,2,1,5,3,4};
//        int[] result = solution.buildArray(numbers);
//        System.out.println(Arrays.toString(result));
//    }
//}

//class Solution {
//    public int[][] transpose(int[][] matrix) {
//
//        int rows = matrix.length;
//        int cols = matrix[0].length;
//
//        int[][] result = new int[cols][rows];
//
//        for (int i = 0; i < rows; i++) {
//            for (int k = 0; k < cols; k++) {
//                result[k][i] = matrix[i][k];
//            }
//        }
//
//        return result;
//    }
//
//    public static void main (String[] args) {
//        Solution solution = new Solution();
//
//        int[][] numbers = new int[][]{{1,2,3},{4,5,6}};
//        int[][] result = solution.transpose(numbers);
//
//        for (int[] res : result) {
//            System.out.println(Arrays.toString(res));
//        }
//    }
//}

//class Solution {
//    public int[][] transpose(int[][] matrix) {
//
//        for (int i = 0; i < matrix.length; i++) {
//
//            for (int k = i + 1; k < matrix.length; k++) {
//                int tempMatrix = matrix[i][k];
//
//                matrix[i][k] = matrix[k][i];
//                matrix[k][i] = tempMatrix;
//            }
//        }
//
//        return matrix;
//    }
//
//    public static void main (String[] args) {
//        Solution solution = new Solution();
//
//        int[][] numbers = new int[][]{{1,2,3},{4,5,6}};
//        int[][] result = solution.transpose(numbers);
//
//        for (int[] res : result) {
//            System.out.println(Arrays.toString(res));
//        }
//    }
//}

class Solution {
    public int diagonalSum(int[][] mat) {

        int matrixLen = mat.length;
        int result = 0;

        for (int i = 0; i < matrixLen; i++) {
            result += mat[i][i];
            result += mat[matrixLen - 1 - i][i];
        }

        if (matrixLen % 2 != 0) {
            result -= mat[matrixLen / 2][matrixLen / 2];
        }

        return result;
    }

    public static void main (String[] args) {
        Solution solution = new Solution();

        int[][] numbers = new int[][]{{1,1,1,1}, {1,1,1,1}, {1,1,1,1}, {1,1,1,1}};
        int result = solution.diagonalSum(numbers);

        System.out.println(result);
    }
}


