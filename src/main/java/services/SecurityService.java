package services;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.sql.*;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;

public class SecurityService {

    private static final String EMAIL = "abc@abc.com";
    private static final String PASSWORD = "123";
    static String dbName = "jdbc:postgresql://localhost:5432/auth";
    static String dbDriver = "org.postgresql.Driver";
    static String userName = "postgres";
    static String password = "hutrdew4921";
    static Statement stmt = null;
    static String emailFromDB = null;
    static byte[] passwordFromDB = null;
    public static Map<String, Object> getUser(HttpServletRequest req) {
        if(isSigned(req)){
            Map<String, Object> user = new HashMap<>();
            user.put("email", req.getSession().getAttribute("email"));
            return user;
        }
        return null;
    }

    public static boolean isSigned(HttpServletRequest req) {
        return req.getSession().getAttribute("email") != null;
    }

    public static boolean signIn(HttpServletRequest req, String email, String password) {
        if (req.equals(req.getParameter("email"))) {
            req.getSession().setAttribute("email", email);
            return true;
        }
        return false;
    }

    public static void signOut(HttpServletRequest req) {
        req.getSession().removeAttribute("email");
    }
}