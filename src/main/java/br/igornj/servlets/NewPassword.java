package br.igornj.servlets;

import br.igornj.db.dao.UsersDAO;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/newPassword")
public class NewPassword extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		HttpSession session = req.getSession();
		String newPassword = req.getParameter("password");
		String confPassword = req.getParameter("confPassword");
		String email = (String) session.getAttribute("email");

		RequestDispatcher dispatcher;
		UsersDAO dao = new UsersDAO();

		if (newPassword != null && confPassword != null && newPassword.equals(confPassword)) {
			try{
				int result = dao.newPassword(email, newPassword);
				if(result > 0){
					req.setAttribute("message", "Your password was changed!");
					dispatcher = req.getRequestDispatcher("login.jsp");
					dispatcher.forward(req, res);
				} else {
					req.setAttribute("message", "Some error occurred when trying to reset your password");
					dispatcher = req.getRequestDispatcher("newPassword.jsp");
					dispatcher.forward(req, res);
				}
			}catch(Exception e){
				throw new RuntimeException();
			}
		}
	}

}


