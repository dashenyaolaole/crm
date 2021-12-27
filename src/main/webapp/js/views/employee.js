$(function () {
    $("#emp_datagrid").datagrid({
        fit:true,//无外边框
        url:'/employee_list',
        fitColumns:true,
        rownumbers:true,//行号
        pagination:true,
        toolbar:'#emp_datagrid_tb',
        pageList:[2,10,20,30,40,50],
        singleSelect:true,
        onClickRow:function(rowIndex, rowData){
            if(rowData.state){
                $("#emp_datagrid_edit,#emp_datagrid_delete").linkbutton("enable");
            }else {
                //按钮禁用
                $("#emp_datagrid_edit,#emp_datagrid_delete").linkbutton("disable");
            }
        },
        columns:[
            [
                {field:'username',align:'center',title:'用户名',width:1},
                {field:'realname',align:'center',title:'真实名称',width:1},
                {field:'tel',align:'center',title:'电话',width:1},
                {field:'email',align:'center',title:'邮箱',width:1},
                {field:'dept',align:'center',title:'部门',width:1,formatter:deptFormatter},
                {field:'inputtime',align:'center',title:'入职时间',width:1},
                {field:'state',align:'center',title:'状态',width:1,formatter:stateFormatter},
                {field:'admin',align:'center',title:'是否超级管理员',width:1,formatter:adminFormatter}
            ]
        ]
    });
    $("#emp_dialog").dialog({
        width:300,
        height:300,
        buttons:"#emp_dialog_bt",
        closed:true
    })
});
function deptFormatter(value,record,index){
    return value?value.name:"";
}

function stateFormatter(value,record,index){
    if(value){
        return "<font color='green'>正常</font>";
    }
    return "<font color='red'>离职</font>";
}

function adminFormatter(value,record,index){
    if(value){
        return "是";
    }
    return "否";
}
//打开对话框
function add() {
    $("#emp_dialog").dialog("open");
    $("#emp_dialog").dialog("setTitle","新增");
    $("#emp_form").form("clear");
}
//发送新增/更新请求
function save() {
    var idVal = $("#emp_form [name='id']").val();
    console.log(idVal);
    var url;
    if (idVal){
        url = '/employee_update'
    }else {
        url = '/employee_save'
    }
    //发送异步请求
    $("#emp_form").form("submit",{
        url:url,
        success:function (data) {
            data = $.parseJSON(data);
            if(data.success){
                $.messager.alert("温馨提示",data.msg,"info",function () {
                    //关闭对话框
                    $("#emp_dialog").dialog("close");
                    //刷新页面
                    $("#emp_datagrid").datagrid("load")
                });
            }else {
                $.messager.alert("温馨提示",data.msg,"info");
            }
        }
    })
}

function edit() {
    //获取到选中的数据
    var rowData = $("#emp_datagrid").datagrid("getSelected");
    if (rowData) {
        $("#emp_dialog").dialog("open");
        $("#emp_dialog").dialog("setTitle", "编辑");
        $("#emp_form").form("clear");
        //特殊属性的处理
        if(rowData.dept){
            rowData["dept.id"] = rowData.dept.id;
        }
        $("#emp_form").form("load",rowData);//基于同名匹配规则
    }else {
        $.messager.alert("温馨提示","请选择一条需要编辑的数据","info");
    }
}

function del() {
    //获取到选中的数据
    var rowData = $("#emp_datagrid").datagrid("getSelected");
    if(rowData){
        $.messager.confirm("温馨提示","您确定要删除这条数据吗？",function (yes) {
            if(yes){
                $.get("/employee_delete?id="+rowData.id,function (data){
                    if (data.success){
                        $.messager.alert("温馨提示",data.msg,"info");
                        //刷新表格
                        $("#emp_datagrid").datagrid("reload");
                    }else {
                        $.messager.alert("温馨提示",data.msg,"info");
                    }
                },"json");
            }
        })
    }else {
        $.messager.alert("温馨提示","请选择需要离职的员工","info");
    }
}

function reload() {
    $("#emp_datagrid").datagrid("reload");
}

function cancel() {
    $("#emp_dialog").dialog("close");
}