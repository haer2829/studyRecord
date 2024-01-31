package 左程云.新手班.day1;

public class 插入排序 {
    public static void main(String[] args) {
        int[] arr = {5, 1, 3, 2, 9, 6, 4};
        sortBetter(arr);
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

    /**
     * 插入排序就像打扑克一样，最开始手里一张牌都没有，每次抓牌都会将牌放到手中牌的合适的位置
     * 假设一共有length张牌
     * 抓0号牌，由于手中没有牌，所以不用排序
     * 抓1号牌，需要与手中的0~0号牌比较，放到合适的位置
     * 抓2号牌，与0~1号已经排好序的牌比较，放到合适的位置
     * 抓3号牌，与0~2号已经排好序的牌比较，放到合适的位置
     * 抓4号牌，与0~3号已经排好序的牌比较，放到合适的位置
     * 抓5号牌，与0~4号已经排好序的牌比较，放到合适的位置
     * ...
     * 抓length-1号牌，与0~length-2号已经排好序的牌比较，放到合适的位置
     */
    public static void sort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int toInsert = array[i];//抓到的牌
            int end = i - 1;//已排序号的牌里最右边的数
            while (end >= 0 && toInsert < array[end]) {
                array[end + 1] = array[end];//给insert腾空间，右移一位
                end--;//刚刚和end的数比完了，在和end-1比较，会一直比较直到找到比insert小的数或者全部比较完
            }
            array[end + 1] = toInsert;
        }
    }

    public static void sortBetter(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int toInsert = array[i];
            for (int j = i - 1; j >= 0 && toInsert < array[j]; j--) {
                swap(array,j,j+1);
            }
        }
    }

    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
