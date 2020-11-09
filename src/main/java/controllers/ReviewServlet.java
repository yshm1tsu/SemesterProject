package controllers;

import models.Review;
import helpers.ReviewHelper;
import helpers.ReviewHelperImpl;
import models.Watchlist;
import repositories.ReviewsRepositoryImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/review")
public class ReviewServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ReviewsRepositoryImpl reviewsRepository = new ReviewsRepositoryImpl();
        List<Review> reviewRep = reviewsRepository.findAllByUser((String) req.getSession().getAttribute("email"));
        req.setAttribute("reviewRep", reviewRep);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/views/review.jsp");
        dispatcher.forward(req, resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       ReviewHelper reviewHelper = new ReviewHelperImpl();
       Review review = new Review();
       String title = req.getParameter("title");
       String comment = req.getParameter("comment");
       String email = (String) req.getSession().getAttribute("email");
       review.setContent(comment);
       review.setTitle(title);
       review.setUser_email(email);
       reviewHelper.createItem(review);
    }
}
