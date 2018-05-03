package test7;

/**
 * @author YangChen
 * @create 2017-12-08 15:50
 */
public class B {

    public static void main(String[] args) {
        showColor(EnumClass.YELLOW);
    }

    static void showColor(EnumClass color) {
        switch (color) {
            case BLANK:
                System.out.println(color);
                break;
            case RED:
                System.out.println(color);
                break;
            default:
                System.out.println(color);
                break;
        }

    }
}
