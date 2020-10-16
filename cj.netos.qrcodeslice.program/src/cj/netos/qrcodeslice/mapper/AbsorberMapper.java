package cj.netos.qrcodeslice.mapper;

import cj.netos.qrcodeslice.model.Absorber;
import cj.netos.qrcodeslice.model.AbsorberExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AbsorberMapper {

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    long countByExample(AbsorberExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int deleteByExample(AbsorberExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int deleteByPrimaryKey(String id);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int insert(Absorber record);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int insertSelective(Absorber record);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    List<Absorber> selectByExample(AbsorberExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    Absorber selectByPrimaryKey(String id);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByExampleSelective(@Param("record") Absorber record, @Param("example") AbsorberExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByExample(@Param("record") Absorber record, @Param("example") AbsorberExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByPrimaryKeySelective(Absorber record);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByPrimaryKey(Absorber record);

    long totalCatCount(@Param(value = "qrsliceId") String qrsliceId);

    List<Absorber> listCats(@Param(value = "qrsliceId") String qrsliceId);

}