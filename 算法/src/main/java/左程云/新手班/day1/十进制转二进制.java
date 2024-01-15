package 左程云.新手班.day1;

import org.junit.jupiter.api.Test;

public class 十进制转二进制 {
    /**
     * 核心就是将num与1左移i位后的数进行与运算
     * 1左移后，除了移动目的位置是1，其他的位置都是0，这样与num进行与运算，就可以知道num的目的位置是1还是0
     * 从左移31一直循环到左移0，就相当于把num的32位数字都计算了一遍
     */
    @Test
    public void to32() {
        int num = -1;
        for (int i = 31; i >= 0; i--) {
            System.out.print((num & (1 << i)) == 0 ? 0 : 1);
        }
        System.out.println();
    }
}

