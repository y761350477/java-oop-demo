package test.json;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.ObjectMapper;
import json.demo2.User;

import java.io.IOException;

/**
 * 验证jackson解析空字符串反序列化到bean时报错的问题
 *
 * 出处:
 * 1. 在bdpms项目中,进行反序列化操作时,出现解析的请求参数为null的情况时,但是由于fastjson处理同样的情况没有报错,
 * 造成的困惑,浪费了很多时间.
 *
 * 验证结果:
 * 1. jackson解析空字符串反序列化到bean时会报错.
 *
 * 特点:
 *  1. jackson如何解析空字符串反序列化,会报错,而fastjson在不会.
 *  2. 试着尝试jackson的配置信息设置来解决这个问题,尝试了很多但还是无效.
 *  3. 经过多次的尝试验证,可以使用"{}"来解决jackson处理空字符串反序列化报错的问题.
 *
 * 总结:
 *  1. 如果非要使用jackson处理反序列化的情况,应首先考虑空字符串的问题,加上判断再进行反序列化操作.
 *
 *
 * @author YC
 * Created by 2018-07-02 8:41
 */
public class JsonTest1 {

    public static void main(String[] args) throws IOException {
        /*ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(JsonParser.Feature.AUTO_CLOSE_SOURCE, true);*/
        String string = "";
        /*String asString = objectMapper.writeValueAsString(string);
        User user = new User();
        User readValue = objectMapper.readValue(asString, User.class);
        System.out.println(readValue.getName());*/

        JSONObject jsonObject = new JSONObject();
        User user = JSON.parseObject(string, User.class);
        System.out.println(user.getName());

    }
}
