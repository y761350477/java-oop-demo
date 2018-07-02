package test.json;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import test.json.pojo.User;

/**
 * fastjson反序列化,如果属性为空,映射成json,在不显示属性的问题.
 *
 * 出处:
 * 1. 在bdpms项目中,方法返回json数据的操作时,使用fastjson操作后,返回的json属性数据不全的问题.
 *
 * 验证结果:
 * 1. fastjson反序列化,如果bean中的属性为null,则解析成json默认不显示此属性,如果属性为"",则正常显示.
 *
 * 总结:
 * 1. jackson使用中未发现这个问题.
 * 2. 如果非要使用fastjson处理json信息的话,需要判断每个属性是否为null,然后进行操作.
 *
 * @author YC
 * Created by 2018-07-02 9:07
 */
public class JsonTest2 {

    public static void main(String[] args) {
        String string = "{\n" +
                "  \"name\": null,\n" +
                "  \"sex\": \"n\",\n" +
                "  \"address\": \"\"\n" +
                "}";
        // Example1
        User user = JSON.parseObject(string, User.class);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("user", user);
        System.out.println(jsonObject.toString());

        // Example2
        User user1 = JSON.parseObject(string, User.class);
        JSONObject jsonObject1 = new JSONObject();
        // 处理方法很笨,不建议使用
        String name = user.getName() == null ? "" : user.getName();
        user1.setName(name);
        jsonObject1.put("user1", user1);
        System.out.println(jsonObject1.toJSONString());

    }
}
