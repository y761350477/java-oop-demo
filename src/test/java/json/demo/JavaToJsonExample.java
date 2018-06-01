package json.demo;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * java转json
 *
 * @author YC
 * Created by 2018/5/31 17:25.
 */
public class JavaToJsonExample {

    /**
     * json序列化
     * java -> json
     * collection -> json
     *
     * @author YC
     * Created by 2018/6/1 17:24.
     */
    @Test
    void toJson() throws JsonProcessingException {
        User user = new User("小晨", 20, new Date(), "yc@qq.com");

        /**
         * ObjectMapper是JSON操作的核心，Jackson的所有JSON操作都是在ObjectMapper中实现。
         * ObjectMapper有多个JSON序列化的方法，可以把JSON字符串保存File、OutputStream等不同的介质中。
         * writeValue(File arg0, Object arg1)把arg1转成json序列，并保存到arg0文件中。
         * writeValue(OutputStream arg0, Object arg1)把arg1转成json序列，并保存到arg0输出流中。
         * writeValueAsBytes(Object arg0)把arg0转成json序列，并把结果输出成字节数组。
         * writeValueAsString(Object arg0)把arg0转成json序列，并把结果输出成字符串。
         */
        ObjectMapper objectMapper = new ObjectMapper();

        // bean -> json
        String valueAsString = objectMapper.writeValueAsString(user);
        System.out.println(valueAsString);

        // java集合 -> json
        List<User> userList = new ArrayList<>();
        userList.add(user);
        String valueAsString1 = objectMapper.writeValueAsString(userList);
        System.out.println(valueAsString1);
    }

    /**
     * json反序列化
     * json -> java
     *
     * @author YC
     * Created by 2018/6/1 17:24.
     */
    @Test
    void toJava() throws IOException {
        String json = "{\"name\":\"小晨\",\"age\":20,\"birthday\":1527841627634,\"email\":\"yc@qq.com\"}";

        ObjectMapper objectMapper = new ObjectMapper();
        User user = objectMapper.readValue(json, User.class);
        System.out.println(user.getName());
        System.out.println(user.getAge());
        System.out.println(user.getBirthday());
        System.out.println(user.getEmail());
    }

    /**
     * json注解的使用
     *
     * @author YC
     * Created by 2018/6/1 17:24.
     */
    @Test
    void annotations() throws IOException {
        // json反序列化的操作,注意email的名称改成了e.
        String json = "{\"name\":\"小晨\",\"age\":20,\"birthday\":1527841627634,\"e\":\"yc@qq.com\"}";
        ObjectMapper objectMapper = new ObjectMapper();
        UserPro userPro = objectMapper.readValue(json, UserPro.class);
        System.out.println(userPro.getName());
        System.out.println(userPro.getAge());
        System.out.println(userPro.getBirthday());
        System.out.println(userPro.getEmail());
        System.out.println();

        // json序列化的操作,注意打印信息.
        UserPro userPro1 = new UserPro("小晨", 20, new Date(), "yc@qq.com");
        String string = objectMapper.writeValueAsString(userPro1);
        System.out.println(string);
    }
}
