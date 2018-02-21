package controller;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import domain.House;
import domain.KhaneBeDoosh;
import domain.User;
import javax.servlet.http.HttpServlet;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;


@WebServlet("/csearch")

public class SearchController extends HttpServlet{
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        try {

            String minArea = req.getParameter("minArea");;
            String buildingType= req.getParameter("buildingType");;
            String dealType = req.getParameter("dealType");
            String maxPrice = req.getParameter("maxPrice");
            ArrayList<House> foundHouses = KhaneBeDoosh.searchHouse(minArea, buildingType, dealType, maxPrice);
            req.setAttribute("houseList",foundHouses);

        } catch (IllegalArgumentException ex) {

        }
        req.getRequestDispatcher("SearchResults.jsp").forward(req, resp);
    }



}
