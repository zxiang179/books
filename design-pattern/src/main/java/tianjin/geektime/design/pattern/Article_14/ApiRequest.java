package tianjin.geektime.design.pattern.Article_14;

/**
 * Created by tianjin on 2021/1/2.
 */
public class ApiRequest {

    private String baseUrl;
    private String token;
    private String appId;
    private long timestamp;

    public ApiRequest(String baseUrl, String token, String appId, long timestamp) {
        this.baseUrl = baseUrl;
        this.token = token;
        this.appId = appId;
        this.timestamp = timestamp;
    }

    public static ApiRequest createFromFullUrl(String url){
        return new ApiRequest(url,"token","id",System.currentTimeMillis());
    }

    public String getBaseUrl(){
        return this.baseUrl;
    }

    public String getToken(){
        return this.token;
    }

    public String getAppId(){
        return this.appId;
    }

    public long getTimestamp(){
        return this.timestamp;
    }
}
