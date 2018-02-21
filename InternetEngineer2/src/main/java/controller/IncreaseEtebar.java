package controller;

import javax.net.ssl.HttpsURLConnection;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import domain.KhaneBeDoosh;
@WebServlet("/cincrease")
public class IncreaseEtebar extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        try {
            String pay = req.getParameter("pay");
            if(KhaneBeDoosh.IncreaseEtebar(pay)){
                req.setAttribute("msg","اعتبار شما باموفقیت افزایش یافت");
            }else {
                req.setAttribute("msg","مشکل درافزایش اعتبار");
            }
        } catch (IllegalArgumentException ex) {
            req.setAttribute("msg", ex.getMessage());
        }
        req.getRequestDispatcher("index.jsp").forward(req, resp);
    }

}
