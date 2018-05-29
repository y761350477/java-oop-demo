package array;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * 声明、赋值、遍历、拷贝、去重、排序.
 *
 * @author YC
 * @create 2018/5/22 9:59.
 */
public class ArrayExample {

    /**
     * 拷贝
     * 方法: Arrays类的copyOf方法
     *
     * @author YC
     * @create 2018/5/22 9:51.
     */
    @Test
    void test1() {
        int[] ints = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int[] copyInts = Arrays.copyOf(ints, ints.length);
        String string = Arrays.toString(copyInts);
        System.out.println(string);
    }

    /**
     * 升序排序(数值型数组)
     * 方法: Arrays类中的sort方法
     *
     * @author YC
     * @create 2018/5/22 13:51.
     */
    @Test
    void test2() {
        Integer[] ints = {2, 4, 3, 1, 7, 5, 8, 10, 9, 6};
        Arrays.sort(ints);
        String string = Arrays.toString(ints);
        System.out.println(string);
    }

}
