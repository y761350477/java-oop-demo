package array;

/**
 * �ӿ���ʹ�þ�̬���������.
 *
 * @author YC
 * Created by 2018/5/23 13:17.
 */
public interface Test {
    static String test(String name) {
        return "Hello World!";
    }
}

class Test1 implements Test {
    public static void main(String[] args) {
        Test.test("Hello World!");
    }
}
