package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.Ad;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "update ads",urlPatterns = "/updateads")
public class UpdateAdServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
         Ad ad = (Ad) req.getSession().getAttribute("ad");
        req.setAttribute("ad",ad);
        req.getRequestDispatcher("/WEB-INF/updateadds.jsp").forward(req,resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String title = req.getParameter("title");
        String description = req.getParameter("description");
        int id = Integer.parseInt(req.getParameter("user_id"));


        Ad ad = new Ad(id,title,description);

        DaoFactory.getAdsDao().updateprofile(ad);
        resp.sendRedirect("/ads");
    }
}
