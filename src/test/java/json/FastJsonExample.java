package json;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import org.junit.jupiter.api.Test;

public class FastJsonExample {

    /**
     * 出现$ref、$.test[0]的问题
     * 原因:
     * 1. 重复添加相同的对象到JSONArray所致.
     *
     * @author YC
     * Created by 2018/5/30 16:55.
     */
    @Test
    void test1() {
        JSONObject jsonObject = new JSONObject();
        JSONObject jsonObject1 = new JSONObject();
        JSONArray jsonArray = new JSONArray();
        for (int i = 0; i < 3; i++) {
            jsonObject1.put("a", "a");
            jsonArray.add(jsonObject1);
        }
        jsonObject.put("test", jsonArray);
        String string1 = jsonObject.toString();
        System.out.println(string1);
    }

    /**
     * 即使test1()出现重复对象的问题,也是有解决方案的.
     *
     * @author YC
     * Created by 2018/5/30 17:02.
     */
    @Test
    void test2() {
        JSONObject jsonObject = new JSONObject();
        JSONObject jsonObject1 = new JSONObject();
        JSONArray jsonArray = new JSONArray();
        for (int i = 0; i < 3; i++) {
            jsonObject1.put("a", "a");
            jsonArray.add(jsonObject1);
        }
        // JSONArray转成String
        JSONArray.toJSONString(jsonArray, SerializerFeature.DisableCircularReferenceDetect);

        // String转成JSONArray
        Object parse = JSONObject.parse(JSONArray.toJSONString(jsonArray, SerializerFeature.DisableCircularReferenceDetect));
        jsonObject.put("test", parse);
        String string = jsonObject.toJSONString();
        System.out.println(string);
    }

    /**
     * 自己傻逼了,因为一个重复添加的相同对象的问题,花了两个多小时才清醒过来,本来完成只需几分钟的事情
     * 关键点:
     *  1. 循环体中对对象进行赋值,对象应放到循环体内,不然最后的结果为最后一次的结果,但是在fastjson中直接报$ref、$.test[0]的问题.
     *  2. 没有仔细观察,因为代码乱,而关注点转移.
     *  3. 总是不观察,而先入为主.
     *
     * @author YC
     * Created by 2018/5/30 17:04.
     */
    @Test
    void test3() {
        JSONArray jsonArray = new JSONArray();
        for (int i = 0; i < 3; i++) {
            JSONObject object = new JSONObject();
            object.put("a", "a");
            jsonArray.add(object);
        }

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("test", jsonArray);
        String string = jsonObject.toString();
        System.out.println(string);
    }

}
