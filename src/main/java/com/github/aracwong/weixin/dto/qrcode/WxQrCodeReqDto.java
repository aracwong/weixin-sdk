package com.github.aracwong.weixin.dto.qrcode;

import com.google.gson.annotations.SerializedName;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/**
 * @author zpwang
 * @version 1.0.0
 */
@Data
@ToString
public class WxQrCodeReqDto implements Serializable {

    @SerializedName("expire_seconds")
    private long expireSeconds;

    @SerializedName("action_name")
    private String actionName;

    @SerializedName("action_info")
    private ActionInfo actionInfo = new ActionInfo();

    @Data
    @ToString
    public class ActionInfo {

        @SerializedName("scene")
        private Scene scene = new Scene();

        @Data
        @ToString
        public class Scene {
            @SerializedName("scene_id")
            private long sceneId;

            @SerializedName("scene_str")
            private String sceneStr;
        }
    }

}
