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

<%@include file="inc/header.jsp"%>

<c:if test="${sessionScope.loggedUser.admin==false}">
	<c:redirect url="/" />
</c:if>

<div id="main">
<div id="main_inner" class="fluid">
<div align="right">
				<a href="admin.do">Administration des r�ponses</a> &nbsp;
				<a href="adminuser.do">Administration des utilisateurs</a> &nbsp;
				<a href="adminrapport.do">Administration des rapports</a><br>
</div>
	<h4>Uploader un fichier</h4>
        <form method="post" enctype="multipart/form-data" action="adminuploadrapport.do">
        <table>
            <tr>
            <td><input type="file" name="file"/></td>
            </tr>
       </table>
            <input type="submit" name="submit" value="Soumettre"/>
        </form>
</div>
</div>
<%@include file="inc/footer.jsp"%>