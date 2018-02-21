package controller;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import domain.House;
import domain.House2;
import domain.KhaneBeDoosh;

import javax.json.*;
import javax.servlet.http.HttpServlet;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;


@WebServlet("/cadd")
public class AddHouseController extends HttpServlet{
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        try {

            String area = req.getParameter("area");
            String buildingType = req.getParameter("buildingType");
            String address = req.getParameter("address");
            String dealType = req.getParameter("dealType");
            String price = req.getParameter("price");
            String phone = req.getParameter("phone");
            String description = req.getParameter("description");
            KhaneBeDoosh.createHouse(area, buildingType, address, dealType, price, phone, description);
            req.setAttribute("msg", "خانه با موفقیت ثبت شد");
        } catch(IllegalArgumentException ex){
            req.setAttribute("msg",ex.getMessage());
        }
        req.getRequestDispatcher("index.jsp").forward(req, resp);
    }
}