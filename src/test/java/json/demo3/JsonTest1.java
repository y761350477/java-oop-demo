package json.demo3;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import json.demo3.pojo.User;
import org.apache.logging.log4j.core.util.JsonUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * 处理json数组的情况的操作
 *
 * @author YC
 * Created by 2018-07-02 15:34
 */
public class JsonTest1 {

    public static void main(String[] args) throws IOException {
        String json = "[\n" +
                "  {\n" +
                "    \"name\": \"name1\",\n" +
                "    \"sex\": \"sex1\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"name2\",\n" +
                "    \"sex\": \"sex2\"\n" +
                "  }\n" +
                "]";

        ObjectMapper objectMapper = new ObjectMapper();

        List<User> userList = new ArrayList();
        JavaType javaType = objectMapper.getTypeFactory().constructParametricType(List.class, User.class);
        List<User> list = objectMapper.readValue(json, javaType);
        for (User user: list) {
            System.out.println(user.getName());
        }
    }
}
