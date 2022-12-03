package com.example.client2.servlets;

import com.example.client2.beans.Ville;
import com.example.client2.forms.VilleMethods;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;



@WebServlet(name = "Villes", value = "/villes")
public class Villes extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int page;
        if (request.getParameter("page")==null){page = 1;}
        else{page= Integer.parseInt(request.getParameter("page"));}
        if (Integer.parseInt(request.getParameter("page")) > 0
                && Integer.parseInt(request.getParameter("page")) < 68) {
            page = Integer.parseInt(request.getParameter("page"));
        }
        request.setAttribute("page", page);
        request.setAttribute("listVilles", VilleMethods.getVillesPage(page));
        this.getServletContext().getRequestDispatcher("/villes.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        this.getServletContext().getRequestDispatcher("/villes.jsp").forward(request, response);
    }
}