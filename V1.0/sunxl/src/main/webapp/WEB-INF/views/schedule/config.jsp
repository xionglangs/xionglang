<%@page import="com.taobao.pamirs.schedule.zk.ZKManager"%>
<%@page import="java.util.Properties"%>
<%@page import="com.taobao.pamirs.schedule.ConsoleManager"%>
<%@page contentType="text/html; charset=UTF-8"%>
<style>
tr {
    font-size: 12px;
}
</style>
<%
	Properties p = ConsoleManager.loadConfig();
	String error = request.getParameter("error");
%>
<%
	if (error != null) {
%>
<div id="error" style="font-size: 18px; color: red">
	错误信息：<%=error%></div>

<%
	}
%>
<form id="configForm" method="get" name="configForm"
	action="<%=request.getContextPath()%>/private/schedule/path">
	<table>
		<tr>
			<td>
				Zookeeper地址:
				<input type="hidden" value="private.schedule.configDeal" name="path">
			</td>
			<td>
				<input type="text" name="zkConnectString"
					value="<%=p.getProperty(ZKManager.keys.zkConnectString.toString())%>" style="width: 300">
			</td>
			<td>格式: IP地址：端口</td>
		</tr>
		<tr>
			<td>Zookeeper超时:</td>
			<td>
				<input type="text" name="zkSessionTimeout"
					value="<%=p.getProperty(ZKManager.keys.zkSessionTimeout.toString())%>" style="width: 300">
			</td>
			<td>单位毫秒</td>
		</tr>
		<tr>
			<td>Zookeeper根目录：</td>
			<td>
				<input type="text" name="rootPath"
					value="<%=p.getProperty(ZKManager.keys.rootPath.toString())%>" style="width: 300">
			</td>
			<td>
				可以是一级目录，也可以是多级目录，注意不同调度域间不能有父子关系<br /> 通过切换此属性来实现多个调度域的管理
			</td>
		</tr>
		<tr>
			<td>Zookeeper用户：</td>
			<td>
				<input type="text" name="userName"
					value="<%=p.getProperty(ZKManager.keys.userName.toString())%>" style="width: 300">
			</td>
			<td></td>
		</tr>
		<tr>
			<td>Zookeeper密码：</td>
			<td>
				<input type="text" name="password"
					value="<%=p.getProperty(ZKManager.keys.password.toString())%>" style="width: 300">
			</td>
			<td></td>
		</tr>
	</table>
	<br />
	<input type="button" value="保存" onclick="save();" style="width: 100px">
	<a
		href="<%=request.getContextPath()%>/private/schedule/path?path=private.schedule.index&manager=true">管理主页...</a>
	<br /> <br />
	<%
		if (ConsoleManager.isInitial() == false) {
	%>
	<b>有几种原因导致你需要配置这些信息：</b><br> &nbsp;&nbsp;&nbsp;&nbsp; 1、你是第一次启动<br>
	&nbsp;&nbsp;&nbsp;&nbsp; 2、你的配置信息被删除&nbsp;<b><%=ConsoleManager.configFile%></b><br>
	&nbsp;&nbsp;&nbsp;&nbsp; 3、连接不上你配置的Zookeeper服务器<br>
	<%
		}
	%>
</form>
<script>
	function save() {
		document.getElementById("configForm").submit();
	}
</script>