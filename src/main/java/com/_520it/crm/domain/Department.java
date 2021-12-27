package com._520it.crm.domain;

import lombok.Getter;
import lombok.Setter;

@Getter@Setter
public class Department {
    private Long id;
    private String sn;
    private String name;
    private Employee mananger;//经理
    private Department parentId;//父级部门
    private Boolean state;
}