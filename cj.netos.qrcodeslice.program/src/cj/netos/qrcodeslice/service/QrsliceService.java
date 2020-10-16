package cj.netos.qrcodeslice.service;

import cj.netos.qrcodeslice.IQrsliceService;
import cj.netos.qrcodeslice.RecipientsBalanceBillResult;
import cj.netos.qrcodeslice.RecipientsRank;
import cj.netos.qrcodeslice.mapper.*;
import cj.netos.qrcodeslice.model.*;
import cj.studio.ecm.annotation.CjService;
import cj.studio.ecm.annotation.CjServiceRef;
import cj.studio.orm.mybatis.annotation.CjTransaction;

import java.math.BigDecimal;
import java.util.List;

@CjService(name = "qrsliceService")
public class QrsliceService implements IQrsliceService {
    @CjServiceRef(refByName = "mybatis.cj.netos.qrcodeslice.mapper.QrcodeSliceMapper")
    QrcodeSliceMapper qrcodeSliceMapper;
    @CjServiceRef(refByName = "mybatis.cj.netos.qrcodeslice.mapper.SlicePropMapper")
    SlicePropMapper slicePropMapper;
    @CjServiceRef(refByName = "mybatis.cj.netos.qrcodeslice.mapper.AbsorberMapper")
    AbsorberMapper absorberMapper;
    @CjServiceRef(refByName = "mybatis.cj.netos.qrcodeslice.mapper.RecipientsMapper")
    RecipientsMapper recipientsMapper;
    @CjServiceRef(refByName = "mybatis.cj.netos.qrcodeslice.mapper.RecipientsBalanceMapper")
    RecipientsBalanceMapper recipientsBalanceMapper;
    @CjServiceRef(refByName = "mybatis.cj.netos.qrcodeslice.mapper.RecipientsRecordMapper")
    RecipientsRecordMapper recipientsRecordMapper;
    @CjServiceRef(refByName = "mybatis.cj.netos.qrcodeslice.mapper.RecipientsBalanceBillMapper")
    RecipientsBalanceBillMapper recipientsBalanceBillMapper;

    @CjTransaction
    @Override
    public QrcodeSlice getQrslice(String sliceId) {
        return qrcodeSliceMapper.selectByPrimaryKey(sliceId);
    }

    @CjTransaction
    @Override
    public List<SliceProp> getQrsliceProps(String sliceId) {
        SlicePropExample example = new SlicePropExample();
        example.createCriteria().andQrcodeSliceEqualTo(sliceId);
        return slicePropMapper.selectByExample(example);
    }

    @CjTransaction
    @Override
    public BigDecimal totalBalances(String sliceId) {
        return recipientsBalanceMapper.totalBalances(sliceId);
    }

    @CjTransaction
    @Override
    public long totalCatCount(String sliceId) {
        return absorberMapper.totalCatCount(sliceId);
    }

    @CjTransaction
    @Override
    public long totalUnconsumeQrslice(String sliceId) {
        return qrcodeSliceMapper.totalUnconsumeQrslice(sliceId);
    }

    @CjTransaction
    @Override
    public List<RecipientsRank> getRecipientsRank(String sliceId, int count) {
        return recipientsRecordMapper.getRecipientsRank(sliceId, count);
    }

    @CjTransaction
    @Override
    public List<RecipientsBalanceBillResult> pageRecipientsBalance(String qrslice, Long limit, Long offset) {
        return recipientsBalanceBillMapper.pageBill(qrslice, limit, offset);
    }
    @CjTransaction
    @Override
    public List<Absorber> listCats(String qrslice) {
        return absorberMapper.listCats(qrslice);
    }
    @CjTransaction
    @Override
    public List<QrcodeSlice> listUnconsumeSlices(String qrslice) {
        return qrcodeSliceMapper.listUnconsumeSlices(qrslice);
    }
}
