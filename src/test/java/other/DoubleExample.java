package other;

import org.junit.jupiter.api.Test;

public class DoubleExample {

    /**
     * public boolean isNaN()方法
     * public static boolean isNaN(double parameters)方法
     * 常量NaN：public static final double NaN用于声明一个double,建立条件的
     *  困惑:
     *  1. Double.isNaN(parameters)parameters只能为double类型,如何判断"非数值".
     *  2. Double.isNaN(parameters)有什么使用意义?
     *  释疑:
     *  1. 声明double为常量NaN,用于建立条件;
     *  2. 后续操作对声明的double的变量进行是否为NaN的判断,处理响应的逻辑;
     *  3. NaN为非数值.
     *  4. double x = Double.NaN; -> 输出x为NaN.
     *
     * @author YC
     * @create 2018/5/21 15:15.
     */
    @Test
    void test1() {
        // public boolean isNaN()
        double x = Double.NaN;
        Double d1 = new Double(x);
        boolean dou = d1.isNaN();
        System.out.println(dou);

        // public static boolean isNaN(double parameters)
        boolean b = Double.isNaN(x);
        System.out.println(b);
    }
}
