package br.igornj.servlets;

import br.igornj.db.dao.UsersDAO;
import br.igornj.db.model.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;
import java.util.Set;

@WebServlet("/update")
public class UpdateServlet extends HttpServlet {
    public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

//        Set<String> paramNames = req.getParameterMap().keySet();
//        String value = null;
//        // iterating over parameter names and get its value
//        for (String name : paramNames) {
//            value = req.getParameter(name);
//        }

        UsersDAO dao = new UsersDAO();

        int userId = Integer.parseInt(req.getParameter("userId"));
        String username = req.getParameter("username");
        String email = req.getParameter("email");
        String password = req.getParameter("password");


        User user = new User(username, email, password);
        dao.update(userId, user);

        req.setAttribute("message", "The user was updated!");
        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/index.jsp");
        dispatcher.forward(req, res);

    }
}
