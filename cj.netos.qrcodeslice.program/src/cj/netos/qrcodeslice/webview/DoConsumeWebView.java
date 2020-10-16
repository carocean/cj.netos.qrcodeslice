package cj.netos.qrcodeslice.webview;

import cj.netos.qrcodeslice.IUcRemote;
import cj.netos.qrcodeslice.model.QrcodeSlice;
import cj.studio.ecm.annotation.CjService;
import cj.studio.ecm.annotation.CjServiceRef;
import cj.studio.ecm.net.Circuit;
import cj.studio.ecm.net.CircuitException;
import cj.studio.ecm.net.Frame;
import cj.studio.ecm.net.http.HttpFrame;
import cj.studio.gateway.socket.app.IGatewayAppSiteResource;
import cj.studio.gateway.socket.app.IGatewayAppSiteWayWebView;
import cj.ultimate.gson2.com.google.gson.Gson;
import cj.ultimate.util.StringUtil;

import java.util.HashMap;
import java.util.Map;

@CjService(name = "/doConsume.service")
public class DoConsumeWebView implements IGatewayAppSiteWayWebView {
    @CjServiceRef
    IUcRemote ucRemote;

    @Override
    public void flow(Frame frame, Circuit circuit, IGatewayAppSiteResource resource) throws CircuitException {
        Map<String, String> map = new HashMap<>();
        String verifyCode = frame.parameter("verifyCode");
        if (StringUtil.isEmpty(verifyCode)) {
            map.put("status", "404");
            map.put("message", "缺少参数 verifyCode");
            circuit.content().writeBytes(new Gson().toJson(map).getBytes());
            return;
        }
        HttpFrame f = (HttpFrame) frame;
        String store = (String) f.session().attribute("verifyCode");
        String person = (String) f.session().attribute("person");
        QrcodeSlice slice = (QrcodeSlice) f.session().attribute("qrslice");
        boolean yes = verifyCode.equals(store);

        if (!yes) {
            map.put("status", "1001");
            map.put("message", "验证码不正确");
            circuit.content().writeBytes(new Gson().toJson(map).getBytes());
            return;
        }
        f.session().removeAttribute("verifyCode");
        f.session().removeAttribute("person");
        try {
            ucRemote.consumeQrcodeSlice(person, slice.getId());
            map.put("status", "200");
            map.put("message", "ok");
            circuit.content().writeBytes(new Gson().toJson(map).getBytes());
        } catch (Exception e) {
            map.put("status", "1002");
            map.put("message", e.getMessage());
            circuit.content().writeBytes(new Gson().toJson(map).getBytes());
            return;
        }
    }
}
