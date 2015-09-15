package es.tri.dao;

import es.tri.dao.model.TriTTest;
import es.tri.dao.model.TriTTestExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TriTTestMapper {
    int deleteByPrimaryKey(Integer idTest);

    int insert(TriTTest record);

    int insertSelective(TriTTest record);

    List<TriTTest> selectByExample(TriTTestExample example);

    TriTTest selectByPrimaryKey(Integer idTest);

    int updateByExampleSelective(@Param("record") TriTTest record, @Param("example") TriTTestExample example);

    int updateByExample(@Param("record") TriTTest record, @Param("example") TriTTestExample example);

    int updateByPrimaryKeySelective(TriTTest record);

    int updateByPrimaryKey(TriTTest record);
}