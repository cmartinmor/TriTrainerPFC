package es.tri.dao;

import es.tri.dao.model.TriTModeloconocimiento;
import es.tri.dao.model.TriTModeloconocimientoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TriTModeloconocimientoMapper {
    int deleteByPrimaryKey(Integer idInferencia);

    int insert(TriTModeloconocimiento record);

    int insertSelective(TriTModeloconocimiento record);

    List<TriTModeloconocimiento> selectByExample(TriTModeloconocimientoExample example);

    TriTModeloconocimiento selectByPrimaryKey(Integer idInferencia);

    int updateByExampleSelective(@Param("record") TriTModeloconocimiento record, @Param("example") TriTModeloconocimientoExample example);

    int updateByExample(@Param("record") TriTModeloconocimiento record, @Param("example") TriTModeloconocimientoExample example);

    int updateByPrimaryKeySelective(TriTModeloconocimiento record);

    int updateByPrimaryKey(TriTModeloconocimiento record);
}