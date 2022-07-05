package br.igornj.servlets;

import br.igornj.db.dao.UsersDAO;
import br.igornj.db.model.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Optional;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

        HttpSession session = req.getSession();
        UsersDAO dao = new UsersDAO();
        RequestDispatcher dispatcher;

        String username = req.getParameter("username");
        String password = req.getParameter("password");

        if(username.equals("") || password.equals("")){
            req.setAttribute("message", "the input username/password can not be empty");
            dispatcher = req.getRequestDispatcher("login.jsp");
            dispatcher.forward(req, res);
        }

        try{
            Optional<User> userFound = dao.loginUser(username, password);
            if(userFound.isPresent()){
                session.setAttribute("username", userFound.get().getUsername());
                session.setAttribute("userId", userFound.get().getId());
                dispatcher = req.getRequestDispatcher("/WEB-INF/index.jsp");
                dispatcher.forward(req, res);
            } else {
                req.setAttribute("message", "Some error occurred when trying to login");
                dispatcher = req.getRequestDispatcher("login.jsp");
                dispatcher.forward(req, res);
            }

        }catch (Exception e){
            req.setAttribute("message", "Some error occurred when trying to login");
            dispatcher = req.getRequestDispatcher("login.jsp");
            dispatcher.forward(req, res);
        }

    }
}
