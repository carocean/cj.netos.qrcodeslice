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

@CjService(name = "/ProductDownloadUrl.json")
public class ProductDownloadUrlWebView implements IGatewayAppSiteWayWebView {
    @CjServiceRef
    IUcRemote ucRemote;

    @Override
    public void flow(Frame frame, Circuit circuit, IGatewayAppSiteResource resource) throws CircuitException {
        Object map = ucRemote.getNewestVersionDownloadUrls("microgeo");
        circuit.content().writeBytes(new Gson().toJson(map).getBytes());
    }
}
