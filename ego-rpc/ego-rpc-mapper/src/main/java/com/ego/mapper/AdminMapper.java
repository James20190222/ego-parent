package com.ego.mapper;

import com.ego.pojo.Admin;
import com.ego.pojo.AdminExample;
import com.ego.pojo.AdminWithBLOBs;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AdminMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_admin
     *
     * @mbg.generated Mon Apr 08 13:37:18 CST 2019
     */
    long countByExample(AdminExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_admin
     *
     * @mbg.generated Mon Apr 08 13:37:18 CST 2019
     */
    int deleteByExample(AdminExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_admin
     *
     * @mbg.generated Mon Apr 08 13:37:18 CST 2019
     */
    int deleteByPrimaryKey(Short adminId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_admin
     *
     * @mbg.generated Mon Apr 08 13:37:18 CST 2019
     */
    int insert(AdminWithBLOBs record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_admin
     *
     * @mbg.generated Mon Apr 08 13:37:18 CST 2019
     */
    int insertSelective(AdminWithBLOBs record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_admin
     *
     * @mbg.generated Mon Apr 08 13:37:18 CST 2019
     */
    List<AdminWithBLOBs> selectByExampleWithBLOBs(AdminExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_admin
     *
     * @mbg.generated Mon Apr 08 13:37:18 CST 2019
     */
    List<Admin> selectByExample(AdminExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_admin
     *
     * @mbg.generated Mon Apr 08 13:37:18 CST 2019
     */
    AdminWithBLOBs selectByPrimaryKey(Short adminId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_admin
     *
     * @mbg.generated Mon Apr 08 13:37:18 CST 2019
     */
    int updateByExampleSelective(@Param("record") AdminWithBLOBs record, @Param("example") AdminExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_admin
     *
     * @mbg.generated Mon Apr 08 13:37:18 CST 2019
     */
    int updateByExampleWithBLOBs(@Param("record") AdminWithBLOBs record, @Param("example") AdminExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_admin
     *
     * @mbg.generated Mon Apr 08 13:37:18 CST 2019
     */
    int updateByExample(@Param("record") Admin record, @Param("example") AdminExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_admin
     *
     * @mbg.generated Mon Apr 08 13:37:18 CST 2019
     */
    int updateByPrimaryKeySelective(AdminWithBLOBs record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_admin
     *
     * @mbg.generated Mon Apr 08 13:37:18 CST 2019
     */
    int updateByPrimaryKeyWithBLOBs(AdminWithBLOBs record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_admin
     *
     * @mbg.generated Mon Apr 08 13:37:18 CST 2019
     */
    int updateByPrimaryKey(Admin record);
}