<%@include file="inc/header.jsp"%>

<c:if test="${sessionScope.loggedUser.admin==false}">
	<c:redirect url="/" />
</c:if>

<div id="main">

<div id="main_inner" class="fluid">
<div align="right">
					<a href="admin.do">Administration des réponses</a> &nbsp; 
					<a href="adminuser.do">Administration des utilisateurs</a> &nbsp;
					<a href="adminrapport.do">Administration des rapports</a><br>
</div>

<h3 class="banniere">Administration des rapports</h3>
<br/>

<div id="primaryContent_2columns">
<div id="columnA_2columns">
<form name="adminRapportform" method="post">
<table>
	<spring:bind path="rapport.id">
			<input type="hidden" id="id" value="<c:out value="${rapport.id}" />">
	</spring:bind>
	<tr>
		<h4>Ajouter un rapport</h4>
	</tr>
	<tr>
		<td><label>Titre</label></td>
		<spring:bind path="rapport.titre">
		<td><input name="titre" id="titre" type="text" value="<c:out value="${rapport.titre}" />" size="20"></td>
		</spring:bind>
	<tr>
		<td>Description</td>
		<spring:bind path="rapport.description">
		<td><textarea name="description" id="description" cols="33" rows="3">${rapport.description}</textarea></td>
		</spring:bind>
	</tr>
	<spring:bind path="rapport.url">
	<c:if test="${nomFichier == null}">
	<tr>
		<td>url</td>
		<td><input name="url" id="url" value="<c:out value="${rapport.url}" />" type="text" size="44%"></td>
	</tr>
	<tr>
		<td>Rapport</td>
		<td><a href="adminuploadrapport.do">Uploader le rapport</a></td>
	</tr>
	</c:if>
	<c:if test="${nomFichier != null}">
	<tr>
		<td>url</td>
		<td><input name="url" id="url" value="<c:out value="${nomFichier}" />" type="text" size="44%"></td>
	</tr>
	<tr>
		<td></td>
		<td><label>Votre fichier a été uploadé</label></td>
		<c:remove var="nomFichier" scope="session" />
	</tr>
	</c:if>
	</spring:bind>
	<tr>
		<td><input name="cre" type="submit" value="Soumettre"></td>
		<td><input name="sup" type="submit" value="Supprimer"></td>
	</tr>
	
</table>
</form>
</div>
</div>
<div id="secondaryContent_2columns">
<div id="columnC_2columns">
<h4>Liste des rapports</h4>

<form>
<table>
	<tr>
		<td>
		<center><display:table style="width:500px;" decorator="accueilccas.web.decorators.ModifRapportsTableDecorator" name="${listeRapports}" requestURI="adminrapport.do" pagesize="100"export="false">
			<display:column property="id" title="N° Rapport" headerClass="enteteTableau" sortable="true" />
			<display:column property="titre" title="Titre Rapport" headerClass="enteteTableau" sortable="true" />
			<display:column property="description" title="Description Rapport" headerClass="enteteTableau" sortable="true" />
			<!--<display:column property="url" autolink="true" href="${rapport.url}" title="Consulter Rapport" headerClass="enteteTableau" />-->
		</display:table></center>
		</td>
		<td width="100px"></td>
	</tr>
</table>
</form>
</div>
</div>
</div>
</div>
<%@include file="inc/footer.jsp"%>