package com.barcke.rsa.util;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

/**
 *                  ,;,,;
 *                ,;;'(    社
 *      __      ,;;' ' \   会
 *   /'  '\'~~'~' \ /'\.)  主
 * ,;(      )    /  |.     义
 *,;' \    /-.,,(   ) \    码
 *     ) /       ) / )|    农
 *     ||        ||  \)
 *     (_\       (_\
 *
 * @author Barcke
 * @date 2020/7/27 15:20
 * @version 1.0
 **/
public class JsonUtils {

    private JsonUtils() {
    }

    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    public static JsonNode getNode(String content, String key) throws IOException {
        JsonNode jsonNode = OBJECT_MAPPER.readTree(content);
        return jsonNode.get(key);
    }

    public static String writeValueAsString(Object body) throws JsonProcessingException {
        return OBJECT_MAPPER.writeValueAsString(body);
    }
}
