package br.igornj.servlets;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/validateResetCode")
public class ValidateResetCodeServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
    {
        int value = Integer.parseInt(req.getParameter("resetCode"));
        HttpSession session = req.getSession();
        int resetCode = (int) session.getAttribute("resetCode");

        RequestDispatcher dispatcher;


        if (value == resetCode)
        {

            req.setAttribute("email", req.getParameter("email"));
            dispatcher = req.getRequestDispatcher("newPassword.jsp");
            dispatcher.forward(req, res);

        }
        else
        {
            req.setAttribute("message","wrong code");

            dispatcher = req.getRequestDispatcher("enterResetCode.jsp");
            dispatcher.forward(req, res);

        }

    }
}
