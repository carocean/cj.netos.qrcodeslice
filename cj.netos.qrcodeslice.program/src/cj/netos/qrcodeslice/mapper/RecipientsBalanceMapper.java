package cj.netos.qrcodeslice.mapper;

import cj.netos.qrcodeslice.model.RecipientsBalance;
import cj.netos.qrcodeslice.model.RecipientsBalanceExample;
import org.apache.ibatis.annotations.Param;
import java.math.BigDecimal;
import java.util.List;

public interface RecipientsBalanceMapper {

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    long countByExample(RecipientsBalanceExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int deleteByExample(RecipientsBalanceExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int deleteByPrimaryKey(String id);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int insert(RecipientsBalance record);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int insertSelective(RecipientsBalance record);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    List<RecipientsBalance> selectByExample(RecipientsBalanceExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    RecipientsBalance selectByPrimaryKey(String id);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByExampleSelective(@Param("record") RecipientsBalance record, @Param("example") RecipientsBalanceExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByExample(@Param("record") RecipientsBalance record, @Param("example") RecipientsBalanceExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByPrimaryKeySelective(RecipientsBalance record);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByPrimaryKey(RecipientsBalance record);

    BigDecimal totalBalances(@Param(value = "qrcodeSlice") String qrcodeSlice);
}