package 左程云.新手班.day1;

import org.junit.jupiter.api.Test;

public class 计算阶乘 {
    /**
     * 输入：n
     * 1
     * 2*1
     * 3*2*1
     * n*(n-1)*(n-2)...1
     */
    public static void main(String[] args) {


        System.out.println(cal(3));
    }

    public static int cal(int n) {
        int sum = 0;
        int cur = 1;
        for (int i = 1; i <= n; i++) {
            cur = cur * i;
            sum += cur;
        }
        return sum;
    }

    public int jiecheng(int n) {
        if (n == 1) {
            return 1;
        }
        return jiecheng(n - 1) * n;
    }


}
