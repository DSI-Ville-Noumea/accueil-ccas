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

<h3 class="banniere">Administration des utilisateurs</h3>
<br/>
				
<div id="primaryContent_2columns">
<div id="columnA_2columns">
<form name="adminUserform" method="post">
<table>
	<tr>
		<h4>Création/Modification des utilisateurs</h4>
	</tr>
	<tr>
		<td><label>Login</label></td>
		<spring:bind path="user.login">
			<td><input name="login" id="login" type="text" size="20" value="<c:out value="${user.login}" />"></td>
		</spring:bind>
	</tr>
	<tr>
		<td><label>CSS</label></td>
		<spring:bind path="user.css">
			<td><select name="css" id="css">
			<option value="Red">Rouge</option>
			<option value="Blue">Bleu</option>
			<option value="Green">Vert</option>
			<option value="Brown">Marron</option>
			<option value="Magenta">Magenta</option>
			</select></td>	
		</spring:bind>
	</tr>
	<tr>
		<td><label>Admin</label></td>
		<spring:bind path="user.admin">
		<c:if test="${user.admin==false}">
			<td><input type="checkbox" name="admin" id="admin"></td>
			</c:if>
			<c:if test="${user.admin==true}">
			<td><input type="checkbox" name="admin" id="admin" checked></td>
			</c:if>
		</spring:bind>
	</tr>
	<tr>
		<td><label>Visibilité</label></td>
		<td>
		
		<spring:bind path="user.visible">
		<c:if test="${user.visible==false}">
			<input type="checkbox" name="visible" id="visible" > 
			</c:if>
			<c:if test="${user.visible==true}">
			<input type="checkbox" name="visible" id="visible"checked> 
			</c:if>
		</spring:bind>
		</td>
	</tr>
	<tr>
		<td><input type="submit" name="cre/up" value="Soumettre"></input></td>
	</tr>
</table>
</form>
</div>
</div><!-- Fin gauche  -->

<div id="secondaryContent_2columns">
<div id="columnC_2columns">
<form>
		<h4>Liste des utilisateurs</h4>
		<table>
<tr>
		<td>
		<center>
		<display:table decorator="accueilccas.web.decorators.UtilisateurTableDecorator" name="${listeUtilisateurs}" requestURI="adminuser.do" pagesize="70" export="false" > 
			<display:column property="id" title="modifier" headerClass="enteteTableau" sortable="true"/>
			<display:column property="login" title="login" headerClass="enteteTableau" sortable="true"/>
	     	<display:column property="css" title="css" headerClass="enteteTableau" sortable="true" /> 
     		<display:column property="admin" title="admin" headerClass="enteteTableau" sortable="true" />
     		<display:column property="visible" title="visible" headerClass="enteteTableau" sortable="true" /> 
     	</display:table>
     	</center>
     	</td>
 </tr>
     	</table> 
		</form>
</div>
</div>
</div>
</div>
<%@include file="inc/footer.jsp"%>