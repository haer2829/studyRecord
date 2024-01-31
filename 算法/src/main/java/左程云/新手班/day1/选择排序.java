package 左程云.新手班.day1;

public class 选择排序 {

    public static void main(String[] args) {
        int[] array = {2, 6, 1, 8, 7, 5, 0};
        sortBetter(array);
        for (int i : array) {
            System.out.print(i + " ");
        }

    }

    /**
     * 选择排序就是每次从剩下的集合里选择最小的数往前放，每次选择都会排好一个数。
     * 例子：2,6,1,8,7
     * 第一次选择：1，6，2，8，7 将最小值1与第一个位置的值进行交换
     * 第二次选择：1，2，6，8，7 将剩余最小值2与第二个位置的值交换
     * 第三次选择：1，2，6，8，7 剩余最小值6，不用交换
     * 第四次选择：1，2，6，7，8 剩余最小值7与第四个位置的值交换
     * <p>
     * 1.先确定要循环几次，可以从上述例子看出，每选择一次就会排序好一个值，最后剩余的一个数不用排(因为已排好)，所以循环次数是length-1
     * 得出代码for (int i = 0; i < array.length-1; i++)
     * 2.内层逻辑：每次都从剩余的数中取最小的值与待排序的数进行交换；
     * 待排序的数可以用array[i]表示，它需要与剩余的数进行比较，如果小于剩余的某个数就进行交换值，然后继续比较，直到与所有剩余的数都比较完
     * 所以剩余的数就是i之后的数，可以用array[i+1]到array[length-1]表示
     * 就可以得到内层循环代码：for (int j = i+1; j <  array.length; j++)
     * 3.再写好交换值的代码逻辑就完成了
     * <p>
     * ----------------------------------------
     * 另一种想法：
     * 每次都从一个范围里选出最小数放在前面
     * 例子：2,6,1,8,7，length是5
     * 从0到length-1的范围里取最小数放到0位置
     * 从1到length-1的范围里取最小数放到1位置
     * 从2到length-1的范围里取最小数放到2位置
     * 从3到length-1的范围里取最小数放到3位置
     * 从length-2到length-1的范围里取最小数放到length-2位置
     * for (int i = 0; i <= array.length - 2; i++)也就是for (int i = 0; i < array.length - 1; i++)
     */
    public static void sort(int[] array) {
        if (array == null || array.length <= 1) {
            return;
        }
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] > array[j]) {
                    swap(array, i, j);
                }
            }
        }
    }

    public static void sortBetter(int[] array) {
        if (array == null || array.length <= 1) {
            return;
        }
        for (int i = 0; i < array.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < array.length; j++) {
                min = array[min] > array[j] ? j :min;
            }
            swap(array,i,min);
        }
    }

    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
