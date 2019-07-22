package com.qf.eason.dao;

import com.qf.eason.pojo.Symptom;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.data.repository.query.Param;

import java.util.List;
@Mapper
public interface SymptomMapper {
    /**
     * 根据症状所属查症状名称
     * @return 症状名称id
     */
    public List<Symptom> findByBadyParts(@Param("badyParts") String badyParts);

    /**
     * 根据id查症状信息
     * @param id
     * @return
     */
    public List<Symptom> findById(@Param("Id") Integer id);
}
