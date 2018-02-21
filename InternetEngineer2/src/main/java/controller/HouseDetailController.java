package controller;

import domain.House;
import domain.KhaneBeDoosh;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/cmoreInfo")
public class HouseDetailController extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String houseId = req.getParameter("id");
        String sessionUserName=req.getParameter("sessionUserName");
        String balance=req.getParameter("balance");
        House h = KhaneBeDoosh.findHouse(houseId);
        if (h == null) {
            req.setAttribute("msg", "خانه ای با این مشخصات وجود ندارد");
        } else {
            req.setAttribute("house", h);

        }
        req.setAttribute("sessionUserName",sessionUserName);
        req.setAttribute("balance",balance);
        req.getRequestDispatcher("MoreInfo.jsp").forward(req, resp);
    }
}
