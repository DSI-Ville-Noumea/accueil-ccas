<%@ page isErrorPage="true" language="java" %>
<head>
<link rel="stylesheet" type="text/css" title="Red" href="css/style_Red.css" />
</head>	

<div id="main">

	<div id="main_inner" class="fluid">

		<div id="primaryContent_columnless">

			<div id="columnA_columnless">


<h3>Erreur </h3>
	<center>Une erreur est survenue.</center>
<hr/>
<pre>
<%
if(exception.getMessage().contains("IndexOutOfBoundsException"))
	out.write("<center><h4>UTILISATEUR NON AUTHORISE</h4>");
else
	exception.printStackTrace(new java.io.PrintWriter(out));
%>
</pre>

<a href="accueil.do"><h2>Revenir à l'accueil</h2></a>

</div>