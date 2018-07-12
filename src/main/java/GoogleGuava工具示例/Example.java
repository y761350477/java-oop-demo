package GoogleGuava工具示例;

import com.google.common.base.Joiner;
import com.google.common.base.Splitter;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * GoogleGuava测试用例
 *
 * @author YC
 * Created by 2018-07-11 18:22
 */
public class Example {

    /**
     * 字符串连接 -> Joiner
     * Expression: Joiner.on(separator).join(parts);
     * 返回值: String
     * 入参: parts可以是Array[]、ListArray、String不定参、Iterato、Iterable.
     *
     * Expression: Joiner.on(separator).skipNulls().join(parts)
     * 注: 使用skipNulls(),可以忽略null值。避免parts中有null值时，抛出NPE异常.
     *
     * Expression: Joiner.on(separator).useForNull(nullText).join(parts)
     * 注: 使用useForNull(),可以将part中的null值替换为指定字符.
     *
     * @author YC
     * Created by 2018/7/11 18:30.
     */
    @Test
    void testJoiner() {
        testJoinerString();
        testJoinerStringArrayList();

        testJoinerIsNullException();

        testJoinerSkipNullsFun();
        testJoinerUseForNullFun();

    }

    /**
     * Joiner.on(separator).useForNull(nullText).join(parts)
     *
     * @author YC
     * Created by 2018/7/12 10:58.
     */
    private void testJoinerUseForNullFun() {
        String joinString = Joiner.on(" - ").useForNull("yc").join("test1", null, "test2");
        System.out.println(joinString);
    }

    /**
     * Joiner.on(separator).skipNulls().join(parts)
     *
     * @author YC
     * Created by 2018/7/12 10:58.
     */
    private void testJoinerSkipNullsFun() {
        String joinString = Joiner.on(" - ").skipNulls().join("test1", null, "test2");
        System.out.println(joinString);
    }

    /**
     * Joiner.on(separator).join(parts);
     *
     * @author YC
     * Created by 2018/7/12 10:57.
     */
    private void testJoinerIsNullException() {
        String joinString = Joiner.on(" - ").join("test1", null, "test2");
        System.out.println(joinString);
    }

    /**
     * Joiner.on(separator).join(parts);
     *
     * @author YC
     * Created by 2018/7/12 10:57.
     */
    private void testJoinerStringArrayList() {
        List<String> stringList = new ArrayList<>();
        stringList.add("test1");
        stringList.add("test2");
        stringList.add("test3");
        stringList.add("test4");
        String  joinStringArrayList = Joiner.on(" - ").join(stringList);
        System.out.println(joinStringArrayList);
    }

    /**
     * Joiner.on(separator).join(parts);
     *
     * @author YC
     * Created by 2018/7/12 10:57.
     */
    private void testJoinerString() {
        String joinString = Joiner.on(" - ").join("test", "test2", "test3", "test4");
        System.out.println(joinString);
    }

    /**
     * 字符串分隔 -> Splitter
     * Expression: Splitter.on(separator).split(sequence)
     * 返回值: 返回值为Iterable.
     * 入参: sequence为String.
     *
     * Expression: Splitter.on(separator).omitEmptyStrings().split(sequence)
     * 注: 通过使用omitEmptyStrings(),设置Splitter过滤掉length=0的空字符串.(如果指定分割符之间有空格,会进行分割)
     *
     * @author YC
     * Created by 2018/7/11 18:30.
     */
    @Test
    void testSplitter() {
//        testSplitterString();
        testSplitterIsEmptyString();
    }

    /**
     * Splitter.on(separator).omitEmptyStrings().split(sequence)
     *
     * @author YC
     * Created by 2018/7/12 10:56.
     */
    private void testSplitterIsEmptyString() {
        String word = "test1,,test2";
        Iterable<String> stringIterable = Splitter.on(",").omitEmptyStrings().split(word);
        for (String str : stringIterable) {
            System.out.println(str);
        }
    }

    /**
     * Splitter.on(separator).split(sequence)
     *
     * @author YC
     * Created by 2018/7/12 10:56.
     */
    private void testSplitterString() {
        String word = "today, I'm happy! because i buy a fan!";
        Iterable<String> stringIterable = Splitter.on(",").split(word);
        for (String str : stringIterable) {
            System.out.println(str);
        }
    }


}
