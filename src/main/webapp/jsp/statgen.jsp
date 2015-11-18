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
<%@include file="inc/header.jsp" %>

<c:if test="${sessionScope.loggedUser.admin==false}">
	<c:redirect url="/"/>
</c:if>

<div id="main">

	<div id="main_inner" class="fluid">

		<div id="primaryContent_columnless">

			<div id="columnA_columnless">

		<h3>Statistiques G�n�rales</h3>
		
		<h4 class="banniere">Rapports</h4>
		<center>
		<display:table style="width:70%;" decorator="accueilccas.web.decorators.RapportsTableDecorator" name="${rapports}" requestURI="statgen.do" pagesize="50" export="false" > 
			<display:column property="id" title="id" sortable="true" headerClass="enteteTableau" />
	     	<display:column property="titre" title="Titre du rapport" headerClass="enteteTableau" sortable="true" /> 
     		<display:column property="description" title="description" headerClass="enteteTableau" sortable="true" />
     		<display:column property="url" autolink="true" href="${rapport.url}" title="Consulter" headerClass="enteteTableau" /> 
     	</display:table> 
		</center>
<%@include file="inc/footer.jsp" %>			