package cj.netos.qrcodeslice.mapper;

import cj.netos.qrcodeslice.model.SliceProp;
import cj.netos.qrcodeslice.model.SlicePropExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SlicePropMapper {

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    long countByExample(SlicePropExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int deleteByExample(SlicePropExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int deleteByPrimaryKey(@Param("qrcodeSlice") String qrcodeSlice, @Param("propId") String propId);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int insert(SliceProp record);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int insertSelective(SliceProp record);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    List<SliceProp> selectByExample(SlicePropExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    SliceProp selectByPrimaryKey(@Param("qrcodeSlice") String qrcodeSlice, @Param("propId") String propId);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByExampleSelective(@Param("record") SliceProp record, @Param("example") SlicePropExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByExample(@Param("record") SliceProp record, @Param("example") SlicePropExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByPrimaryKeySelective(SliceProp record);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByPrimaryKey(SliceProp record);
}