package cj.netos.qrcodeslice.webview;

import cj.netos.qrcodeslice.IUcRemote;
import cj.studio.ecm.annotation.CjService;
import cj.studio.ecm.annotation.CjServiceRef;
import cj.studio.ecm.net.Circuit;
import cj.studio.ecm.net.CircuitException;
import cj.studio.ecm.net.Frame;
import cj.studio.gateway.socket.app.IGatewayAppSiteResource;
import cj.studio.gateway.socket.app.IGatewayAppSiteWayWebView;
import cj.ultimate.gson2.com.google.gson.Gson;

import java.util.HashMap;

@CjService(name = "/market.json")
public class ProductMarketWebView implements IGatewayAppSiteWayWebView {
    @CjServiceRef
    IUcRemote ucRemote;

    @Override
    public void flow(Frame frame, Circuit circuit, IGatewayAppSiteResource resource) throws CircuitException {
        Object list = ucRemote.listOpenedMarket("microgeo");
        String defaultMarket = ucRemote.getDefaultMarket("microgeo");
        HashMap map = new HashMap();
        map.put("default", defaultMarket);
        map.put("markets", list);
        circuit.content().writeBytes(new Gson().toJson(map).getBytes());
    }
}
