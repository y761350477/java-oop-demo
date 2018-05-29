package string;

import org.junit.jupiter.api.Test;

public class StringExample {

    /**
     * 字符串常量是共享的验证.
     *
     * @author YC
     * @create 2018/5/22 8:58.
     */
    @Test
    void test1() {
        String a = "a";
        String b = "a";
        System.out.println(a == b); // -> true
    }

    /**
     * +或substring等操作产生的结果并不是共享的验证.
     *
     * @author YC
     * @create 2018/5/22 9:06.
     */
    @Test
    void test2() {
        String a = "a";
        String b = "ab";
        String c = b.substring(0, 1);
        System.out.println(a == c); // -> false
    }

    @Test
    void test3() {
        String greeting = "Hello";
        int n = greeting.length();
        System.out.println(n);
        int codePointCount = greeting.codePointCount(0, n);
        System.out.println(codePointCount);
    }
}
