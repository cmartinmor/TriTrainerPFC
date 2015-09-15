package es.tri.dao;

import es.tri.dao.model.TriTHistorico;
import es.tri.dao.model.TriTHistoricoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TriTHistoricoMapper {
    int deleteByPrimaryKey(Integer idHistorico);

    int insert(TriTHistorico record);

    int insertSelective(TriTHistorico record);

    List<TriTHistorico> selectByExample(TriTHistoricoExample example);

    TriTHistorico selectByPrimaryKey(Integer idHistorico);

    int updateByExampleSelective(@Param("record") TriTHistorico record, @Param("example") TriTHistoricoExample example);

    int updateByExample(@Param("record") TriTHistorico record, @Param("example") TriTHistoricoExample example);

    int updateByPrimaryKeySelective(TriTHistorico record);

    int updateByPrimaryKey(TriTHistorico record);
}