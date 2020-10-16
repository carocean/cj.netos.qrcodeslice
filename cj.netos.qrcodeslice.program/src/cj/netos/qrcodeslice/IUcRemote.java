package cj.netos.qrcodeslice;

import cj.studio.ecm.net.CircuitException;

import java.util.Map;

public interface IUcRemote {
    Map<String, Object> getPerson(String person) throws CircuitException;

    Map<String, Object> autologin() throws CircuitException;

    boolean existsAccount(String phone) throws CircuitException;

    Map<String, Object> sendVerifyCode(String phone) throws CircuitException;

    void consumeQrcodeSlice(String person, String qrslice) throws CircuitException;

}
