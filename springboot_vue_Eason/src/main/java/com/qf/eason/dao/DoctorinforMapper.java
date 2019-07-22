package com.qf.eason.dao;

import com.qf.eason.pojo.Doctorinfor;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
/**
 * 曹阳
 * 2019/07/20
 */
import java.util.List;
@Mapper
public interface DoctorinforMapper {

    /**
     * 根据条件查询医生（搜索模糊查询其中条件在xml文件中）
     * @param string 前台传过来的值
     * @return 医生的集合
     */
    public List<Doctorinfor> findAll(@Param("temp") String string);

    /**
     * 无条件查询所有医生
     * @return 所有医生
     */
    public List<Doctorinfor> load();
    /**
     * 根据id查询医生(精确查询)
     * @param id 医生的id
     * @return 医生的对象
     */
    public Doctorinfor findById(@Param("id") Integer id);



    /**
     * 根据医院等级查询
     * @param Strinng 医院的等级
     * @return 医生的集合
     */
    public List<Doctorinfor> find(@Param("hospital") String Strinng);
}
