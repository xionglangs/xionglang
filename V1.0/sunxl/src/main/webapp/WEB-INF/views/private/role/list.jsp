<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="/WEB-INF/views/private/easyui-private/easyUIForm.jsp"%>
<script type="text/javascript">
$(function(){
	dataGrid.datagrid({
		columns:[[
			{field:'name',title:'角色名',width:120},
			{field:'systid.name',title:'角色所属系统',width:120},
			{field:'smrytx',title:'角色简介',width:350},
 			{field:'createTime',title:'创建时间',width:150,sortable:true,formatter:function(value,row,index){
				var newTime = new Date(value);
				newTime.setDate(newTime.getDate());
				return (newTime.getYear()+1900)+"-"+(newTime.getMonth()+1)+"-"+newTime.getDate()+"&nbsp;"+newTime.getHours()+":"+newTime.getMinutes()+":"+newTime.getSeconds();
			}},
			{title:'更多操作',width:100,field:'caozuo', 					
				formatter : function(value, row,index) {
 					var str = '';
 					str += sy.formatString('<img class="iconImg ext-icon-note_add" title="查看${operateObject}详情" onclick="viewObject(\'{0}\',\'{1}\',\'{2}\');"/>',row.id,row.name,'${view}');
 					str += sy.formatString('<img class="iconImg ext-icon-note_edit" title="修改${operateObject}信息" onclick="updateValidataObject(\'{0}\',\'{1}\',\'{2}\',\'{3}\',\'{4}\',\'{5}\');"/>', row.id,row.name,'${update}','${formId}','POST','JSON');
 					str += sy.formatString('<img class="iconImg ext-icon-note_delete" title="删除${operateObject}信息" onclick="deleteObject(\'{0}\',\'{1}\',\'{2}\',\'{3}\',\'{4}\');"/>', row.id,row.tableName,'${delete}','POST','JSON');
 					return str;
 				}
 			}
		]]
	});
});	
</script>