

<%@page import="com.database.Queries"%>
<%@page import="java.sql.ResultSet"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
try{
     String id=(String)session.getAttribute("id");
       String username=(String)session.getAttribute("username");
        String email=(String)session.getAttribute("email");
        
        
        
    String vid=request.getParameter("vid");
    String fname=request.getParameter("vname");
    String fid=request.getParameter("fid");
    
    String query="insert into share values(null,'"+username+"','"+id+"','"+fname+"','"+vid+"','"+fid+"')";
    int i=Queries.getExecuteUpdate(query);
    if(i>0){
      %>
      <script type='text/javascript'>
          window.alert("video Shared Successful..!!");
          window.location="SerachVideo.jsp";
      </script>
      <%
    }else{
%>
      <script type='text/javascript'>
          window.alert("Sharing Failed..!!");
          window.location="SerachVideo.jsp";
      </script>
      <%
}
  /*INCREASING THE SHARE VALUE FOR THE VIDEO*/
 String getShares = "select * from video where fname='"+fname+"'";
  ResultSet r=Queries.getExecuteQuery(getShares);
  r.next();
  int shares = r.getInt("shares");
  shares+=1;
  Queries.getExecuteUpdate("update video set shares='"+shares+"' where fname='"+fname+"';");
}

catch(Exception e){
    out.println(e);
}



%>