package cj.netos.qrcodeslice.webview;

import cj.netos.qrcodeslice.IQrsliceService;
import cj.netos.qrcodeslice.IUcRemote;
import cj.netos.qrcodeslice.model.Absorber;
import cj.netos.qrcodeslice.model.QrcodeSlice;
import cj.studio.ecm.annotation.CjService;
import cj.studio.ecm.annotation.CjServiceRef;
import cj.studio.ecm.net.Circuit;
import cj.studio.ecm.net.CircuitException;
import cj.studio.ecm.net.Frame;
import cj.studio.gateway.socket.app.IGatewayAppSiteResource;
import cj.studio.gateway.socket.app.IGatewayAppSiteWayWebView;
import cj.ultimate.gson2.com.google.gson.Gson;
import cj.ultimate.util.StringUtil;

import java.util.List;

@CjService(name = "/unconsumes.json")
public class UnconsumeQrsliceWebView implements IGatewayAppSiteWayWebView {
    @CjServiceRef
    IQrsliceService qrsliceService;
    @CjServiceRef
    IUcRemote ucRemote;

    @Override
    public void flow(Frame frame, Circuit circuit, IGatewayAppSiteResource resource) throws CircuitException {
        String qrslice = frame.parameter("qrslice");
        if (StringUtil.isEmpty(qrslice)) {
            throw new CircuitException("404", "缺少参数 qrslice");
        }
        List<QrcodeSlice> resultList = qrsliceService.listUnconsumeSlices(qrslice);
        circuit.content().writeBytes(new Gson().toJson(resultList).getBytes());
    }
}
