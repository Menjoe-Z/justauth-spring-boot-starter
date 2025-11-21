package com.xkcoding.justauth.enums;

import me.zhyd.oauth.config.AuthSource;
import me.zhyd.oauth.request.AuthDefaultRequest;
import me.zhyd.oauth.request.AuthDingTalkV2Request;

public enum AuthCustomSource implements AuthSource {
    /**
     * DINGTALK_V2_WQYL
     * 钉钉企业版, 支持另一个内部应用主体登录
     */
    DINGTALK_V2_WQYL {
        @Override
        public String authorize() {
            return "https://login.dingtalk.com/oauth2/challenge.htm";
        }

        @Override
        public String accessToken() {
            return "https://api.dingtalk.com/v1.0/oauth2/userAccessToken";
        }

        @Override
        public String userInfo() {
            return "https://api.dingtalk.com/v1.0/contact/users/me";
        }

        @Override
        public Class<? extends AuthDefaultRequest> getTargetClass() {
            return AuthDingTalkV2Request.class;
        }
    }
}
