package cj.netos.qrcodeslice.service;

import cj.netos.qrcodeslice.Encript;
import cj.netos.qrcodeslice.IUcRemote;
import cj.studio.ecm.IServiceAfter;
import cj.studio.ecm.IServiceSite;
import cj.studio.ecm.annotation.CjService;
import cj.studio.ecm.annotation.CjServiceSite;
import cj.studio.ecm.net.CircuitException;
import cj.ultimate.gson2.com.google.gson.Gson;
import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

@CjService(name = "ucRemote")
public class UcRemote implements IUcRemote, IServiceAfter {
    @CjServiceSite
    IServiceSite site;

    OkHttpClient client;

    @Override
    public void onAfter(IServiceSite site) {
        client = new OkHttpClient().newBuilder().readTimeout(60, TimeUnit.SECONDS).build();
    }

    @Override
    public Map<String, Object> getPerson(String person) throws CircuitException {
        String appid = site.getProperty("appid");
        String appKey = site.getProperty("appKey");
        String appSecret = site.getProperty("appSecret");
        String portsPerson = site.getProperty("rhub.ports.uc.person");

        String nonce = Encript.md5(String.format("%s%s", UUID.randomUUID().toString(), System.currentTimeMillis()));
        String sign = Encript.md5(String.format("%s%s%s", appKey, nonce, appSecret));
        String url = String.format("%s?person=%s", portsPerson, person);
        final Request request = new Request.Builder()
                .url(url)
                .addHeader("Rest-Command", "findPersonOnSecurity")
                .addHeader("app-id", appid)
                .addHeader("app-key", appKey)
                .addHeader("app-nonce", nonce)
                .addHeader("app-sign", sign)
                .get()
                .build();
        final Call call = client.newCall(request);
        Response response = null;
        try {
            response = call.execute();
        } catch (IOException e) {
            throw new CircuitException("1002", e);
        }
        if (response.code() >= 400) {
            throw new CircuitException("1002", String.format("远程访问失败:%s", response.message()));
        }
        String json = null;
        try {
            json = response.body().string();
        } catch (IOException e) {
            throw new CircuitException("1002", e);
        }
        Map<String, Object> map = new Gson().fromJson(json, HashMap.class);
        if (Double.parseDouble(map.get("status") + "") >= 400) {
            throw new CircuitException(map.get("status") + "", map.get("message") + "");
        }
        json = (String) map.get("dataText");
        map = new Gson().fromJson(json, HashMap.class);
        return map;
    }

    @Override
    public Map<String, Object> autologin() throws CircuitException {
        String appid = site.getProperty("appid");
        String appKey = site.getProperty("appKey");
        String appSecret = site.getProperty("appSecret");
        String portsAuth = site.getProperty("rhub.ports.uc.auth");
        String anonymous = site.getProperty("autologin.anonymous");
        String password = site.getProperty("autologin.password");

        String nonce = Encript.md5(String.format("%s%s", UUID.randomUUID().toString(), System.currentTimeMillis()));
        String sign = Encript.md5(String.format("%s%s%s", appKey, nonce, appSecret));
        String qs = String.format("accountCode=%s&password=%s&device=%s", anonymous, password, nonce);
        String url = null;
        try {
            url = String.format("%s?%s", portsAuth, URLEncoder.encode(qs, "utf-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        final Request request = new Request.Builder()
                .url(url)
                .addHeader("Rest-Command", "auth")
                .addHeader("app-id", appid)
                .addHeader("app-key", appKey)
                .addHeader("app-nonce", nonce)
                .addHeader("app-sign", sign)
                .get()
                .build();
        final Call call = client.newCall(request);
        Response response = null;
        try {
            response = call.execute();
        } catch (IOException e) {
            throw new CircuitException("1002", e);
        }
        if (response.code() >= 400) {
            throw new CircuitException("1002", String.format("远程访问失败:%s", response.message()));
        }
        String json = null;
        try {
            json = response.body().string();
        } catch (IOException e) {
            throw new CircuitException("1002", e);
        }
        Map<String, Object> map = new Gson().fromJson(json, HashMap.class);
        if (Double.parseDouble(map.get("status") + "") >= 400) {
            throw new CircuitException(map.get("status") + "", map.get("message") + "");
        }
        json = (String) map.get("dataText");
        map = new Gson().fromJson(json, HashMap.class);
        return map;
    }

    @Override
    public boolean existsAccount(String phone) throws CircuitException {
        String appid = site.getProperty("appid");
        String appKey = site.getProperty("appKey");
        String appSecret = site.getProperty("appSecret");
        String portsPerson = site.getProperty("rhub.ports.uc.person");

        String nonce = Encript.md5(String.format("%s%s", UUID.randomUUID().toString(), System.currentTimeMillis()));
        String sign = Encript.md5(String.format("%s%s%s", appKey, nonce, appSecret));
        String url = String.format("%s?accountCode=%s", portsPerson, phone);
        final Request request = new Request.Builder()
                .url(url)
                .addHeader("Rest-Command", "existsAccount")
                .addHeader("app-id", appid)
                .addHeader("app-key", appKey)
                .addHeader("app-nonce", nonce)
                .addHeader("app-sign", sign)
                .get()
                .build();
        final Call call = client.newCall(request);
        Response response = null;
        try {
            response = call.execute();
        } catch (IOException e) {
            throw new CircuitException("1002", e);
        }
        if (response.code() >= 400) {
            throw new CircuitException("1002", String.format("远程访问失败:%s", response.message()));
        }
        String json = null;
        try {
            json = response.body().string();
        } catch (IOException e) {
            throw new CircuitException("1002", e);
        }
        Map<String, Object> map = new Gson().fromJson(json, HashMap.class);
        if (Double.parseDouble(map.get("status") + "") >= 400) {
            throw new CircuitException(map.get("status") + "", map.get("message") + "");
        }
        json = (String) map.get("dataText");
        return Boolean.valueOf(json);
    }

    @Override
    public Map<String, Object> sendVerifyCode(String phone) throws CircuitException {
        String appid = site.getProperty("appid");
        String appKey = site.getProperty("appKey");
        String appSecret = site.getProperty("appSecret");
        String portsAuth = site.getProperty("rhub.ports.uc.auth");

        String nonce = Encript.md5(String.format("%s%s", UUID.randomUUID().toString(), System.currentTimeMillis()));
        String sign = Encript.md5(String.format("%s%s%s", appKey, nonce, appSecret));
        String qs = String.format("phone=%s", phone);
        String url = null;
        url = String.format("%s?%s", portsAuth, qs);
        final Request request = new Request.Builder()
                .url(url)
                .addHeader("Rest-Command", "sendVerifyCode")
                .addHeader("app-id", appid)
                .addHeader("app-key", appKey)
                .addHeader("app-nonce", nonce)
                .addHeader("app-sign", sign)
                .get()
                .build();
        final Call call = client.newCall(request);
        Response response = null;
        try {
            response = call.execute();
        } catch (IOException e) {
            throw new CircuitException("1002", e);
        }
        if (response.code() >= 400) {
            throw new CircuitException("1002", String.format("远程访问失败:%s", response.message()));
        }
        String json = null;
        try {
            json = response.body().string();
        } catch (IOException e) {
            throw new CircuitException("1002", e);
        }
        Map<String, Object> map = new Gson().fromJson(json, HashMap.class);
        Double status = Double.parseDouble(map.get("status") + "");
        if (status >= 400) {
            throw new CircuitException(status.intValue() + "", map.get("message") + "");
        }
        json = (String) map.get("dataText");
        map = new Gson().fromJson(json, HashMap.class);
        return map;
    }

    @Override
    public void consumeQrcodeSlice(String consumer, String qrcodeSlice) throws CircuitException {
        String appid = site.getProperty("system.appid");
        String appKey = site.getProperty("system.appKey");
        String appSecret = site.getProperty("system.appSecret");
        String portsRobot = site.getProperty("rhub.ports.robot");

        String nonce = Encript.md5(String.format("%s%s", UUID.randomUUID().toString(), System.currentTimeMillis()));
        String sign = Encript.md5(String.format("%s%s%s", appKey, nonce, appSecret));

        Map<String, Object> personInfo = getPerson(consumer);
        String nickName = (String) personInfo.get("nickName");
        String qs = String.format("consumer=%s&nickName=%s&qrcodeSlice=%s", consumer, nickName, qrcodeSlice);
        String url = String.format("%s?%s", portsRobot, qs);
        final Request request = new Request.Builder()
                .url(url)
                .addHeader("Rest-Command", "consumeQrcodeSlice2")
                .addHeader("app-id", appid)
                .addHeader("app-key", appKey)
                .addHeader("app-nonce", nonce)
                .addHeader("app-sign", sign)
                .get()
                .build();
        final Call call = client.newCall(request);
        Response response = null;
        try {
            response = call.execute();
        } catch (IOException e) {
            throw new CircuitException("1002", e);
        }
        if (response.code() >= 400) {
            throw new CircuitException("1002", String.format("远程访问失败:%s", response.message()));
        }
        String json = null;
        try {
            json = response.body().string();
        } catch (IOException e) {
            throw new CircuitException("1002", e);
        }
        Map<String, Object> map = new Gson().fromJson(json, HashMap.class);
        if (Double.parseDouble(map.get("status") + "") >= 400) {
            throw new CircuitException(map.get("status") + "", map.get("message") + "");
        }
    }

    @Override
    public Map<String, String> getNewestVersionDownloadUrls(String product) throws CircuitException {
        String portsProduct = site.getProperty("rhub.ports.uc.product");

        String qs = String.format("product=%s", product);
        String url = null;
        url = String.format("%s?%s", portsProduct, qs);
        final Request request = new Request.Builder()
                .url(url)
                .addHeader("Rest-Command", "getNewestVersionDownloadUrls")
                .get()
                .build();
        final Call call = client.newCall(request);
        Response response = null;
        try {
            response = call.execute();
        } catch (IOException e) {
            throw new CircuitException("1002", e);
        }
        if (response.code() >= 400) {
            throw new CircuitException("1002", String.format("远程访问失败:%s", response.message()));
        }
        String json = null;
        try {
            json = response.body().string();
        } catch (IOException e) {
            throw new CircuitException("1002", e);
        }
        Map<String, String> map = new Gson().fromJson(json, HashMap.class);
        Double status = Double.valueOf(String.format("%s", map.get("status")));
        if (status >= 400) {
            throw new CircuitException(status.intValue() + "", map.get("message") + "");
        }
        json = (String) map.get("dataText");
        map = new Gson().fromJson(json, HashMap.class);
        return map;
    }
}
