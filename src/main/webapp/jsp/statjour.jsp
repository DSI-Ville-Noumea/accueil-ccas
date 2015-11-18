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

<div id="main">

	<div id="main_inner" class="fluid">

		<div id="primaryContent_columnless">

			<div id="columnA_columnless">

		<h3>Statistiques</h3>

		<h4 class="banniere">Statistiques g�n�rales</h4>
			Nombre de dossiers saisis aujourd'hui : <b><c:out value="${nbDossiersTotal}"/></b>
		
		<h4 class="banniere">Accueil Physique</h4>
			
			<cewolf:chart id="accueilPhysique" 
				title="Accueil Physique" 
				type="verticalbar3d" 
				xaxislabel="Heures" 
				yaxislabel="Nombre de dossiers"
				showlegend="false">
					<cewolf:data >
						<cewolf:producer id="nbAccueilPhysiquesDS" />
					</cewolf:data>
			</cewolf:chart>
			
			<cewolf:img chartid="accueilPhysique" renderer="cewolf" width="600" height="300">
				<cewolf:map tooltipgeneratorid="nbAccueilPhysiquesDS"/>
			</cewolf:img>
			
			
		<h4 class="banniere">Accueil T&eacute;l&eacute;phonique</h4>

			<cewolf:chart id="accueilTelephonique" 
				title="Accueil Telephonique" 
				type="verticalbar3d" 
				xaxislabel="Heures" 
				yaxislabel="Nombre de dossiers"
				showlegend="false"	>
					<cewolf:data >
						<cewolf:producer id="nbAccueilTelephoniqueDS" />
					</cewolf:data>
			</cewolf:chart>
			<cewolf:img chartid="accueilTelephonique" renderer="cewolf" width="600" height="200">
				<cewolf:map tooltipgeneratorid="nbAccueilTelephoniqueDS"/>
			</cewolf:img>

	<%@include file="inc/footer.jsp" %>