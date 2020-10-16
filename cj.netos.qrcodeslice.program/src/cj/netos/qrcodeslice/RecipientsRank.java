package cj.netos.qrcodeslice;

import java.math.BigDecimal;
import java.util.Map;

public class RecipientsRank {
    String recipient;
    BigDecimal total;
    Map<String,Object> personInfo;

    public Map<String, Object> getPersonInfo() {
        return personInfo;
    }

    public void setPersonInfo(Map<String, Object> personInfo) {
        this.personInfo = personInfo;
    }

    public String getRecipient() {
        return recipient;
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }
}
