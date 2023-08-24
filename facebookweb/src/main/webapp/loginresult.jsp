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


