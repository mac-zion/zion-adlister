package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "updateprofile",urlPatterns = "/updateprofile")
public class UpdateProfileServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        User user = (User) req.getSession().getAttribute("user");
        req.setAttribute("user",user);
        req.getRequestDispatcher("/WEB-INF/updateprofile.jsp").forward(req,resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {



//        Long id = Long.parseUnsignedLong(req.getParameter("id"));

        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String email = req.getParameter("email");

        User user = new User(1,username,email,password);

        DaoFactory.getUsersDao().updateprofile(user);
        resp.sendRedirect("/logout");





        // validate input

//        boolean inputHasErrors = username.isEmpty()
//                || email.isEmpty()
//                || password.isEmpty();
//
//        if (!inputHasErrors){
//            resp.sendRedirect("/updateprofile");
//            DaoFactory.getUsersDao().updateprofile(user);
//
//        }

//


    }
}