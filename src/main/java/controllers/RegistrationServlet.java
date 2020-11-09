package controllers;

import helpers.EmailExistingHelper;
import helpers.RegistrationHelperImpl;
import models.User;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;

@WebServlet("/register")
public class RegistrationServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("/views/register.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String pass = req.getParameter("psw");
        String passRep = req.getParameter("psw-repeat");
        String email = req.getParameter("email");
        User user = new User();
        user.setEmail(email);
        user.setPassword(pass);
        EmailExistingHelper existingHelper = new EmailExistingHelper();
        boolean exisits = existingHelper.isExisting(email);
        RegistrationHelperImpl registrationHelper = new RegistrationHelperImpl();
        if (!exisits) {
            try {
                registrationHelper.register(user);
                req.getSession().setAttribute("email", email);
                resp.sendRedirect("profile");
            } catch (SQLException | ClassNotFoundException throwables) {
                throwables.printStackTrace();
            }
        } else{
            resp.sendRedirect("register");
        }
    }
}