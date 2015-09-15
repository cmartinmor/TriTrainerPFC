package es.tri.dao;

import es.tri.dao.model.TriTClasificacionEjercicios;
import es.tri.dao.model.TriTClasificacionEjerciciosExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TriTClasificacionEjerciciosMapper {
    int deleteByPrimaryKey(Integer id_clasificacion_ejercicio);

    int insert(TriTClasificacionEjercicios record);

    int insertSelective(TriTClasificacionEjercicios record);

    List<TriTClasificacionEjercicios> selectByExample(TriTClasificacionEjerciciosExample example);

    TriTClasificacionEjercicios selectByPrimaryKey(Integer id_clasificacion_ejercicio);

    int updateByExampleSelective(@Param("record") TriTClasificacionEjercicios record, @Param("example") TriTClasificacionEjerciciosExample example);

    int updateByExample(@Param("record") TriTClasificacionEjercicios record, @Param("example") TriTClasificacionEjerciciosExample example);

    int updateByPrimaryKeySelective(TriTClasificacionEjercicios record);

    int updateByPrimaryKey(TriTClasificacionEjercicios record);
}