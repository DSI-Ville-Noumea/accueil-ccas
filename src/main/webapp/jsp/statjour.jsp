<%@include file="inc/header.jsp" %>

<div id="main">

	<div id="main_inner" class="fluid">

		<div id="primaryContent_columnless">

			<div id="columnA_columnless">

		<h3>Statistiques</h3>

		<h4 class="banniere">Statistiques générales</h4>
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