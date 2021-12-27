package com._520it.crm.service.impl;

import com._520it.crm.domain.Employee;
import com._520it.crm.mapper.EmployeeMapper;
import com._520it.crm.page.PageResult;
import com._520it.crm.query.EmployeeQueryObject;
import com._520it.crm.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.List;

@Service
public class EmployeeServiceImpl implements IEmployeeService {
    @Resource
    private EmployeeMapper employeeDao;

    public int deleteByPrimaryKey(Long id) {
        return employeeDao.deleteByPrimaryKey(id);
    }

    public int insert(Employee record) {
        int effectCount = employeeDao.insert(record);
        return effectCount;
    }

    public Employee selectByPrimaryKey(Long id) {
        return employeeDao.selectByPrimaryKey(id);
    }

    public List<Employee> selectAll() {
        return employeeDao.selectAll();
    }

    public int updateByPrimaryKey(Employee record) {
        return employeeDao.updateByPrimaryKey(record);
    }

    @Override
    public Employee getEmployeeForLogin(String username, String password) {
        return employeeDao.getEmployeeForLogin(username, password);
    }

    @Override
    public PageResult queryForPage(EmployeeQueryObject qo) {
        //查询总的记录数
        Long count = employeeDao.queryForPageCount(qo);
        if(count==0){
            return new PageResult(0, Collections.EMPTY_LIST);
        }
        List result = employeeDao.queryForPage(qo);
        //查询总的结果集
        return new PageResult(count.intValue(),result);
    }

    @Override
    public void updateState(Long id) {
        employeeDao.updateState(id);
    }
}
