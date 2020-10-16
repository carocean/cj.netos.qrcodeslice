package cj.netos.qrcodeslice.mapper;

import cj.netos.qrcodeslice.model.QrcodeSlice;
import cj.netos.qrcodeslice.model.QrcodeSliceExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface QrcodeSliceMapper {

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    long countByExample(QrcodeSliceExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int deleteByExample(QrcodeSliceExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int deleteByPrimaryKey(String id);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int insert(QrcodeSlice record);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int insertSelective(QrcodeSlice record);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    List<QrcodeSlice> selectByExample(QrcodeSliceExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    QrcodeSlice selectByPrimaryKey(String id);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByExampleSelective(@Param("record") QrcodeSlice record, @Param("example") QrcodeSliceExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByExample(@Param("record") QrcodeSlice record, @Param("example") QrcodeSliceExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByPrimaryKeySelective(QrcodeSlice record);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByPrimaryKey(QrcodeSlice record);

    long totalUnconsumeQrslice(@Param(value = "qrsliceId") String qrsliceId);

    List<QrcodeSlice> listUnconsumeSlices(@Param(value = "qrsliceId") String qrsliceId);

}