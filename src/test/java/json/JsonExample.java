package json;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JsonExample {

    /**
     * 操作:
     * 1. 转换成json格式;
     * 2. 获取json格式的节点信息;
     * 问题:
     * 1. json -> json之后的数据无法进行节点获取,因多了边缘双引号造成的问题.
     * 2. 获取的节点信息有双引号,使用asText()方法解决,发现asLong()等方法省去了类型转换的操作.
     *
     * @author YC
     * @create 2018/5/11 13:34.
     */
    @Test
    void test1() throws IOException {
        Map map = new HashMap();
        map.put("name", "YangChen");
        map.put("age", 25);
        map.put("sex", "男");

        Map map1 = new HashMap();
        map1.put("name", "XiaWenJin");
        map1.put("age", 25);
        map1.put("sex", "男");

        Map map2 = new HashMap();
        map2.put("name", "TianTian");
        map2.put("age", 25);
        map2.put("sex", "男");

        // list Created by YC.
        List<Map> userList = new ArrayList<>();
        userList.add(map);
        userList.add(map1);
        userList.add(map2);

        ObjectMapper objectMapper = new ObjectMapper();
        // list -> json Created by YC.
        String listAsString = objectMapper.writeValueAsString(userList);
        System.out.println("listAsString:\t" + listAsString);
        System.out.println("list -> json:\t" + listAsString);
        // map -> json Created by YC.
        String mapAsSting = objectMapper.writeValueAsString(map);
        System.out.println("map -> json:\t" + mapAsSting);
        // map -> get attribute value by YC.
        JsonNode mapJsonNode = objectMapper.readTree(mapAsSting);

        // 获取节点信息
        JsonNode mapJsonNodeName = mapJsonNode.path("name");
        System.out.println("get attribute value:\t" + mapJsonNodeName);

        // json -> json会出现两端加上双引号,导致获取节点失败.(获取不到节点信息,困扰很长时间的地方)
        String valueAsString = objectMapper.writeValueAsString(mapAsSting);
        JsonNode jsonNode = objectMapper.readTree(valueAsString);
        System.out.println("获取json -> json:\t" + jsonNode.path("name"));

        // 获取节点信息后,有双引号的解决方案 -> asText()方法.
        JsonNode jsonNode1 = objectMapper.readTree(mapAsSting);
        System.out.println("除去多余引号的方案:\t" + jsonNode1.path("name").asText());

    }

}
