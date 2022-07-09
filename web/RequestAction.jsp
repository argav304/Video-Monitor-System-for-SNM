

<%@page import="com.database.Queries"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
try{
      String id=(String)session.getAttribute("id");
       String username=(String)session.getAttribute("username");
        String email=(String)session.getAttribute("email");
        
        
    String fname=request.getParameter("fname");
    String fid=request.getParameter("fid");
    
    String query="insert into request values(null,'"+username+"','"+id+"','"+fname+"','"+fid+"','waiting')";
    int i=Queries.getExecuteUpdate(query);
    if(i>0){
      %>
      <script type='text/javascript'>
          window.alert("Request Sent Successful..!!");
          window.location="SerachFriends.jsp";
      </script>
      <%
    }else{
%>
      <script type='text/javascript'>
          window.alert("Request Sending Failed..!!");
          window.location="SerachFriends.jsp";
      </script>
      <%
}
}catch(Exception e){
    out.println(e);
}



%>