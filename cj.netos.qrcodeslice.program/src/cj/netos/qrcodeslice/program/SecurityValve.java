package cj.netos.qrcodeslice.program;

import cj.studio.ecm.Scope;
import cj.studio.ecm.annotation.CjService;
import cj.studio.ecm.net.CircuitException;
import cj.studio.ecm.net.http.HttpCircuit;
import cj.studio.ecm.net.http.HttpFrame;
import cj.studio.ecm.net.session.ISession;
import cj.studio.gateway.socket.pipeline.IAnnotationInputValve;
import cj.studio.gateway.socket.pipeline.IIPipeline;
import cj.ultimate.util.StringUtil;

@CjService(name = "securityValve", scope = Scope.multiton)
public class SecurityValve implements IAnnotationInputValve {
    @Override
    public int getSort() {
        return 0;
    }

    @Override
    public void onActive(String inputName, IIPipeline pipeline) throws CircuitException {
        pipeline.nextOnActive(inputName, this);
    }

    @Override
    public void flow(Object request, Object response, IIPipeline pipeline) throws CircuitException {
        if (request instanceof HttpFrame) {
            HttpFrame frame = (HttpFrame) request;
            HttpCircuit circuit = (HttpCircuit) response;
            if ("/".equals(frame.relativePath())||frame.relativePath().startsWith("/error/")) {//首页是开放的
                pipeline.nextFlow(request, response, this);
                return;
            }
            ISession session = frame.session();
            if (session == null) {
                pipeline.nextFlow(request, response, this);
                return;
            }
            Object qrslice = session.attribute("qrslice");
            if (qrslice == null) {
                frame.url("/");
                pipeline.nextFlow(request, response, this);
                return;
            }
        }
        pipeline.nextFlow(request, response, this);
    }

    @Override
    public void onInactive(String inputName, IIPipeline pipeline) throws CircuitException {
        pipeline.nextOnInactive(inputName, this);
    }
}
