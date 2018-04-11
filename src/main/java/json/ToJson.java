package json;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 1. 转换成json格式;
 * 2. 获取json格式的string字符串中的属性值;
 *
 * @author YC
 * @create 2018/4/11 17:13.
 */
public class ToJson {

    public static void main(String[] args) throws IOException {
        // map Created by YC.
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
        System.out.println("list -> json:\t" + listAsString);
        // map -> json Created by YC.
        String mapAsSting = objectMapper.writeValueAsString(map);
        System.out.println("map -> json:\t" + mapAsSting);
        // map -> get attribute value by YC.
        JsonNode mapJsonNode = objectMapper.readTree(mapAsSting);
        JsonNode mapJsonNodeName = mapJsonNode.path("name");
        System.out.println("get attribute value:\t" + mapJsonNodeName);
    }
}
