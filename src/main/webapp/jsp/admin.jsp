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
	<c:redirect url="/"/>
</c:if>

<script type='text/javascript' src='dwr/interface/TypeReceptionManager.js'></script>
<script type='text/javascript' src='dwr/interface/TypePublicManager.js'></script>
<script type='text/javascript' src='dwr/interface/CategorieManager.js'></script>
<script type='text/javascript' src='dwr/interface/AttributCategorieManager.js'></script>
<script type='text/javascript' src='dwr/interface/GroupeManager.js'></script>


<div id="main">

	<div id="main_inner" class="fluid">

<div align="right">
				<a href="admin.do">Administration des r�ponses</a> &nbsp;
				<a href="adminuser.do">Administration des utilisateurs</a> &nbsp;
				<!-- <a href="adminrapport.do">Administration des rapports</a><br> -->
				<br/>
	</div>

		<div id="primaryContent_columnless">

			<div id="columnA_columnless">


<h3>Administration</h3>

<script type="text/javascript">
<!--

jQuery(document).ready(function() {
	
	jQuery('#table-1').tableDnD({
	    onDragClass: "myDragClass",
        onDrop: function(table, row) {
        		debugStr="";
	        	var rows= table.tBodies[0].rows;
	        	for (var i=0; i<rows.length; i++) {
	                debugStr += rows[i].id+"-";
	                }
	        	TypeReceptionManager.reOrder(debugStr);
        	}
    });

	jQuery('#table-2').tableDnD({
	    onDragClass: "myDragClass",
        onDrop: function(table, row) {
				debugStr="";
		    	var rows= table.tBodies[0].rows;
		    	for (var i=0; i<rows.length; i++) {
		            debugStr += rows[i].id+"-";
		        }
		       TypePublicManager.reOrderPublic(debugStr);
		        }
    });

	
	jQuery('#table-4').tableDnD({
  	    onDragClass: "myDragClass",
          onDrop: function(table, row) {
  		debugStr="";
  		    	var rows= table.tBodies[0].rows;
  		    	for (var i=0; i<rows.length; i++) {
  		            debugStr += rows[i].id+"-";
  		        }
  		    	AttributCategorieManager.reOrderAttributCategorie(debugStr);
  		        }
      });

	jQuery('#table-4bis').tableDnD({
  	    onDragClass: "myDragClass",
          onDrop: function(table, row) {
              $.ajax({
  			   type: "POST",
  			   url: "admin.do",
  			   data: $.tableDnD.serialize(),
  			   success: function(msg){
  			    
  			   }
  			 });
          }
      });

	jQuery('#table-5').tableDnD({
  	    onDragClass: "myDragClass",
          onDrop: function(table, row) {
  		debugStr="";
  		    	var rows= table.tBodies[0].rows;
  		    	for (var i=0; i<rows.length; i++) {
  		            debugStr += rows[i].id+"-";
  		        }
  		    	GroupeManager.reOrderGroupe(debugStr);
  		    	}
      });

});
-->

</script>

<!--  toto
-->

<script type="text/javascript">
<!--


	function ajouterReception()
	{	
		libelleTypeReception = jQuery("#ajoutReceptionChamps").attr("value");
				
				TypeReceptionManager.creerTypeReception(libelleTypeReception,
					function(data){	
								jQuery('#table-1').append("<tr id='"+data.idTypeReception+"' style='cursor :move'><td>"+libelleTypeReception+"</td>"
								+"<td id='"+data.idTypeReception+"'>"
								+"<input type='image' src=' ./img/edit_profile.gif' onclick='editTypeReception("+data.idTypeReception+")'/></td>"
								+"<td><input id='"+data.idTypeReception+"' type='checkbox' checked onclick='rec_activation("+data.idTypeReception+");'/></td>"
								+"</tr>");
									});

				//fonctionalit� de drag and drop
				jQuery('#table-1').tableDnD({
					  onDragClass: "myDragClass",
			          onDrop: function(table, row)
			          			{
						  			debugStr="";
						  			var rows= table.tBodies[0].rows;
						  		   	for (var i=0; i<rows.length; i++)
							  		{
						  		    	debugStr += rows[i].id+"-";
						  		    }
						  	
						  		   	TypeReceptionManager.reOrder(debugStr);
			  		      		}
			      });
	}
	
	function editTypeReception(elementId)
	{
		TypeReceptionManager.getTypeReceptionById(elementId,
				function(data){
								libelleRec=data.libelleTypeReception;
								jQuery('#table-1bis').empty();
								//formulaire d'�dition d'un type de r�ception
								jQuery('#table-1bis').append("<tr><td><input id='editerReception'value= \""+libelleRec+"\" size='27' type='text'/></td>"
										  					+"<td><input id='edit' type='button' value='Sauvegarder' onClick='modifierTypeReception("+elementId+")'/></td>"
										  					+"</tr>");
								});   
	}
	
	function modifierTypeReception(elementId,libelleRec)
	{	
		libelleRec=jQuery("#editerReception").attr("value")
		TypeReceptionManager.modifierTypeReception(elementId,libelleRec);
		
		jQuery("#table-1 tr[@id='"+elementId+"'] td:first").text(libelleRec);
		
	}
	
	function ajouterPublic()
	{	
	libelleTypePublic = jQuery("#ajoutPublicChamps").attr("value");
		
		TypePublicManager.creerTypePublic(libelleTypePublic,
			function(data){	
						jQuery('#table-2').append("<tr id='"+data.idTypePublic+"'><td>"+libelleTypePublic+"</td>"
						+"<td id='"+data.idTypePublic+"'>"
						+"<input type='image' src=' ./img/edit_profile.gif' onclick='editPublic("+data.idTypePublic+")'/></td>"
						+"<td><input id='"+data.idTypePublic+"' type='checkbox' checked onclick='pub_activation("+data.idTypePublic+");'/></td>"
						+"</tr>");
						});


		//fonctionalit� de drag and drop
		jQuery('#table-2').tableDnD({
			  onDragClass: "myDragClass",
	          onDrop: function(table, row)
	          			{
				  			debugStr="";
				  			var rows= table.tBodies[0].rows;
				  		   	for (var i=0; i<rows.length; i++)
					  		{
				  		    	debugStr += rows[i].id+"-";
				  		    }
				  	
				  		   	TypePublicManager.reOrderPublic(debugStr);
	  		      		}
	      });
	}

	function editPublic(elementId)
	{
		TypePublicManager.getTypePublicById(elementId,
			function(data){ 
							libelleTypePublic=data.libelleTypePublic;
							typePublic={idTypePublic : data.idTypePublic, libelleTypePublic : data.libelleTypePublic, positionPublic :data.positionTypePublic};

							jQuery('#table-2bis').empty();
							//formulaire d'edition d'un type de public
							jQuery('#table-2bis').append("<tr><td><input id='editerPublic'value=\""+libelleTypePublic+"\" size='27' type='text' />"
									  					+"<input id='edit' type='button' value='Sauvegarder' onclick='modifierTypePublic("+elementId+")'/></td>"
									  					+"</tr>");
							});   
	 }

	function modifierTypePublic(elementId,libellePub)
	{
		libellePub=jQuery("#editerPublic").attr("value")
		TypePublicManager.modifierTypePublic(elementId,libellePub);

		jQuery("#table-2 tr[@id='"+elementId+"'] td:first").text(libellePub);
	}


	function ajouterGroupe()
	{
		nomGroupe = jQuery("#ajoutGroupeChamps").attr("value");

		GroupeManager.creerGroupe(nomGroupe,
			function(data){	
				jQuery('#table-5').append("<tr id='"+data.idgroupe+"'><td onclick='chargerCategorie("+data.idgroupe+")'>"+nomGroupe+"</td>"
				+"<td id='"+data.idGroupe+"'>"
				+"<input type='image' src=' ./img/edit_profile.gif' onclick='editerGroupe("+data.idgroupe+")'/></td>"
				+"<td><input id='"+data.idGroupe+"' type='checkbox' checked onclick='groupe_activation("+data.idGroupe+");'/></td>"
				+"</tr>");
				});



		//fonctionalit� de drag and drop
		jQuery('#table-5').tableDnD({
			  onDragClass: "myDragClass",
	          onDrop: function(table, row)
	          			{
				  			debugStr="";
				  			var rows= table.tBodies[0].rows;
				  		   	for (var i=0; i<rows.length; i++)
					  		{
				  		    	debugStr += rows[i].id+"-";
				  		    }
				  	
				  		   	GroupeManager.reOrderGroupe(debugStr);
	  		      		}
	      });


	}
	
	function modifierGroupe(groupe_id, libelleGroupe)
	{
		libelleGroupe=jQuery("#editerGroupe").attr("value")
		GroupeManager.modifierGroupe(groupe_id,libelleGroupe);

		jQuery("#table-5 tr[@id='"+groupe_id+"'] td:first").text(libelleGroupe);
	}
	
	function editerGroupe(groupe_id)
	{
		GroupeManager.getGroupe(groupe_id,
			function(data){
							groupe={idgroupe : data.idgroupe, libelleGroupe : data.nom, positionGroupe : data.position};
							libelleGroupe = data.nom;
							
							jQuery('#table-5bis').empty();
							//formulaire d'�dition de groupe
							jQuery('#table-5bis').append("<tr><td><input id='editerGroupe'value=\""+libelleGroupe+"\" size='27' type='text' />"
									  					+"<input id='edit' type='button' value='Sauvegarder' onclick='modifierGroupe("+groupe_id+")'/></td>"
									  					+"</tr>");
						  });   
	}
	
	function ajouterCategorie(groupe_id)
	{
		lib = jQuery("#ajoutCategorieChamps").attr("value");
		
		CategorieManager.ajouterCategorie(groupe_id, lib,
		   function(data){
			 
			     jQuery("#table-6").append("<tr id='"+data.idCategorie+"'>"
					+"<td onclick='chargerAttribut("+data.idCategorie+")'>"+lib+"</td>"
					+"<td><input type='image' src=' ./img/edit_profile.gif' onclick='editCategorie("+data.idCategorie+")'/></td>"
					+"<td><input id='"+data.idCategorie+"' type='checkbox' checked onclick='cat_activation("+data.idCategorie+");'/></td>"
					+"</tr>");
						}
		);



		//fonctionalit� de drag and drop
		jQuery('#table-6').tableDnD({
			  onDragClass: "myDragClass",
	          onDrop: function(table, row)
	          			{
				  			debugStr="";
				  			var rows= table.tBodies[0].rows;
				  		   	for (var i=0; i<rows.length; i++)
					  		{
				  		    	debugStr += rows[i].id+"-";
				  		    }
				  	
				  		   	CategorieManager.reOrderCategorie(debugStr);
	  		      		}
	      });





		
	}
	
	function editCategorie(elementId)
	{
		CategorieManager.getCategorieById(elementId,
			function(data){
							typeCategorie={idCategorie : data.idCategorie, libelleCategorie : data.libelleCategorie, positionCategorie : data.positionCategorie};
							libelleCategorie=data.libelleCategorie;
							jQuery('#table-6bis').empty();
							//formulaire d'�dition de cat�gorie
							jQuery('#table-6bis').append("<tr><td><input id='editerCategorie'value=\""+libelleCategorie+"\" size='27' type='text' />"
									  					+"<input id='edit' type='button' value='Sauvegarder' onclick='modifierCategorie("+elementId+")'/></td>"
									  					+"</tr>");
						  });   
	  }

	function modifierCategorie(elementId, libelleCat)
	{
		libelleCat=jQuery("#editerCategorie").attr("value")
		CategorieManager.modifierCategorie(elementId,libelleCat);
		jQuery("#table-6 tr[@id='"+elementId+"'] td:first").text(libelleCat);
				
	}
	
	function chargerCategorie(idGroupe)
	{
		jQuery('#table-4').empty();
		jQuery('#table-4bis').empty();
		jQuery("#table-6 ").empty();
		jQuery("#table-6bis ").empty();
		jQuery("#titreEditCategories").remove();
		jQuery("#ajoutCategorieForm").remove();
		jQuery("#ajoutCategorieChamps").remove();
		
		

		GroupeManager.getGroupe(idGroupe,
				function(data){
					Groupe={idGroupe : data.idgroupe, nom : data.nom, position: data.position, categories : data.categories};
					idCat=  Groupe.categorie

					jQuery("#table-6").before("<h4 id='titreEditCategories'> Edition des cat�gories de groupe</h4>");

					for (Val in Groupe.categories)
					{	
						
						//affichage des cat�gories actives
						if(Groupe.categories[Val].enabled==true)
						{
							catChecked="checked";
																		
						// affichage liste des cat�gories
							jQuery("#table-6").append("<tr id="+Groupe.categories[Val].idCategorie+"><td onclick='chargerAttribut("+Groupe.categories[Val].idCategorie+")'>"+Groupe.categories[Val].libelleCategorie+"</td>"
									+"<td><input type='image' src=' ./img/edit_profile.gif' onclick='editCategorie("+Groupe.categories[Val].idCategorie+")'/></td>"
									+"<td><input id='"+Groupe.categories[Val].idCategorie+"' type='checkbox' "+catChecked+" onclick='cat_activation("+Groupe.categories[Val].idCategorie+");'/></td>"
									+"</tr>");
						}	

						//affichage des cat�gories d�sactiv�es(checkboxes d�coch�es au chargement)
						else
						{
							catChecked="";
							// affichage liste des cat�gories
							jQuery("#table-6").append("<tr id="+Groupe.categories[Val].idCategorie+"><td onclick='chargerAttribut("+Groupe.categories[Val].idCategorie+")'>"+Groupe.categories[Val].libelleCategorie+"</td>"
									+"<td><input type='image' src=' ./img/edit_profile.gif' onclick='editCategorie("+Groupe.categories[Val].idCategorie+")'/></td>"
									+"<td><input id='"+Groupe.categories[Val].idCategorie+"' type='checkbox' "+catChecked+" onclick='cat_activation("+Groupe.categories[Val].idCategorie+");'/></td>"
									+"</tr>");
						}
					}

					//fonctionalit� de drag and drop
					jQuery('#table-6').tableDnD({
						  onDragClass: "myDragClass",
				          onDrop: function(table, row)
				          			{
							  			debugStr="";
							  			var rows= table.tBodies[0].rows;
							  		   	for (var i=0; i<rows.length; i++)
								  		{
							  		    	debugStr += rows[i].id+"-";
							  		    }
							  	
							  		   	CategorieManager.reOrderCategorie(debugStr);
				  		      		}
				      });

					//formulaire ajouter nouvelles cat�gorie
					chaineCategorie='\"Ajouter une cat�gorie\"';
					
					jQuery("#table-6bis").after("<center><input name='ajoutCategorie' id='ajoutCategorieChamps' value='Ajouter une cat�gorie'  size='27' type='text' onclick='if(this.value==value)this.value= \"\";'>"
							+"<input type='button'id='ajoutCategorieForm'  value='Ajouter' onClick='ajouterCategorie("+idGroupe+"); ajoutCategorieChamps.value="+chaineCategorie+"' </input>"
							+"</center>");
							});

					
		
		
	}

	
	function ajouterAttributCategorie(id_categorie)
	{	
		libelleAttribut= jQuery("#ajoutAttribChamps").attr("value");
		AttributCategorieManager.ajouterAttribut(id_categorie, libelleAttribut,
			function(data){
					
					jQuery("#table-4 ").append("<tr id ='"+data.idAttribut+"'>"
							+"<td>"+data.libelleAttribut+"</td>"
							+"<td><input type='image' src=' ./img/edit_profile.gif' onclick='editAttributCategorie("+data.idAttribut+")'/>"
							+"<td><input id='"+data.idAttribut+"' type='checkbox' checked onclick='att_activation("+data.idAttribut+"); '/></td>"
							+"</td></tr>");
			});


		//fonctionalit� de drag and drop
		jQuery('#table-4').tableDnD({
			  onDragClass: "myDragClass",
	          onDrop: function(table, row)
	          			{
				  			debugStr="";
				  			var rows= table.tBodies[0].rows;
				  		   	for (var i=0; i<rows.length; i++)
					  		{
				  		    	debugStr += rows[i].id+"-";
				  		    }
				  	
				  		   	AttributCategorieManager.reOrderAttributCategorie(debugStr);
	  		      		}
	      });

		
	}
	
	function editAttributCategorie(elementId)
	{
	 jQuery("#table-4bis").empty();
	  AttributCategorieManager.getAttribut( elementId,
			function(data){
							AttributCategorie={Categorie:data.categorie, idAttribut:data.idAttribut, libelleAttribut: data.libelleAttribut, positionAttribut:data.positonAttribut};
							libelleAttr=data.libelleAttribut;
							
														
							jQuery('#table-4bis').append("<tr><td><input id='editerAttr' value=\" "+libelleAttr+"\" size='27' type='text'/>"
				  					+"<input id='edit' type='button' value='Sauvegarder' onclick='modifierAttributCategorie("+elementId+")'/></td></tr>"
				  					);
							
							});

	 
		
	}

	function modifierAttributCategorie(elementId, libelleAttrib)
	{	
		libelleAttrib=jQuery("#editerAttr").attr("value");
		AttributCategorieManager.modifierAttributCategorie(elementId,libelleAttrib);

		jQuery("#table-4 tr[@id='"+elementId+"'] td:first").text(libelleAttrib);
	}
	
	function chargerAttribut(id_categorie)
	{	
		jQuery('#table-4').empty();
		jQuery('#titreEditAttr').remove();
		jQuery('#ajoutAttribChamps').remove();
		jQuery('#formAttribut').remove();
		
		
		CategorieManager.getCategorieById(id_categorie,    
		function(data){
			categorie = {idCategorie : data.idCategorie,attributs : data.attributs, libelleCategorie : data.libelleCategorie, positionCategorie: data.positionCategorie};
			
			jQuery("#table-4" ).before("<h4 id='titreEditAttr'>Edition des attributs</h4>");

			//affichage de la liste des attributs			
			for ( i=0; i<categorie.attributs.length;i++)
			{	
				 
				//affichage des attributs actifs
				if(categorie.attributs[i].enabled==true){
					
					attCheck="checked";

				jQuery("#table-4").append("<tr  id="+categorie.attributs[i].idAttribut+"><td>"+categorie.attributs[i].libelleAttribut+"</td><td idAttr = '"+categorie.attributs[i].idAttribut+"'>"
				+"<input type='image' src=' ./img/edit_profile.gif' onclick='editAttributCategorie("+categorie.attributs[i].idAttribut+")'/>"
				+"<td><input idAttrCheck='attr_"+categorie.attributs[i].idAttribut+"' type='checkbox' "+attCheck+" onclick='att_activation("+categorie.attributs[i].idAttribut+");'/></td>"
				+"</tr>");

				}
				//affichage des attributs d�sactiv�s (checkboxes d�coch�es au chargement)
				else{
					
					attCheck="";
				
				jQuery("#table-4").append("<tr  id="+categorie.attributs[i].idAttribut+"><td>"+categorie.attributs[i].libelleAttribut+"</td><td idAttr = '"+categorie.attributs[i].idAttribut+"'>"
				+"<input type='image' src=' ./img/edit_profile.gif' onclick='editAttributCategorie("+categorie.attributs[i].idAttribut+")'/>"
				+"<td><input idAttrCheck='attr_"+categorie.attributs[i].idAttribut+"' type='checkbox' "+attCheck+" onclick='att_activation("+categorie.attributs[i].idAttribut+");'/></td>"
				+"</tr>");
				}
			}	


			
			//fonctionalit� de drag and drop
			jQuery('#table-4').tableDnD({
		  	    onDragClass: "myDragClass",
		        onDrop: function(table, row) {
		  		debugStr="";
		  		    	var rows= table.tBodies[0].rows;

		  		    	for (var i=0; i<rows.length; i++)
			  		    {
		  		            debugStr += rows[i].id+"-";
		  		        }
		  		        
		  		    	AttributCategorieManager.reOrderAttributCategorie(debugStr);
		  		        }
		      });

			//formulaire d'ajout d'un attribut
			chaineAttribut='\"Ajouter un nouvel Attribut\"';
			jQuery("#table-4bis").after("<center><tr><td><input name='ajoutAttribut' id='ajoutAttribChamps' value='Ajouter un nouvel Attribut' size='27' type='text' onclick='if(this.value==value)this.value= \"\";' /></td>"
						+"<td><input id='formAttribut' type='button'  value='Ajouter' onClick='ajouterAttributCategorie("+categorie.idCategorie+"); ajoutAttribChamps.value="+chaineAttribut+"'</input></td></tr></center>");
						});

			
	}



	function rec_activation(idTypeReception){
		
		TypeReceptionManager.getTypeReceptionById(idTypeReception,

				function(data){
				
					if(data.enabled==true)
					{
						TypeReceptionManager.enableReception( idTypeReception ,false)
					}
					else
					{
						TypeReceptionManager.enableReception(idTypeReception, true)
					}
				});

	}

		function pub_activation(idTypePublic){
			
			TypePublicManager.getTypePublicById(idTypePublic,

					function(data){
					
						if(data.enabled==true)
						{
							TypePublicManager.enablePublic( idTypePublic ,false)
						}
						else
						{
							TypePublicManager.enablePublic(idTypePublic, true)
						}
					});
	}


		function groupe_activation(idgroupe){
			
			GroupeManager.getGroupe(idgroupe,

					function(data){
					
						if(data.enabled==true)
						{
							GroupeManager.enableGroupe( idgroupe ,false)
						}
						else
						{
							GroupeManager.enableGroupe(idgroupe, true)
						}
					});
	}

		function att_activation(idAtt){
			
			AttributCategorieManager.getAttribut(idAtt,

					function(data){
					
						if(data.enabled==true)
						{
							AttributCategorieManager.enableAttribut( idAtt ,false)
						}
						
						else
						{
							AttributCategorieManager.enableAttribut(idAtt, true)
						}
				});

		}

		function cat_activation(idCat){
			
			CategorieManager.getCategorieById(idCat,

					function(data){
					
						if(data.enabled==true)
						{
							CategorieManager.enableCategorie( idCat ,false)
						}
						else
						{
							 CategorieManager.enableCategorie(idCat, true)
						}
					});

		}

		
	
-->
</script>

<!-- Type de r�ception -->
<!--  
<br/>
				Declarer un probleme en cliquant <a href='http://svn/trac/accueilccas/newticket'>ICI</a><br/>
				Consulter la liste des tickets en cours <a href='http://svn/trac/accueilccas/report/1'> ICI </a>
<br />
-->

<!-- R�ceptions -->
<h4 class="banniere">Gestion des types de reception</h4>
<table id="table-1" cellspacing="0" cellpadding="2" varStatus="statut">
	<c:forEach items="${modele.receptions}" var="type">
		<tr id="${type.idTypeReception}">
			<td><c:out value="${type.libelleTypeReception}" /></td>
			<td id="${type.idTypeReception}">
				<input type="image" src=" ./img/edit_profile.gif" onclick="editTypeReception(${type.idTypeReception})"/>
			</td>
			<td><input id="reception_${type.idTypeReception}" type="checkbox" <c:if test="${type.enabled}"> checked </c:if> onclick="rec_activation(${type.idTypeReception});"/></td>
		</tr>
	</c:forEach>
 </table>
 <table id="table-1bis" cellspacing="0" cellpadding="2" varStatus="statut"></table>


<center>
	<form name="formAjoutTypeReception">
		<input id="ajoutReceptionChamps" name="ajoutReception" onclick="if(this.value==value)this.value='';" value="Ajouter un type de r�ception" size="27" type="text"></input> 
		<input type="button" value="Ajouter" onClick="ajouterReception(); ajoutReceptionChamps.value='Ajouter un type de r�ception' "></input>
	</form>
</center>

<!-- Public -->
<h4 class="banniere">Gestion des types de public</h4>
<table id="table-2" cellspacing=" 0" cellpadding="2" varStatus="statut">
	<c:forEach items="${modele.public}" var="type">
		<tr id="${type.idTypePublic}">
			<td><c:out value="${type.libelleTypePublic}" /></td>
			<td><input type="image" src=" ./img/edit_profile.gif" onclick="editPublic(${type.idTypePublic})"/></td>
			<td><input id="public_${type.idTypePublic}" type="checkbox" <c:if test="${type.enabled}"> checked </c:if> onclick="pub_activation(${type.idTypePublic});"/></td>
		</tr>
	</c:forEach>
	<table id="table-2bis" cellspacing="0" cellpadding="2" varStatus="statut"></table>
</table>

<center>
	<form name="formAjoutTypePublic">
		<input name="ajoutPublic"  id = "ajoutPublicChamps" onclick="if(this.value==value)this.value='';" value="Ajouter un type de public" size="27" type="text"></input>
		<input	type="button" value="Ajouter" onClick="ajouterPublic(); ajoutPublicChamps.value='Ajouter un type de public'"></input>
	</form>
</center>


<!-- Groupes de r�ponse -->
 <h4 class="banniere">Gestion des groupes de r�ponse </h4>
 <table id="table-5" cellspacing="0" cellpadding="2" varStatus="statut">
	<c:forEach items="${modele.groupes}" var="type">
		<tr id="${type.idgroupe}">
			<td onclick="chargerCategorie(${type.idgroupe})">
			<c:out value="${type.nom}" /></td>
			<td><input type="image" src=" ./img/edit_profile.gif" onclick="editerGroupe(${type.idgroupe})"/></td>
			<td><input id="groupe_${type.idgroupe}" type="checkbox" <c:if test="${type.enabled}"> checked </c:if> onclick="groupe_activation(${type.idgroupe});"/></td>
		</tr>
	</c:forEach>
</table>
<table id="table-5bis" cellspacing="0" cellpadding="2" ></table>

<center>
	<form name="formAjoutGroupe">
		<input name="ajoutGroupe" id ="ajoutGroupeChamps" onclick="if(this.value==value)this.value='';" value="Ajouter un groupe" size="27" type="text"></input>
		<input type="button" value="Ajouter" onClick="ajouterGroupe();  ajoutGroupeChamps.value='Ajouter un groupe'";</input>
	</form>
</center>

<!-- Cat�gories -->
<table id="table-6" cellspacing="0" cellpadding="2"  >
	<tr id="${type.idCategorie}">
		<td onclick="chargerAttribut(${type.idCategorie})"></td>
	</tr>
</table>

<form ><table id="table-6bis" cellspacing="0" cellpadding="2" ></table></form>

<!-- Edition des attributs -->
<table id="table-4" cellspacing="0" cellpadding="2" ></table>

<form ><table id="table-4bis" cellspacing="0" cellpadding="2" ></table></form>

<%@include file="inc/footer.jsp"%>