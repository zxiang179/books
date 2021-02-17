package tianjin.geektime.design.pattern.Article_15;

import com.google.gson.Gson;

import java.util.Collections;
import java.util.Map;

/**
 * Created by tianjin on 2021/1/16.
 */
public class Serialization {

    private static final String IDENTIFIER_STRING = "UEUEUE;";

    private Gson gson;

    public Serialization(){
        this.gson = new Gson();
    }

    public String serialize(Map<String,String> object){
        StringBuilder textBuilder = new StringBuilder();
        textBuilder.append(IDENTIFIER_STRING);
        textBuilder.append(gson.toJson(object));
        return textBuilder.toString();
    }

    public Map<String,String> deserialize(String text){
        if(!text.startsWith(IDENTIFIER_STRING)){
            return Collections.emptyMap();
        }
        String gsonStr = text.substring(IDENTIFIER_STRING.length());
        return gson.fromJson(gsonStr,Map.class);
    }
}
