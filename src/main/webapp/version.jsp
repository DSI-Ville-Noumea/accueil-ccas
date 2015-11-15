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

