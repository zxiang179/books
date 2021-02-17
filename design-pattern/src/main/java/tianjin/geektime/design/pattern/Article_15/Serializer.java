package tianjin.geektime.design.pattern.Article_15;

import com.google.gson.Gson;

import java.util.Map;

/**
 * Created by tianjin on 2021/1/16.
 */
public class Serializer {

    private static final String IDENTIFIER_STRING = "UEUEUE;";

    private Gson gson;

    public Serializer(){
        this.gson = new Gson();
    }

    public String serialize(Map<String,String> object){
        StringBuilder textBuilder = new StringBuilder();
        textBuilder.append(IDENTIFIER_STRING);
        textBuilder.append(gson.toJson(object));
        return textBuilder.toString();
    }

}
