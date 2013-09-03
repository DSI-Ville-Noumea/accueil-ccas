<%@page contentType="text/plain;charset=UTF-8"%>
<%@page import="java.net.InetAddress"%>
ccas.accueil.version=<%=this.getServletContext().getInitParameter("VERSION")%><br/>
ccas.accueil.tomcat.version=<%= application.getServerInfo() %><br/>
ccas.accueil.tomcat.catalina_base : <%= System.getProperty("catalina.base") %><br>
ccas.accueil.hostname=<%=InetAddress.getLocalHost().getHostName()%><br/>
ccas.accueil.hostaddress=<%=InetAddress.getLocalHost().getHostAddress()%><br/>
ccas.accueil.canonicalhostname=<%=InetAddress.getLocalHost().getCanonicalHostName()%><br/>

tomcat.version : <%= application.getServerInfo() %><br>


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

