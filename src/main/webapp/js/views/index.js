$(function(){
	$("#menuTree").tree({
		url:'/js/data/menu.json',
		onClick:function(node){
			//增加一个选项卡
			//在新增之前判断选择卡有没有改节点的面板
			var myTab = $("#myTabs");
			//在选项卡中是否已经有该节点的面板.
			if(myTab.tabs("exists",node.text)){
				//选中面板
				myTab.tabs("select",node.text);
			}else{
				myTab.tabs("add",{
					title:node.text,
					closable:true,
					content:"<iframe src='"+node.attributes.url+"' style='width:100%;height:100%' frameborder=0></iframe>"
				});
			}
			
		}
	});
});


