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
<%@page contentType="text/plain;charset=UTF-8"%>
<%@page import="java.net.InetAddress"%>
ccas.accueil.version=${project.version}
ccas.accueil.tomcat.version=<%= application.getServerInfo() %>
ccas.accueil.tomcat.catalina_base : <%= System.getProperty("catalina.base") %>
ccas.accueil.hostname=<%=InetAddress.getLocalHost().getHostName()%>
ccas.accueil.hostaddress=<%=InetAddress.getLocalHost().getHostAddress()%>
ccas.accueil.canonicalhostname=<%=InetAddress.getLocalHost().getCanonicalHostName()%>

tomcat.version : <%= application.getServerInfo() %>


<%
	HttpSession theSession = request.getSession(false);

	// print out the session id
	if (theSession != null) {
		//pw.println( "<BR>Session Id: " + theSession.getId() );
		synchronized (theSession) {
			// invalidating a session destroys it
			theSession.invalidate();
		}
	}
%>

