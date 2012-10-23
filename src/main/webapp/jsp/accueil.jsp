<%@include file="inc/header.jsp" %>




<script type="text/javascript" language="javascript">
		$(document).ready(function() {
			$("#typeReception").click(
					function() { 
						$.radioCheckboxGroup("typeReception");
					}
				);
		
			$("#typePublic").click(
					function() { 
						$.radioCheckboxGroup("typePublic");
					}
				);
		});
</script>



<div id="main">

	<div id="main_inner" class="fluid">
<spring:hasBindErrors name="accueil">
							<ul id="errors">
								<c:forEach var="errMsgObj" items="${errors.allErrors}">
									<li><spring:message code="${errMsgObj.code}" text="${errMsgObj.defaultMessage}" /></li>
								</c:forEach>
							</ul>
						</spring:hasBindErrors>
	<div id="primaryContent_2columns">
			<div id="columnA_2columns">
				<form name="accueilform" method="post">
					<div align="right" >AGENT 
						<spring:bind path="accueil.user">				
						<select name="user" id="user">
		      		   			<c:forEach items="${users}" var="user">
		      		   					<c:if test="${user.visible}">
			      		   					<option value="<c:out value="${user.id}"/>" <c:if test="${user.id==accueil.user.id}">selected</c:if> > 
												<c:out value="${user.login}"/> 
											</option>
										</c:if>
					   			</c:forEach>
		      			</select> 
		     			</spring:bind>
					</div>

						
								<h4>Type de r�ception</h4>
									
									<c:forEach items="${typeReception}" var="type">
										<c:if test="${type.enabled}"> 
										<spring:bind path="accueil.typeReception">
											<input type="hidden" name="_<c:out value="${status.expression}"/>">
											<input type="radio" id="typeReception" name="typeReception" value="${type.idTypeReception}" <c:if test="${type.idTypeReception==status.value}">checked</c:if>  >
											 <c:out value="${type.libelleTypeReception}" />
											 <br/>
										</spring:bind>
										 </c:if>
									</c:forEach>
							
						
								<h4 class="banniere">Type de Public</h4>
									<spring:bind path="accueil.typePublic">
										<c:forEach items="${typePublic}" var="typeP">
											<c:if test="${typeP.enabled}">
											<input type="hidden" name="_<c:out value="${status.expression}"/>">
											<input type="radio" id="typePublic" name="typePublic" value="${typeP.idTypePublic}" <c:if test="${typeP.idTypePublic==status.value}">checked</c:if>  > 
											<c:out value="${typeP.libelleTypePublic}" />
											 <br/>
											</c:if>
										</c:forEach>
									</spring:bind>
									
			</div>
			</div><!-- fin de la colonne gauche -->
			
			<div id="secondaryContent_2columns">
				<div id="columnC_2columns">						
								<h4>R&eacute;ponse</h4>
								<table style="text-align: left; width: 100%;" border="0" cellpadding="2" cellspacing="2">
											<c:forEach items="${groupes}" var="groupe">
											  	
												<td style="vertical-align: top;">
													<h4><c:if test="${groupe.enabled}">${groupe.nom }</c:if></h4>
													
													<c:forEach items="${groupe.categories}" var="categorie">
													
													<c:if test="${groupe.enabled}">
														
														<!-- CODE SPECIFIQUE POUR LE CCAS.. on affiche pas le libelle de la categorie 2 (redondant avec le groupe -->
														<c:if test="${categorie.enabled==true }"> 
														
														<c:if test="${categorie.idCategorie !=2 }">
															<h6><c:out value="${categorie.libelleCategorie}" /></h6>
														</c:if>
														
													
														<c:forEach items="${categorie.attributs}" var="attribut">
															<c:if  test="${attribut.enabled==true}" >	
															<spring:bind path="accueil.typeReponse">
																&nbsp;&nbsp;&nbsp;
																<input type="radio" name="typeReponse" value="${attribut.idAttribut}"  <c:if test="${attribut.idAttribut==status.value}">checked</c:if>   > <c:out value="${attribut.libelleAttribut}"  /><br/>
															</spring:bind>
															</c:if>
														
														</c:forEach>
													</c:if>
														</c:if>
													</c:forEach>
												</td>
											</c:forEach>
										</tr>
								</table>
								<h4>Commentaires</h4>
								<spring:bind path="accueil.commentaireAccueil">
									<textarea name="commentaireAccueil" cols="50" rows="2"><c:out value="${status.value}"/></textarea>
								</spring:bind>
							
						<center><input class="submit" type="submit" value="Enregistrer">
								<input class="button" type="button" value="Annuler" onClick="javascript:document.location.href='accueil.do'">
						</center>
				</form>
<%@include file="inc/footer.jsp" %>		
	