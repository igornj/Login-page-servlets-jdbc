package br.igornj.servlets;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;

@WebServlet("/forgotPassword")
public class ForgotPasswordServlet extends HttpServlet {
    @Override
    public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

        String email = req.getParameter("email");
        RequestDispatcher dispatcher;
        int resetCode;
        HttpSession mySession = req.getSession();


        if(!email.equals("") || !(email == null)){
            Random rand = new Random();
            resetCode = rand.nextInt(514894);
            String to = email;
            String from = "";

            Properties properties = new Properties();
            properties.setProperty("mail.smtp.host", "smtp.gmail.com");
            properties.setProperty("mail.smtp.socketFactory.port", "465");
            properties.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
            properties.setProperty("mail.smtp.port", "465");
            properties.setProperty("mail.smtp.auth", "true");
            Session session = Session.getDefaultInstance(properties, new Authenticator() {
                @Override
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(from, "");
                }
            });

            try {
                MimeMessage message = new MimeMessage(session);
                message.setFrom(new InternetAddress(from));
                message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
                message.setSubject("Your CODE to reset your password to MARS!");
                message.setText("your code is: " + resetCode);
                Transport.send(message);
                System.out.println("message sent successfully");
            }

            catch (MessagingException e) {
                throw new RuntimeException(e);
            }
            dispatcher = req.getRequestDispatcher("enterResetCode.jsp");
            req.setAttribute("message","Code was sent to your email");
            mySession.setAttribute("resetCode",resetCode);
            mySession.setAttribute("email", email);
            dispatcher.forward(req, res);
        }

    }
}
