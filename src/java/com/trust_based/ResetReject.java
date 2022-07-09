
package com.trust_based;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.database.Queries;
import javax.servlet.RequestDispatcher;
/**
 *
 * @author Bharghava <your.name at your.org>
 */
@WebServlet(name = "ResetReject", urlPatterns = {"/ResetReject"})
public class ResetReject extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
                        String username=request.getParameter("username").toString();
                        RequestDispatcher rd=request.getRequestDispatcher("/UserHome.jsp");
                        Queries.getExecuteUpdate("update user set reject=0 where username='"+username+"';");
                        rd.forward(request, response);
    }

}
