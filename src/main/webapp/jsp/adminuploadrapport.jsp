
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