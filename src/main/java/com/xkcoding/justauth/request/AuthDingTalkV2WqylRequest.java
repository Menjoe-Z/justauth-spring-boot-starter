package com.xkcoding.justauth.request;

import com.xkcoding.justauth.enums.AuthCustomSource;
import me.zhyd.oauth.cache.AuthStateCache;
import me.zhyd.oauth.config.AuthConfig;
import me.zhyd.oauth.config.AuthDefaultSource;
import me.zhyd.oauth.model.AuthCallback;
import me.zhyd.oauth.model.AuthToken;
import me.zhyd.oauth.model.AuthUser;
import me.zhyd.oauth.request.AuthDefaultRequest;
import me.zhyd.oauth.request.AuthDingTalkV2Request;
import me.zhyd.oauth.request.AuthRequest;

/**
 * 钉钉企业版-企业内应用授权，组合
 */
public class AuthDingTalkV2WqylRequest extends AuthDefaultRequest {

    private AuthDingTalkV2Request authDingTalkV2Request;

    public AuthDingTalkV2WqylRequest(AuthConfig config) {
        super(config, AuthCustomSource.DINGTALK_V2_WQYL);
    }

    public AuthDingTalkV2WqylRequest(AuthConfig config, AuthStateCache authStateCache) {
        super(config, AuthCustomSource.DINGTALK_V2_WQYL, authStateCache);
        authDingTalkV2Request = new AuthDingTalkV2Request(config, authStateCache);
    }


    @Override
    public AuthToken getAccessToken(AuthCallback authCallback) {
        return authDingTalkV2Request.getAccessToken(authCallback);
    }

    @Override
    public AuthUser getUserInfo(AuthToken authToken) {
        AuthUser userInfo = authDingTalkV2Request.getUserInfo(authToken);
        userInfo.setSource(AuthCustomSource.DINGTALK_V2_WQYL.name());
        return userInfo;
    }
}
