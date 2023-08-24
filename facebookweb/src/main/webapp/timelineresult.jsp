<%@page import="com.facebookweb.entity.TimeLine"%>
<%@page import="java.util.List"%>
<%
String email=session.getAttribute("userid").toString();
%>

Welcome <%= email %>  <br>
<a href="TimeLineServlet"><button>Time line data</button></a>
<a href="EditeServlet"><button>Edit profile</button></a>
<a href="DeleteServlet"><button>Delete profile</button></a>
<a href="ViewServlet"><button>View profile</button></a>
<a href="UploadPhotoServlet"><button>Upload photo</button></a>
<a href="SearchServlet"><button>Search</button></a>
<a href="FriendRequestServlet"><button>send friend request</button></a>



<%
List<TimeLine> ll= (List<TimeLine>) request.getAttribute("result");
if(ll.size()>0){
for(TimeLine tt:ll){ %>
	<div>
		*************************
		<%= tt.getSender() %> <br>
		<%= tt.getMtime() %> <br>
		<%= tt.getMessage() %><br>
		<%= tt.getMlike() %>
		<%= tt.getMdislike() %>
		<textarea rows=3 cols=6></textarea>
	</div>
<%}
}
%>