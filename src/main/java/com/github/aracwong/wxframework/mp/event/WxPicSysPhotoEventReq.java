package com.github.aracwong.wxframework.mp.event;

import com.github.aracwong.wxframework.mp.core.WxEventRequest;
import com.github.aracwong.wxframework.mp.core.WxRequest;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.Data;
import org.w3c.dom.NodeList;

import java.util.ArrayList;
import java.util.List;

/**
 * 弹出系统拍照发图的事件推送
 *
 * @author zpwang
 * @version 1.0.0
 */
@Data
@XStreamAlias("xml")
public class WxPicSysPhotoEventReq extends WxEventRequest {

    @XStreamAlias("EventKey")
    private String eventKey;

    @XStreamAlias("SendPicsInfo")
    private SendPicsInfo sendPicsInfo = new SendPicsInfo();

    @Data
    public class SendPicsInfo {

        @XStreamAlias("Count")
        private int count;

        @XStreamAlias("PicList")
        private List<PicItem> picList = new ArrayList<>();

        @Data
        public class PicItem {
            @XStreamAlias("PicMd5Sum")
            private String picMd5Sum;
        }
    }



    public WxPicSysPhotoEventReq(WxRequest request) {
        super(request);
        this.eventKey = request.getParameter("//EventKey");
        this.sendPicsInfo.setCount(Integer.parseInt(request.getParameter("//SendPicsInfo/Count")));
        NodeList nodeList = (NodeList) request.getNodeListParameter("//SendPicsInfo/PicList/item");
        for (int i = 0; i < nodeList.getLength(); i++) {
            SendPicsInfo.PicItem picItem = this.sendPicsInfo.new PicItem();
            picItem.setPicMd5Sum(request.getParameter("//SendPicsInfo/PicList/item/PicMd5Sum"));
            this.sendPicsInfo.getPicList().add(picItem);
        }
    }
}


