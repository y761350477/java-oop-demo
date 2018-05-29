package other;

import org.junit.jupiter.api.Test;

import static other.User.*;

import java.util.*;

/**
 * ��̬����(���뾲̬�����;�̬��)
 *
 * @author YC
 * Created by 2018/5/22 19:12.
 */
public class PackageExample {

    /**
     * ��̬����
     *  ��̬�򡢾�̬����
     *
     * @author YC
     * Created by 2018/5/22 22:01.
     */
    @Test
    void staticClassImport() {
        // import static User.*,�������뾲̬��;�̬����.

        // ��̬�����֤.
        System.out.println(name);
        // ��̬��������֤.
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
 * ���ڲ��Ծ�̬����,������̬��;�̬��������.
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
