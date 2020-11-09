package controllers;

import helpers.JsonParser;
import models.Review;
import repositories.ReviewsRepository;
import repositories.ReviewsRepositoryImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet("/search")
public class SearchServlet extends HttpServlet {
    public static HashMap<String, String> a = new HashMap<String, String>();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String a = "STRING";
        req.setAttribute("test", a);
        req.setAttribute("email", req.getSession().getAttribute("email"));
        getServletContext().getRequestDispatcher("/views/search.jsp").forward(req, resp);
    }
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String movie = req.getParameter("s");
        ArrayList<String> params = new ArrayList();
        params.add("titleId");
        params.add("year");
        params.add("released");
        params.add("runtime");
        params.add("genre");
        params.add("director");
        params.add("writer");
        params.add("actors");
        params.add("plot");
        req.getSession().setAttribute("params", params);
        System.out.println(movie);
        JsonParser parser = new JsonParser();
        Map<String, String> q = parser.query(movie);
        req.getSession().setAttribute("movieInfo", q);
        resp.sendRedirect(getServletContext().getContextPath()+"/movieInfo");
        ReviewsRepositoryImpl reviewsRepository = new ReviewsRepositoryImpl();
        List<Review> reviewPool = reviewsRepository.findAllByTitle(movie);
        req.getSession().setAttribute("reviewPool", reviewPool);

    }
}
