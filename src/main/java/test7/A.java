package test7;

/**
 * @author YangChen
 * @create 2017-12-08 15:48
 */
public class A {

    public static void main(String[] args) {

        // 结果： false
        System.out.println(isRed(EnumClass.BLANK));
        // 结果： true
        System.out.println(isRed(EnumClass.RED));
    }

    static boolean isRed(EnumClass color) {
        if (EnumClass.RED == color) {
            return true;
        }
        return false;
    }
}
