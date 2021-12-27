package com._520it.crm.service.impl;

import com._520it.crm.domain.Department;
import com._520it.crm.mapper.DepartmentMapper;
import com._520it.crm.service.IDepartmentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class DepartmentServiceImpl implements IDepartmentService {
    @Resource
    private DepartmentMapper departmentDao;

    public int deleteByPrimaryKey(Long id) {
        return departmentDao.deleteByPrimaryKey(id);
    }

    public int insert(Department record) {
        int effectCount = departmentDao.insert(record);
        return effectCount;
    }

    public Department selectByPrimaryKey(Long id) {
        return departmentDao.selectByPrimaryKey(id);
    }

    public List<Department> selectAll() {
        return departmentDao.selectAll();
    }

    public int updateByPrimaryKey(Department record) {
        return departmentDao.updateByPrimaryKey(record);
    }

    @Override
    public List queryForEmp() {
        return departmentDao.queryForEmp();
    }

}
