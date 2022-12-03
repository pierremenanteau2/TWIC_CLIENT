package com.example.client2.servlets;

import com.example.client2.beans.Ville;
import com.example.client2.forms.VilleMethods;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "VilleDescription", value = "/villeDescription")
public class VilleDescription extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Ville ville = this.getVille(request.getParameter("codeCommuneInsee"));
        request.setAttribute("ville", ville);
        this.getServletContext().getRequestDispatcher("/villeDescription.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Ville ville = this.getVille(request.getParameter("codeCommuneInsee"));
        ville.setNomCommune(request.getParameter("newNomCommune"));
        ville.setCodePostal(Integer.parseInt(request.getParameter("newCodePostal")));
        ville.setLibelleAcheminement(request.getParameter("newLibelle"));
        ville.setLatitude(Float.parseFloat(request.getParameter("newLatitude")));
        ville.setLongitude(Float.parseFloat(request.getParameter("newLongitude")));
        request.setAttribute("ville", ville);
        this.getServletContext().getRequestDispatcher("/villeDetails.jsp").forward(request, response);
    }

    private Ville getVille(String codeCommuneInsee) {
        return VilleMethods.getVilleFromCode(codeCommuneInsee);
    }

}



