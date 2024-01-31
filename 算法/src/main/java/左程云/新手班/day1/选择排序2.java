package 左程云.新手班.day1;

public class 选择排序2 {
    public static void main(String[] args) {
        int[] array = {2, 6, 1, 8, 7, 5, 0};
        sort(array);
        for (int i : array) {
            System.out.print(i + " ");
        }
    }

    /**
     * 每次遍历0到length-1-i的数，将最大值放在length-1-i的位置
     * 0到length-1，取最大放到length-1
     * 0到length-2，取最大放到length-2
     * 0到length-3，取最大放到length-3
     * 0到length-4，取最大放到length-4
     * 0到2，取最大放到2
     * 0到1，取最大放到1
     *
     * 每次从length-1-i
     */
    public static void sort(int[] array) {
        if (array == null || array.length <= 1) {
            return;
        }
        for (int i = array.length - 1; i >= 1; i--) {
            int max = i;
            for (int j = i - 1; j >= 0; j--) {
                max = array[max] < array[j] ? j : max;
            }
            swap(array, i, max);
        }
    }

    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
