package cj.netos.qrcodeslice;


import cj.netos.qrcodeslice.model.Absorber;
import cj.netos.qrcodeslice.model.QrcodeSlice;
import cj.netos.qrcodeslice.model.SliceProp;

import java.math.BigDecimal;
import java.util.List;

public interface IQrsliceService {
    QrcodeSlice getQrslice(String sliceId);

    List<SliceProp> getQrsliceProps(String sliceId);

    BigDecimal totalBalances(String sliceId);

    long totalCatCount(String sliceId);

    long totalUnconsumeQrslice(String sliceId);

    List<RecipientsRank> getRecipientsRank(String sliceId,int count);

    List<RecipientsBalanceBillResult> pageRecipientsBalance(String qrslice, Long valueOf, Long valueOf1);

    List<Absorber> listCats(String qrslice);

    List<QrcodeSlice> listUnconsumeSlices(String qrslice);

}
