package com._520it.crm.web.controller;

import com._520it.crm.domain.Employee;
import com._520it.crm.page.PageResult;
import com._520it.crm.query.EmployeeQueryObject;
import com._520it.crm.service.IEmployeeService;
import com._520it.crm.util.UserContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@Controller
public class EmployeeController {
    @Autowired
    private IEmployeeService employeeService;
    @RequestMapping("/employee")
    public String index(){
        //System.out.println("EmployeeController.index()");
        return "employee";
    }

    @RequestMapping("/employee_list")
    @ResponseBody
    public PageResult list(EmployeeQueryObject qo){
        PageResult result = null;
        result = employeeService.queryForPage(qo);
        return result;
    }

    @RequestMapping("/employee_save")
    @ResponseBody
    public Map<String,Object> save(Employee emp){
        HashMap<String,Object> result = new HashMap<String,Object>();
        try{
            emp.setPassword("888888");
            emp.setAdmin(false);
            emp.setState(true);
            employeeService.insert(emp);
            result.put("success",true);
            result.put("msg","保存成功");
        }catch (Exception e){
            result.put("success",false);
            result.put("msg","保存异常，请联系管理员");
        }
        return result;
    }

    @RequestMapping("/employee_update")
    @ResponseBody
    public Map<String,Object> update(Employee emp){
        HashMap<String,Object> result = new HashMap<String,Object>();
        try{
            employeeService.updateByPrimaryKey(emp);
            result.put("success",true);
            result.put("msg","更新成功");
        }catch (Exception e){
            e.printStackTrace();
            result.put("success",false);
            result.put("msg","更新异常，请联系管理员");
        }
        return result;
    }

    @RequestMapping("/employee_delete")
    @ResponseBody
    public Map<String,Object> delete(Long id){
        HashMap<String,Object> result = new HashMap<String,Object>();
        try{
            employeeService.updateState(id);
            result.put("success",true);
            result.put("msg","离职成功");
        }catch (Exception e){
            e.printStackTrace();
            result.put("success",false);
            result.put("msg","离职异常，请联系管理员");
        }
        return result;
    }

    //登录方法
    @RequestMapping("/login")
    @ResponseBody
    public Map<String,Object> login(String username, String password, HttpSession session){
        Map<String,Object> result = new HashMap<String,Object>();
        Employee currentUser = employeeService.getEmployeeForLogin(username,password);
        if(currentUser!=null){
            session.setAttribute(UserContext.USERINSESSION,currentUser);
            result.put("success",true);
            result.put("msg","登陆成功");
        }else {
            result.put("success",false);
            result.put("msg","账号密码有误");
        }
        return result;
    }
}
