package com.caboose.io.sorrymsjackson.wrapper;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;

/**
 * DESCRIPTION
 */
public class ArrayWrapper extends Wrapper {
    final ArrayNode arr = mapper.createArrayNode();

    public ArrayWrapper(){

    }

    public ArrayWrapper(Object[] objs){
        for (Object obj : objs) {
            add(obj);
        }

    }

    private void add (Object value){
        if (value instanceof Wrapper){
            Wrapper typedValue = (Wrapper)value;
            arr.add(typedValue.toJson());
        } else if (value instanceof JsonNode){
            JsonNode typedValue = (JsonNode)value;
            arr.add(typedValue);
        } else if (value instanceof Integer){
            Integer typedValue = (Integer)value;
            arr.add(typedValue);
        } else if (value instanceof Double){
            Double typedValue = (Double)value;
            arr.add(typedValue);
        } else if (value instanceof Boolean){
            Boolean typedValue = (Boolean)value;
            arr.add(typedValue);
        } else if (value instanceof String){
            String typedValue = (String)value;
            arr.add(typedValue);
        } else if (value == null){
            arr.addNull();
        }
    }

    public ArrayWrapper(Wrapper[] objs){
        for (Wrapper obj : objs) {
            arr.add(obj.toJson());
        }
    }

    public ArrayWrapper(JsonNode[] inputs){
        for (JsonNode input : inputs) {
            arr.add(input);
        }
    }

    public ArrayWrapper(Integer[] inputs){
        for (Integer input : inputs) {
            arr.add(input);
        }
    }

    public ArrayWrapper(Double[] inputs){
        for (Double input : inputs) {
            arr.add(input);
        }
    }

    public ArrayWrapper(Boolean[] inputs){
        for (Boolean input : inputs) {
            arr.add(input);
        }
    }

    public ArrayWrapper(String[] inputs){
        for (String input : inputs) {
            arr.add(input);
        }
    }

    public JsonNode toJson() {
        return arr;
    }
}
