package cj.netos.qrcodeslice.webview;

import cj.netos.qrcodeslice.IUcRemote;
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

import java.util.Map;

@CjService(name = "/sendVerifycode.service")
public class SendVerifycodeWebView implements IGatewayAppSiteWayWebView {
    @CjServiceRef
    IUcRemote ucRemote;

    @Override
    public void flow(Frame frame, Circuit circuit, IGatewayAppSiteResource resource) throws CircuitException {
        String phone = frame.parameter("phone");
        if (StringUtil.isEmpty(phone)) {
            throw new CircuitException("404", "缺少参数 phone");
        }
        Map<String, Object> map = ucRemote.sendVerifyCode(phone);
        HttpFrame f = (HttpFrame) frame;
        String verifyCode = (String) map.get("verifyCode");
        String person = (String) map.get("person");
        f.session().attribute("verifyCode", verifyCode);
        f.session().attribute("person", person);
        circuit.content().writeBytes(person.getBytes());
    }
}
