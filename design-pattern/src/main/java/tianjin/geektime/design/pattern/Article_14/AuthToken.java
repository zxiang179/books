package tianjin.geektime.design.pattern.Article_14;

import com.sun.org.apache.regexp.internal.RE;

import java.util.Map;

/**
 * Created by tianjin on 2021/1/2.
 */
public class AuthToken {

    private static final long DEFAULT_EXPIRED_TIME_INTERVAL = 60 * 1000;
    private String token;
    private long createTime;
    private long expiredTimeInterval = DEFAULT_EXPIRED_TIME_INTERVAL;

    public AuthToken(String token, long createTime) {
        this.token = token;
        this.createTime = createTime;
    }

    public AuthToken(String token, long createTime, long expiredTimeInterval) {
        this.token = token;
        this.createTime = createTime;
        this.expiredTimeInterval = expiredTimeInterval;
    }

    public static AuthToken create(String baseUrl, long createTime, Map<String, String> params) {
        return new AuthToken("token", createTime);
    }

    public String getToken() {
        return this.token;
    }

    public boolean isExpired() {
        return System.currentTimeMillis() - this.createTime > this.expiredTimeInterval;
    }

    public boolean match(AuthToken authToken) {
        return this.equals(authToken);
    }

}
