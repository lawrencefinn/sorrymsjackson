package com.caboose.io.sorrymsjackson;
import com.caboose.io.sorrymsjackson.wrapper.ArrayWrapper;
import com.caboose.io.sorrymsjackson.wrapper.ObjectWrapper;
import com.caboose.io.sorrymsjackson.wrapper.Wrapper;
import com.fasterxml.jackson.databind.JsonNode;

/**
 * DESCRIPTION
 */
public class Json {
    public static JsonNode JO(String key, Wrapper obj){
        return new ObjectWrapper(key, obj).toJson();
    }
    public static JsonNode JO(String key, JsonNode obj){
        return new ObjectWrapper(key, obj).toJson();
    }
    public static JsonNode JO(String key, JsonNode ... objs){
        return new ObjectWrapper(key, new ArrayWrapper(objs)).toJson();
    }
    public static JsonNode JO(String key, String value){
        return new ObjectWrapper(key, value).toJson();
    }
    public static JsonNode JO(Object ... values){
        return new ObjectWrapper(values).toJson();
    }
    public static JsonNode JA(Wrapper... obj ){
        return new ArrayWrapper(obj).toJson();
    }
    public static JsonNode JA(JsonNode... obj ){
        return new ArrayWrapper(obj).toJson();
    }
    public static JsonNode JA(Object... obj ){
        return new ArrayWrapper(obj).toJson();
    }
    public static JsonNode JA(){
        return new ArrayWrapper().toJson();
    }
}
