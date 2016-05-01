package com.caboose.io.sorrymsjackson.wrapper;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

/**
 * DESCRIPTION
 */
public class ObjectWrapper extends Wrapper {
    final ObjectNode obj = mapper.createObjectNode();

    public ObjectWrapper (Object ... values){
        for (int i = 0; i < values.length; i+=2) {
            if (i + 1 < values.length){
                String key = (String)values[i];
                set(key, values[i+1]);
            }
        }
    }

    private void set (String key, Object value){
        if (value instanceof Wrapper){
            Wrapper typedValue = (Wrapper)value;
            obj.set(key, typedValue.toJson());
        } else if (value instanceof JsonNode){
            JsonNode typedValue = (JsonNode)value;
            obj.set(key, typedValue);
        } else if (value instanceof Integer){
            Integer typedValue = (Integer)value;
            obj.put(key, typedValue);
        } else if (value instanceof Double){
            Double typedValue = (Double)value;
            obj.put(key, typedValue);
        } else if (value instanceof Boolean){
            Boolean typedValue = (Boolean)value;
            obj.put(key, typedValue);
        } else if (value instanceof String){
            String typedValue = (String)value;
            obj.put(key, typedValue);
        } else if (value == null){
            obj.putNull(key);
        }
    }

    public ObjectWrapper (String key, Wrapper value){
        obj.set(key, value.toJson());
    }

    public ObjectWrapper (String key, JsonNode value){
        obj.set(key, value);
    }

    public ObjectWrapper (String key, Integer value){
        obj.put(key, value);
    }

    public ObjectWrapper (String key, Double value){
        obj.put(key, value);
    }

    public ObjectWrapper (String key, Boolean value){
        obj.put(key, value);
    }

    public ObjectWrapper (String key, String value){
        obj.put(key, value);
    }


    public JsonNode toJson() {
        return obj;
    }
}
