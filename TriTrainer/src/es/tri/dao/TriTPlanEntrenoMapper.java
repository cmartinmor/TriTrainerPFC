package es.tri.dao;

import es.tri.dao.model.TriTPlanEntreno;
import es.tri.dao.model.TriTPlanEntrenoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TriTPlanEntrenoMapper {
    int deleteByPrimaryKey(Integer id_plan);

    int insert(TriTPlanEntreno record);

    int insertSelective(TriTPlanEntreno record);

    List<TriTPlanEntreno> selectByExample(TriTPlanEntrenoExample example);

    TriTPlanEntreno selectByPrimaryKey(Integer id_plan);

    int updateByExampleSelective(@Param("record") TriTPlanEntreno record, @Param("example") TriTPlanEntrenoExample example);

    int updateByExample(@Param("record") TriTPlanEntreno record, @Param("example") TriTPlanEntrenoExample example);

    int updateByPrimaryKeySelective(TriTPlanEntreno record);

    int updateByPrimaryKey(TriTPlanEntreno record);
}