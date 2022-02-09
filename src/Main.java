import java.util.Arrays;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        task1();
        task2();
        task3();
        task4();
        task5();
        task6();
        task7();
    }

    private static int randomOnSegment(int min, int max) {
        int diff = max - min;
        Random random = new Random();
        return random.nextInt(diff + 1) + min;
    }

    private static void task1() {
        int[] arr = new int[12];
        int max = Integer.MIN_VALUE;
        int indexOfMax = 0;
        for (int i = 0; i < arr.length; i++) {
            arr[i] = randomOnSegment(-15, 15);
            if (arr[i] >= max) {
                max = arr[i];
                indexOfMax = i;
            }
        }
        System.out.println("Last index of max element in array = " + indexOfMax);
    }

    private static void task2() {
        int[] arr = new int[11];
        int minusOneCount = 0;
        int plusOneCount = 0;
        int zeroCount = 0;
        for (int i = 0; i < arr.length; i++) {
            arr[i] = randomOnSegment(-1, 1);
            switch (arr[i]) {
                case -1:
                    minusOneCount++;
                    break;
                case 1:
                    plusOneCount++;
                    break;
                default:
                    zeroCount++;
                    break;
            }
        }
        System.out.println(Arrays.toString(arr));
        int[] countersArray = {minusOneCount, plusOneCount, zeroCount};
        Arrays.sort(countersArray);
        if (countersArray[2] == countersArray[1]) {
            System.out.println(0);
        } else if (countersArray[2] == minusOneCount) {
            System.out.println("The number -1 occurs most often in the array");
        } else if (countersArray[2] == plusOneCount) {
            System.out.println("The number 1 occurs most often in the array");
        } else {
            System.out.println("The number 0 occurs most often in the array");
        }
    }

    private static void task3() {
        int[] arr = new int[12];
        int positiveCount = 0;
        int negativeCont = 0;
        int tmp;
        for (int i = 0; i < arr.length;) {
            tmp = randomOnSegment(-10, 10);
            if (tmp == 0) {
                continue;
            }
            if (positiveCount > 5 && tmp > 0) {
                continue;
            }
            if (negativeCont > 5 && tmp < 0) {
                continue;
            }
            if (tmp > 0) {
                positiveCount++;
            } else {
                negativeCont++;
            }
            arr[i] = tmp;
            i++;
        }
        System.out.println(Arrays.toString(arr));
    }

    private static void task4() {
        int[][] arr = new int[8][5];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = randomOnSegment(10, 99);
            }
        }
        System.out.println(Arrays.deepToString(arr));
    }

    private static void task5() {
        int[][] arr = new int[5][8];
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = randomOnSegment(-99, 99);
                if (arr[i][j] > max) {
                    max = arr[i][j];
                }
            }
        }
        System.out.println(Arrays.deepToString(arr));
        System.out.println("Max array element = " + max);
    }

    private static void task6() {
        int[][] arr = new int[7][4];
        int rowProduct;
        int maxRowProduct = Integer.MIN_VALUE;
        int maxRowProductIndex = 0;
        for (int i = 0; i < arr.length; i++) {
            rowProduct = 1;
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = randomOnSegment(-5, 5);
                rowProduct *= arr[i][j];
            }
            if (rowProduct > maxRowProduct) {
                maxRowProduct = rowProduct;
                maxRowProductIndex = i;
            }
        }
        System.out.println(Arrays.deepToString(arr));
        System.out.println("Index of the row with the largest product of elements = " + maxRowProductIndex);
    }

    private static void task7() {
        int[][] arr = new int[6][7];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = randomOnSegment(0, 9);
            }
        }
        System.out.println(Arrays.deepToString(arr));
        int maxRowElement;
        int tmp;
        for (int i = 0; i < arr.length; i++) {
            maxRowElement = arr[i][0];
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] > maxRowElement) {
                    maxRowElement = arr[i][j];
                    tmp = arr[i][0];
                    arr[i][0] = maxRowElement;
                    arr[i][j] = tmp;
                }
            }
        }
        System.out.println(Arrays.deepToString(arr));
    }


}
