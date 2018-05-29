package other;

import org.junit.jupiter.api.Test;

import static other.User.*;

import java.util.*;

/**
 * 静态导入(导入静态方法和静态域)
 *
 * @author YC
 * Created by 2018/5/22 19:12.
 */
public class PackageExample {

    /**
     * 静态导入
     *  静态域、静态方法
     *
     * @author YC
     * Created by 2018/5/22 22:01.
     */
    @Test
    void staticClassImport() {
        // import static User.*,表明导入静态域和静态方法.

        // 静态域的验证.
        System.out.println(name);
        // 静态方法的验证.
        System.out.println(sayHello());
    }

    /**
     *
     *
     * @author YC
     * Created by 2018/5/22 22:09.
     */
    @Test
    void classImport() {

    }
}

/**
 * 用于测试静态导入,包含静态域和静态方法的类.
 *
 * @author YC
 * Created by 2018/5/22 22:03.
 */
class User {
    public static final String name = "yc";

    public static String sayHello() {
        return "Hello World!";
    }
}
