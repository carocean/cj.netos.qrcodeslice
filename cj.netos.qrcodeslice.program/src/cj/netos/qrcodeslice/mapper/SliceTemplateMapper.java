package cj.netos.qrcodeslice.mapper;

import cj.netos.qrcodeslice.model.SliceTemplate;
import cj.netos.qrcodeslice.model.SliceTemplateExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SliceTemplateMapper {

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    long countByExample(SliceTemplateExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int deleteByExample(SliceTemplateExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int deleteByPrimaryKey(String id);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int insert(SliceTemplate record);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int insertSelective(SliceTemplate record);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    List<SliceTemplate> selectByExample(SliceTemplateExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    SliceTemplate selectByPrimaryKey(String id);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByExampleSelective(@Param("record") SliceTemplate record, @Param("example") SliceTemplateExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByExample(@Param("record") SliceTemplate record, @Param("example") SliceTemplateExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByPrimaryKeySelective(SliceTemplate record);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByPrimaryKey(SliceTemplate record);
}