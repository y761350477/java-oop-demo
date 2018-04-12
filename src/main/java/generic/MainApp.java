package generic;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainApp {

    public static void main(String[] args) {
        // 泛型只在编译期起作用 Created by YC.
        test_effect();
        // 泛型类的使用 Created by YC.
        test_class();
        // 泛型接口的使用 Created by YC.
        test_dao();
        // 使用泛型通配符的原由 Created by YC.
        test_relation();
        // 泛型通配符的使用 Created by YC.
        test_relation1();

    }

    private static void test_relation() {
        Generic<Integer> integerGeneric = new Generic<>(123);
        Generic<Number> numberGeneric = new Generic<>(456);
        Generic.showKeyValue(numberGeneric);
        // 报错, 证明参数类型为父子类关系的情况并不通用 Created by YC.
//        Generic.showKeyValue(integerGeneric);
    }

    /**
     * 通配符的使用
     * ’？’是类型实参，而不是类型形参, 是所有类的基类
     *
     * @author YC
     * @create 2018/4/12 13:51.
     */
    private static void test_relation1() {
        Generic<Integer> integerGeneric = new Generic<>(123);
        Generic<Number> numberGeneric = new Generic<>(456);
        Generic.showKeyValue1(numberGeneric);
        // 使用通配符不报错, 证明参数类型为父子类关系的情况并不通用 Created by YC.
        Generic.showKeyValue1(integerGeneric);
    }

    private static void test_dao() {
        GenericDAO genericDAO = new FruitGenerator1();
        System.out.println(genericDAO.next());
    }

    private static void test_class() {
        Generic<Integer> integerGeneric = new Generic<>(123456);
        Generic<String> stringGeneric = new Generic<>("key_value");
        System.out.println(integerGeneric.getKey());
        System.out.println(stringGeneric.getKey());
        // 泛型类不一定要指定具体类型 Created by YC.
        Generic generic = new Generic(123456);
        Generic generic1 = new Generic("key_value");
        Generic generic2 = new Generic(false);
        Generic generic3 = new Generic('中');

        System.out.println(generic.getKey());
        System.out.println(generic1.getKey());
        System.out.println(generic2.getKey());
        System.out.println(generic3.getKey());
    }

    private static void test_effect() {
        List<String> stringArrayList = new ArrayList<String>();
        List<Integer> integerArrayList = new ArrayList<Integer>();

        Class classStringArrayList = stringArrayList.getClass();
        Class classIntegerArrayList = integerArrayList.getClass();

        if (classStringArrayList.equals(classIntegerArrayList)) {
            System.out.println("泛型测试, 类型相同");
        }
    }
}

class Generic<T> {

    private T key;

    public Generic(T key) {
        this.key = key;
    }

    public T getKey() {
        return key;
    }

    public static void showKeyValue(Generic<Number> obj) {
        System.out.println("泛型测试:\t" + obj.getKey());
    }

    public static void showKeyValue1(Generic<?> obj) {
        System.out.println("泛型测试:\t" + obj.getKey());
    }
}

interface GenericDAO<T> {
    T next();
}

/**
 * 未传入泛型实参时, 必须要在实现类中将泛型声明
 *
 * @author YC
 * @create 2018/4/12 13:30.
 */
class FruitGenerator<T> implements GenericDAO<T> {

    @Override
    public T next() {
        return null;
    }
}

/**
 * 传入泛型实参时, 可以不在实现类中将泛型声明
 *
 * @author YC
 * @create 2018/4/12 13:31.
 */
class FruitGenerator1 implements GenericDAO<String> {

    private String[] fruits = new String[]{"Apple", "Banana", "Pear"};

    @Override
    public String next() {
        Random rand = new Random();
        return fruits[rand.nextInt(3)];
    }
}



