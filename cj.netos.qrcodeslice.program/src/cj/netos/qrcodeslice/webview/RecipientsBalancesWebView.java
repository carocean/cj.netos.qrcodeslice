package cj.netos.qrcodeslice.webview;

import cj.netos.qrcodeslice.IQrsliceService;
import cj.netos.qrcodeslice.IUcRemote;
import cj.netos.qrcodeslice.RecipientsBalanceBillResult;
import cj.netos.qrcodeslice.model.RecipientsBalanceBill;
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

@CjService(name = "/recipients/balances.json")
public class RecipientsBalancesWebView implements IGatewayAppSiteWayWebView {
    @CjServiceRef
    IQrsliceService qrsliceService;
    @CjServiceRef
    IUcRemote ucRemote;

    @Override
    public void flow(Frame frame, Circuit circuit, IGatewayAppSiteResource resource) throws CircuitException {
        String _limit = frame.parameter("limit");
        if (StringUtil.isEmpty(_limit)) {
            _limit = "10";
        }

        String _offset = frame.parameter("offset");
        if (StringUtil.isEmpty(_offset)) {
            _offset = "0";
        }
        String qrslice = frame.parameter("qrslice");
        if (StringUtil.isEmpty(qrslice)) {
            throw new CircuitException("404", "缺少参数 qrslice");
        }
        List<RecipientsBalanceBillResult> resultList = qrsliceService.pageRecipientsBalance(qrslice, Long.valueOf(_limit), Long.valueOf(_offset));
        circuit.content().writeBytes(new Gson().toJson(resultList).getBytes());
    }
}
