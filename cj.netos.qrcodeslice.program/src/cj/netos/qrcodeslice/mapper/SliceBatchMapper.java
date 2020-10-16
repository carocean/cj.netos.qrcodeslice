package cj.netos.qrcodeslice.mapper;

import cj.netos.qrcodeslice.model.SliceBatch;
import cj.netos.qrcodeslice.model.SliceBatchExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SliceBatchMapper {

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    long countByExample(SliceBatchExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int deleteByExample(SliceBatchExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int deleteByPrimaryKey(String id);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int insert(SliceBatch record);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int insertSelective(SliceBatch record);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    List<SliceBatch> selectByExample(SliceBatchExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    SliceBatch selectByPrimaryKey(String id);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByExampleSelective(@Param("record") SliceBatch record, @Param("example") SliceBatchExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByExample(@Param("record") SliceBatch record, @Param("example") SliceBatchExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByPrimaryKeySelective(SliceBatch record);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByPrimaryKey(SliceBatch record);
}