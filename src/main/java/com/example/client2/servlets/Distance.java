package com.example.client2.servlets;

import com.example.client2.beans.Ville;
import com.example.client2.forms.VilleMethods;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "Distance", value = "/distance")
public class Distance extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Ville> allVilles = VilleMethods.getAllVilles();
        request.setAttribute("allVilles", allVilles);
        List<String> allNameVille = VilleMethods.getAllNameVille();
        request.setAttribute("nameVille", allNameVille);

        ///Exemple de nom de ville AMBUTRIX, AMBLEON
        String nomV1;
        if(request.getParameter("v1")==null){
            nomV1 = "AMBUTRIX";
        }else{
            nomV1 = request.getParameter("v1");
        }
        String nomV2;
        if(request.getParameter("v2")==null){
            nomV2 = "AMBUTRIX";
        }else{
            nomV2 = request.getParameter("v2");
        }
        Ville v1 = VilleMethods.getVilleFromName(nomV1);
        Ville v2 = VilleMethods.getVilleFromName(nomV2);
        String distance = VilleMethods.distance(v1.getLatitude(), v1.getLongitude(), v2.getLatitude(), v2.getLongitude());

        request.setAttribute("distance", distance);
        request.setAttribute("v1", v1);
        request.setAttribute("v2", v2);
        System.out.println(allNameVille);
        this.getServletContext().getRequestDispatcher("/distance.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.getServletContext().getRequestDispatcher("/distance.jsp").forward(request, response);
    }


}

