package tianjin.geektime.design.pattern.Article_14;

/**
 * Created by tianjin on 2021/1/2.
 */
public interface ApiAuthencator {

    void auth(String url);
    void auth(ApiRequest apiRequest);

}
