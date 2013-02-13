<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<meta http-equiv="X-UA-Compatible" content="chrome=1">

<%@include file="tags.jsp" %>
<html>
	<head>
		<title><fmt:message key="app.title"/></title>
		
		<link rel="stylesheet" type="text/css" title="${sessionScope.loggedUser.css}" href="css/style_${sessionScope.loggedUser.css}.css" />
		<link rel="alternate stylesheet" type="text/css" title="Red" href="css/style_Red.css" />
		<link rel="alternate stylesheet" type="text/css" title="Blue" href="css/style_Blue.css" />
		<link rel="alternate stylesheet" type="text/css" title="Green" href="css/style_Green.css" />
		<link rel="alternate stylesheet" type="text/css" title="Brown" href="css/style_Brown.css" />
		<link rel="alternate stylesheet" type="text/css" title="Magenta" href="css/style_Magenta.css" />
		
		<script type='text/javascript' src='dwr/engine.js'></script>
		<script type='text/javascript' src='dwr/interface/UserManager.js'></script>
		<script type='text/javascript' src='dwr/util.js'></script>
		
		<script type="text/javascript" src='js/jquery-1.2.6.pack.js' ></script>
		<script type="text/javascript" src='js/jqModal.js'></script>
		<script type="text/javascript" src='js/jquery.tablednd_0_5.js' ></script>
		<script type="text/javascript" src='js/jquery.checkboxes.js'></script>

		<script type="text/javascript" src='js/styleswitch.js'></script>
	</head>

			
<div id="header">

	<div id="header_inner" class="fluid">

		<div id="logo">
			<h1><span><fmt:message key="app.title"/></span></h1>
			<h2></h2>
		</div>
	
	<div id="menu">
			<% String selected = request.getRequestURI().substring(request.getRequestURI().lastIndexOf('/')+1,request.getRequestURI().lastIndexOf('.')); %>
			<ul>
				<li><a href="accueil.do" class="<%= selected.equalsIgnoreCase("accueil")? "active" : "non" %>">Nouveau Dossier</a></li>
				<li><a href="statjour.do" class="<%= selected.equalsIgnoreCase("statjour")? "active" : "non" %>">Stat du jour</a></li>
					<c:if test="${sessionScope.loggedUser.admin}">
						<li><a href="statgen.do" class="<%= selected.equalsIgnoreCase("statgen")? "active" : "non" %>">Stat g&eacute;n&eacute;rales</a></li>
						<li><a href="admin.do" class="<%= selected.equalsIgnoreCase("admin")? "active" : "non" %>">Administration</a></li>
					</c:if>
			</ul>
		</div>
	</div>
</div>
			
			
					
					