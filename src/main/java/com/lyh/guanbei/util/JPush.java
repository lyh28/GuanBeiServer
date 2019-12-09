package com.lyh.guanbei.util;

import cn.jpush.api.JPushClient;
import cn.jpush.api.push.model.Message;
import cn.jpush.api.push.model.Platform;
import cn.jpush.api.push.model.PushPayload;
import cn.jpush.api.push.model.audience.Audience;
import cn.jpush.api.push.model.audience.AudienceTarget;

import java.util.List;
import java.util.Map;

public class JPush {
    private static final String app_key="fb9ce5ba75aa60a687ba8c7a";
    private static final String master_secret="20fd77dace91a06f91e172d3";
    public static JPushClient getJPushClient(){
        return new JPushClient(master_secret,app_key);
    }
    public static PushPayload buildAndroidSingleAlias(String alias, Map<String,String> extra, String msgContent) {
        return PushPayload.newBuilder()
                .setPlatform(Platform.android())
                .setAudience(Audience.newBuilder()
                        .addAudienceTarget(AudienceTarget.alias(alias))
                        .build())
                .setMessage(Message.newBuilder()
                        .setMsgContent(msgContent)
                        .addExtras(extra)
                        .build())
                .build();
    }
}
