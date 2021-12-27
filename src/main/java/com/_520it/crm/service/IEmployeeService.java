package com._520it.crm.service;

import com._520it.crm.domain.Employee;
import com._520it.crm.page.PageResult;
import com._520it.crm.query.EmployeeQueryObject;

import java.util.List;

public interface IEmployeeService {
    int deleteByPrimaryKey(Long id);
    int insert(Employee record);
    Employee selectByPrimaryKey(Long id);
    List<Employee> selectAll();
    int updateByPrimaryKey(Employee record);
    //登录方法
    Employee getEmployeeForLogin(String username, String password);
    //查询员工信息
    PageResult queryForPage(EmployeeQueryObject qo);
    //修改状态（离职）
    void updateState(Long id);
}
