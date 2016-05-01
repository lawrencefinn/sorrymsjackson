package com.caboose.io.sorrymsjackson.wrapper;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * DESCRIPTION
 */
public abstract class Wrapper {
    final static ObjectMapper mapper = new ObjectMapper();
    public abstract JsonNode toJson();
}
