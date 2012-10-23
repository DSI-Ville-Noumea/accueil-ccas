<%@include file="inc/header.jsp" %>

<c:if test="${sessionScope.loggedUser.admin==false}">
	<c:redirect url="/"/>
</c:if>

<div id="main">

	<div id="main_inner" class="fluid">

		<div id="primaryContent_columnless">

			<div id="columnA_columnless">

		<h3>Statistiques Générales</h3>
		
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