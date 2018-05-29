package other;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class Junit5Example {

    /**
     * Assert方法
     *
     * @author YC
     * @create 2018/5/4 10:08.
     */
    @Test
    void test1() {
        assertTrue(true);
        assertTrue(this::truism);
        TestIf test = (a, b, c) -> a + b + c;
        assertFalse(true, () -> "");
    }

    boolean truism() {
        return true;
    }



    @Test
    void test11() {

        System.out.println("2");
    }

    @Test
    @Disabled("忽略测试的备注信息")
    void test2() {
        System.out.println("Junit5的忽略注解");
    }

    @Test
    void test3() {
        assertTrue(true);
        assertTrue(this::truism);
        assertFalse(false, () -> "Really " + "expensive " + "message" + ".");
    }

    /**
     * 扩展断言:
     *  fail(""),强行让测试失败，并提供一个失败信息。
     *
     * @author YC
     * @create 2018/5/4 14:02.
     */
    @Test
    void failTheTest() {
        fail("epicly");
    }

    /**
     * 扩展断言:
     *  assertAll,它接受可变数量的断言作为参数，并保证它们全部得到执行，然后再把错误信息（如果有）一并汇报出来。
     *
     * @author YC
     * @create 2018/5/4 14:03.
     */
    @Test
    void assertAllProperties() {
        assertAll("testAll",
                () -> assertEquals(1,2,"测试相等"),
                () -> assertNull(1,"测试为null"),
                () -> assertNotNull(2, "测试不为空"));
    }

}

interface TestIf {
    String test(String a, String b, String c);
}
