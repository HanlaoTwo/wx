package com.wx.handler;

import com.wx.builder.TextBuilder;
import com.wx.scriptservice.JavascriptService;
import com.wx.scriptservice.PythonService;
import com.wx.service.WeixinService;
import com.wx.tulingrobot.Robot;
import me.chanjar.weixin.common.api.WxConsts;
import me.chanjar.weixin.common.session.WxSessionManager;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.message.WxMpXmlMessage;
import me.chanjar.weixin.mp.bean.message.WxMpXmlOutMessage;
import org.springframework.stereotype.Component;

import javax.script.ScriptEngine;
import javax.script.ScriptException;
import java.util.Map;

/**
 * @author Binary Wang
 */
@Component public class MsgHandler extends AbstractHandler {

    private String path = MsgHandler.class.getResource("/").getPath() + "scripts/textchat.js";
    private String csdn = "cddn.py";
    private ScriptEngine scriptEngine = JavascriptService.getInstance(path).engine;
    private Robot robot = new Robot();

    @Override public WxMpXmlOutMessage handle(WxMpXmlMessage wxMessage, Map<String, Object> context,
            WxMpService wxMpService, WxSessionManager sessionManager) {

        String out = "你说啥？";
        WeixinService weixinService = (WeixinService) wxMpService;
        if (!wxMessage.getMsgType().equals(WxConsts.XML_MSG_EVENT)) {
            //TODO 可以选择将消息保存到本地
        }
        String in = wxMessage.getContent();
        if ("csdn".equals(in)) {
            out = PythonService.runScript("csdn.py");
        } else if (in.equals("刷新")) {
            scriptEngine = JavascriptService.getNewInstance(path).engine;
            out = "已刷新";
        } else if (in.contains("你爸") || in.contains("你妈")) {
            out = "CodeFucker";
        } else if (in.equals("吃饭")) {
            try {
                out = scriptEngine.eval("chat(\'" + in + "\')").toString();
            } catch (ScriptException e) {
                e.printStackTrace();
            }
        } else {
            out = robot.Chat(in);
        }
        return new TextBuilder().build(out, wxMessage, weixinService);

    }

}
