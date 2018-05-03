package test7;

/**
 * @author YangChen
 * @create 2017-12-08 16:12
 */
public class UserTest {

    public static void main(String[] args) {

        System.out.println(UserEnum.RED.getName());
        System.out.println(UserEnum.YELLO.getIndex());
        for (UserEnum userEnum : UserEnum.values()) {
            System.out.println("######: " + userEnum);
        } 
    }
}
