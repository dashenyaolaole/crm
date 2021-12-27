package com._520it.crm.mapper;

import com._520it.crm.domain.Employee;
import com._520it.crm.page.PageResult;
import com._520it.crm.query.EmployeeQueryObject;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EmployeeMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Employee record);

    Employee selectByPrimaryKey(Long id);

    List<Employee> selectAll();

    int updateByPrimaryKey(Employee record);
    //登录
    Employee getEmployeeForLogin(@Param("username") String username, @Param("password") String password);
    //查询员工信息(查询总数和全部员工信息)
    Long queryForPageCount(EmployeeQueryObject qo);
    List<Employee> queryForPage(EmployeeQueryObject qo);
    //修改员工状态
    void updateState(Long id);
}