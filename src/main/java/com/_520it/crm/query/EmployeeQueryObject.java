package com._520it.crm.query;

import lombok.Getter;
import lombok.Setter;

@Setter@Getter
public class EmployeeQueryObject {
    private Integer page;//当前页
    private Integer rows;//每页行数
    //获取开始行数
    public Integer getStart(){
        return (this.page-1)*rows;
    }
}
