package br.igornj.servlets;

import br.igornj.db.dao.UsersDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


@WebServlet("/delete")
public class DeleteServlet extends HttpServlet {
    @Override
    public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        UsersDAO dao = new UsersDAO();
        HttpSession session = req.getSession();
        int userId = (int) session.getAttribute("userId");

       try{
          dao.delete(userId);
          session.invalidate();
           RequestDispatcher dispatcher = req.getRequestDispatcher("login.jsp");
           dispatcher.forward(req, res);
           req.setAttribute("message", "User was successfully deleted");

       }catch(Exception e){
           throw new RuntimeException(e);
       }

    }
}
