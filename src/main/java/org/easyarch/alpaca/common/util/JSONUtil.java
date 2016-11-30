package org.easyarch.alpaca.common.util;/**
 * Description : 
 * Created by YangZH on 16-5-29
 *  下午5:50
 */

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.MapUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Description :
 * Created by YangZH on 16-5-29
 * 下午5:50
 */

public class JSONUtil {

    public static List<String> str2Array(String json) {
        if (StringUtils.isEmpty(json))
            return null;
        return JSONArray.parseArray(json, String.class);
    }

    public static Map<String, Object> str2Map(String json) {
        if (StringUtils.isEmpty(json))
            return null;
        JSONObject jsonObject = JSON.parseObject(json);
        Map<String, Object> params = new HashMap<String, Object>();
        for (Map.Entry<String, Object> entry : jsonObject.entrySet()) {
            params.put(entry.getKey(), entry.getValue());
        }
        return params;
    }

    public static boolean isJson(String string) {
        try {
            JSON.parseObject(string);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static String list2Json(List list) {
        if (CollectionUtils.isEmpty(list))
            return "";
        return JSON.parseArray(JSON.toJSONString(list, true)).toString();
    }

    public static<T> List<T> json2List(String json,Class<T> cls){
        if (StringUtils.isEmpty(json)){
            return new ArrayList<T>();
        }
        return JSON.parseArray(json,cls);
    }

    public static String pojo2Json(Object object) {
        if (object == null)
            return "";
        return JSON.toJSONString(object, true);
    }
    public static<T> T json2Pojo(String json,Class<T> clz) {
        if (StringUtils.isEmpty(json))
            return null;
        return JSONObject.parseObject(json,clz);
    }

    public static<T> byte[] pojo2Bytes(Object object){
        if (object == null)
            return null;
        return JSON.toJSONBytes(object);
    }

    public static<T> T bytes2Pojo(byte[] bytes,Class<T> clz){
        if (ArrayUtils.isEmpty(bytes))
            return null;
        return JSON.parseObject(bytes,0,bytes.length, Charset.forName("UTF-8"),clz);
    }

    public static String map2Json(Map<String,Object> jsonMap){
        if (MapUtils.isEmpty(jsonMap))
            return "";
        JSONObject jsonObject = new JSONObject(jsonMap);
        return jsonObject.toJSONString();
    }
    public static Map<String,Object> json2Map(String json){
        if (StringUtils.isEmpty(json))
            return null;
        JSONObject object = str2Json(json);
        Map<String,Object> jsonMap = new HashMap<String,Object>();
        for (Map.Entry<String,Object> entry:object.entrySet()){
            jsonMap.put(entry.getKey(),entry.getValue());
        }
        return jsonMap;
    }

    public static JSONObject str2Json(String str) {
        if (StringUtils.isEmpty(str))
            return null;
        return JSON.parseObject(str);
    }

    /**
     * 从一段json中按key获取array
     *
     * @param key
     * @param json
     * @return
     */
    public static JSONArray getArrayFromStr(String key, String json) {
        JSONObject object = JSON.parseObject(json);
        return (JSONArray) object.get(key);
    }

    public static JSONArray getArrayFromJSON(String key, JSONObject json) {
        return (JSONArray) json.get(key);
    }

    public static<T> T map2Pojo(Map<String,Object> jsonMap,Class<T> clz){
        if (MapUtils.isEmpty(jsonMap))
            return null;
        return json2Pojo(map2Json(jsonMap),clz);
    }

    public static Map<String,Object> pojo2Map(Object object){
        if (object == null)
            return null;
        return json2Map(pojo2Json(object));
    }


    public static String addKV(String json,String key,String value){
        Map<String,Object> jsonMap = json2Map(json);
        jsonMap.put(key,value);
        return map2Json(jsonMap);
    }
}
