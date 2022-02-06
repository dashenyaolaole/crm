<%--
  Created by IntelliJ IDEA.
  User: hangkai
  Date: 2021/10/8
  Time: 23:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>员工管理</title>
    <%@include file="common.jsp"%>
    <script type="text/javascript" src="/js/views/employee.js"></script>
</head>
<body>
<table id="emp_datagrid"></table>
<!-- 新增、更新对话框 -->
<div id="emp_dialog">
    <form method="post" id="emp_form">
        <table align="center" style="margin-top: 15px">
            <input type="hidden" name="id"/>
            <tr>
                <td>账号</td>
                <td><input type="text" name="username"></td>
            </tr>
            <tr>
                <td>真实姓名</td>
                <td><input type="text" name="realname"></td>
            </tr>
            <tr>
                <td>联系方式</td>
                <td><input type="text" name="tel"></td>
            </tr>
            <tr>
                <td>邮箱</td>
                <td><input type="text" name="email"></td>
            </tr>
            <tr>
                <td>部门</td>
                <td><input type="text" name="dept.id" class="easyui-combobox" data-options="valueField:'id',textField:'name',url:'/department_queryForEmp'"></td>
            </tr>
            <tr>
                <td>入职时间</td>
                <td><input type="text" name="inputtime" class="easyui-datebox"></td>
            </tr>
        </table>
    </form>
</div>
<!-- 数据表格的顶部按钮 -->
<div id="emp_datagrid_tb">
    <div>
        <a class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="add()">新增</a>
        <a id="emp_datagrid_edit" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="edit()">编辑</a>
        <a id="emp_datagrid_delete" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="del()">离职</a>
        <a class="easyui-linkbutton" iconCls="icon-reload" plain="true" onclick="reload()">刷新</a>
    </div>
    关键字查询：<input name="KeyWord"><a class="easyui-linkbutton" iconCls="icon-search" onclick="searchBtn()">搜索</a>
</div>
<!-- 对话框的底部按钮 -->
<div id="emp_dialog_bt">
    <a class="easyui-linkbutton" iconCls="icon-save" plain="true" onclick="save()">保存</a>
    <a class="easyui-linkbutton" iconCls="icon-cancel" plain="true" onclick="cancel()">取消</a>
</div>
</body>
</html>
