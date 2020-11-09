package filters;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EdgeKicker extends HttpFilter {
    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
        String browser = req.getHeader("user-agent");
        PrintWriter out = res.getWriter();
        out.println("<br/><h2>Let's have a browser test today : "
                + "<br> The Web-Browser you are using today is : ");
        out.println("<br/></hr>");
        if(browser.contains("Chrome"))
            out.println("<h2>You are using Mozilla Firefox</h2>");
        chain.doFilter(req, res);
    }
}

