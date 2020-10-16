package cj.netos.qrcodeslice.mapper;

import cj.netos.qrcodeslice.RecipientsBalanceBillResult;
import cj.netos.qrcodeslice.model.RecipientsBalanceBill;
import cj.netos.qrcodeslice.model.RecipientsBalanceBillExample;
import org.apache.ibatis.annotations.Param;
import java.util.List;

public interface RecipientsBalanceBillMapper {

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    long countByExample(RecipientsBalanceBillExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int deleteByExample(RecipientsBalanceBillExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int deleteByPrimaryKey(String sn);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int insert(RecipientsBalanceBill record);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int insertSelective(RecipientsBalanceBill record);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    List<RecipientsBalanceBill> selectByExample(RecipientsBalanceBillExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    RecipientsBalanceBill selectByPrimaryKey(String sn);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByExampleSelective(@Param("record") RecipientsBalanceBill record, @Param("example") RecipientsBalanceBillExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByExample(@Param("record") RecipientsBalanceBill record, @Param("example") RecipientsBalanceBillExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByPrimaryKeySelective(RecipientsBalanceBill record);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByPrimaryKey(RecipientsBalanceBill record);

    List<RecipientsBalanceBillResult> pageBill(@Param(value = "qrcodeSlice") String qrcodeSlice, @Param(value = "limit") Long limit, @Param(value = "offset") Long offset);
}