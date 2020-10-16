package cj.netos.qrcodeslice.program;

import cj.netos.qrcodeslice.IQrsliceService;
import cj.netos.qrcodeslice.IUcRemote;
import cj.netos.qrcodeslice.RecipientsRank;
import cj.netos.qrcodeslice.model.QrcodeSlice;
import cj.netos.qrcodeslice.model.SliceProp;
import cj.studio.ecm.annotation.CjService;
import cj.studio.ecm.annotation.CjServiceRef;
import cj.studio.ecm.net.Circuit;
import cj.studio.ecm.net.CircuitException;
import cj.studio.ecm.net.Frame;
import cj.studio.ecm.net.http.HttpFrame;
import cj.studio.ecm.net.session.ISession;
import cj.studio.gateway.socket.app.IGatewayAppSiteResource;
import cj.studio.gateway.socket.app.IGatewayAppSiteWayWebView;
import cj.ultimate.util.StringUtil;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

@CjService(name = "/")
public class Home implements IGatewayAppSiteWayWebView {
    @CjServiceRef(refByName = "qrsliceService")
    IQrsliceService qrsliceService;
    @CjServiceRef
    IUcRemote ucRemote;

    @Override
    public void flow(Frame frame, Circuit circuit, IGatewayAppSiteResource resource) throws CircuitException {
        String sliceId = frame.parameter("id");
        if (StringUtil.isEmpty(sliceId)) {
            throw new CircuitException("404", "缺少参数 id");
        }
        QrcodeSlice slice = qrsliceService.getQrslice(sliceId);
        if (slice == null) {
            throw new CircuitException("404", "码片不存在");
        }

        HttpFrame f = (HttpFrame) frame;
        ISession session = f.session();
        session.attribute("publisher", ucRemote.getPerson(slice.getCreator()));
        session.attribute("qrslice", slice);
        List<SliceProp> propList = qrsliceService.getQrsliceProps(sliceId);
        session.attribute("sliceProps", propList);
        BigDecimal amount = qrsliceService.totalBalances(sliceId);
        session.attribute("totalBalances", amount);
        long catCount = qrsliceService.totalCatCount(sliceId);
        session.attribute("catCount", catCount);
        long unconsumeCount = qrsliceService.totalUnconsumeQrslice(sliceId);
        session.attribute("unconsumeCount", unconsumeCount);
        Map<String, Object> tokenInfo = ucRemote.autologin();
        session.attribute("tokenInfo", tokenInfo);
        List<RecipientsRank> ranks = qrsliceService.getRecipientsRank(sliceId, 10);
        for (RecipientsRank rank : ranks) {
            rank.setPersonInfo(ucRemote.getPerson(rank.getRecipient()));
        }
        session.attribute("recipientsRank", ranks);

        String url = String.format("/%s", frame.rootName());
        if (slice.getState() == 1) {
            resource.redirect(String.format("%s/consumed.html", url), circuit);
            return;
        }
        resource.redirect(String.format("%s/unconsume.html", url), circuit);
    }

}
