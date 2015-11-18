<%--
  #%L
  Accueil CCAS
  %%
  Copyright (C) 2012 - 2015 Mairie de Nouméa
  %%
  This program is free software: you can redistribute it and/or modify
  it under the terms of the GNU General Public License as
  published by the Free Software Foundation, either version 3 of the
  License, or (at your option) any later version.
  
  This program is distributed in the hope that it will be useful,
  but WITHOUT ANY WARRANTY; without even the implied warranty of
  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
  GNU General Public License for more details.
  
  You should have received a copy of the GNU General Public
  License along with this program.  If not, see
  <http://www.gnu.org/licenses/gpl-3.0.html>.
  #L%
  --%>
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

<a href="accueil.do"><h2>Revenir � l'accueil</h2></a>

</div>