package controller;

import domain.KhaneBeDoosh;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/cgetOwnerPhone")
public class GetOwnerPhoneNum extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String houseId="";
        try {
            houseId = req.getParameter("id");
            String phoneNum = KhaneBeDoosh.getPhoneNumber(houseId);
            req.setAttribute("phoneNum", phoneNum);
        } catch (IllegalArgumentException ex) {
            req.setAttribute("msg", ex.getMessage());
        }
        req.setAttribute("house",KhaneBeDoosh.findHouse(houseId));
        req.getRequestDispatcher("MoreInfo.jsp").forward(req, resp);
    }
}
