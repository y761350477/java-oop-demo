package json.demo4;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.junit.jupiter.api.Test;
import pojo.User;

import java.io.IOException;

/**
 * jackson节点增加数据
 *
 * @author YC
 * Created by 2018-07-13 17:54
 */
public class Example {

    private ObjectMapper objectMapper = new ObjectMapper();

    /**
     * 插入数据.
     *
     * @author YC
     * Created by 2018/7/13 18:00.
     */
    @Test
    void test1() throws IOException {
        User user = new User("yc",22,"上海","男");

        String userJson = objectMapper.writeValueAsString(user);
        //language=JSON
        String json = "{\n" +
                "  \"data\" : \"test\"\n" +
                "}";
        ObjectNode objectNode = (ObjectNode) objectMapper.readTree(json);
        objectNode.put("insert", userJson);

        String resultJson = objectNode.toString();
        System.out.println(resultJson);
    }

    /**
     * 更改数据.
     *
     * @author YC
     * Created by 2018/7/13 18:00.
     */
    @Test
    void test2() throws IOException {
        User user = new User("yc",22,"上海","男");

        String userJson = objectMapper.writeValueAsString(user);
        //language=JSON
        String json = "{\n" +
                "  \"data\" : \"test\"\n" +
                "}";
        ObjectNode objectNode = (ObjectNode) objectMapper.readTree(json);
        objectNode.put("data", userJson);

        String resultJson = objectNode.toString();
        System.out.println(resultJson);
    }
}
