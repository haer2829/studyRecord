package 左程云.新手班.day1;

public class 冒泡排序 {
    public static void main(String[] args) {
        int[] array = {2, 6, 1, 8, 7, 5, 0};
        sort(array);
        for (int i : array) {
            System.out.print(i + " ");
        }
    }

    /**
     * 每一次冒泡都会将最后一个数排序好
     * 第1次需要遍历 0 length-1 排好length-1
     * 第2次需要遍历 0 length-2 排好length-2
     * 第3次需要遍历 0 length-3 排好length-3
     * 第length-1次需要遍历 0 1 排好1
     */
    public static void sort(int[] array) {
        if (array == null || array.length <= 1) {
            return;
        }
        for (int i = array.length-1; i > 0; i--) {
            for (int j = 0; j <= i-1; j++) {
                if (array[j] >= array[j + 1]) {
                    swap(array, j, j + 1);
                }
            }

        }
    }

    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
