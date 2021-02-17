package tianjin.geektime.design.pattern.Article_14;

import java.util.HashMap;

import static com.sun.deploy.perf.DeployPerfUtil.put;

/**
 * Created by tianjin on 2021/1/2.
 */
public class DefaultApiAuthencatorImpl implements ApiAuthencator{

    private CredentialStorage credentialStorage;

    public DefaultApiAuthencatorImpl() {
    }

    public DefaultApiAuthencatorImpl(CredentialStorage credentialStorage) {
        this.credentialStorage = credentialStorage;
    }

    @Override
    public void auth(String url) {
        // do judge by credential
        ApiRequest apiRequest = ApiRequest.createFromFullUrl(url);
        auth(apiRequest);
    }

    @Override
    public void auth(ApiRequest apiRequest) {
        // do judge by credential storage
        // 通过apiRequest，获取token
        // 判断token是否超时
        // 通过apiRequest中的id获取存储中的token
        // 进行比对
        String appId = apiRequest.getAppId();
        String token = apiRequest.getToken();
        long timestamp = apiRequest.getTimestamp();
        String originUrl = apiRequest.getBaseUrl();

        AuthToken clientAuthToken = new AuthToken(token, timestamp);
        if(clientAuthToken.isExpired()){
            throw new RuntimeException("token expired");
        }
        String password = credentialStorage.getPasswordByAppId(appId);
        AuthToken serverAuthToken = AuthToken.create(originUrl, timestamp, new HashMap<>());
        if(!serverAuthToken.match(clientAuthToken)){
            throw new RuntimeException("token invalid");
        }
    }
}
