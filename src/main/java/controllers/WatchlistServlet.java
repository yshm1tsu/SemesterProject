package controllers;

import helpers.WatchlistHelper;
import models.Watchlist;
import repositories.WatchlistRepositoryImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;
import java.util.List;

@WebServlet("/watchlist")
public class WatchlistServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        WatchlistRepositoryImpl watchlistRepository = new WatchlistRepositoryImpl();
        List<Watchlist> rep = watchlistRepository.findAllByUser((String) req.getSession().getAttribute("email"));
        req.setAttribute("rep", rep);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/views/watchlist.jsp");
        dispatcher.forward(req, resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        WatchlistHelper watchlistHelper = new WatchlistHelper();
        String title = req.getParameter("title");
        String rating  = req.getParameter("rating");
        String date = req.getParameter("add_date");
        String status = req.getParameter("status");
        String email = (String) req.getSession().getAttribute("email");
        try {
            watchlistHelper.createItem(title, date, email, status, rating);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
