<%@ page import="com.example.client2.beans.Ville" %>
<%@ page import="java.util.List" %>

<html>
<head>
    <title>Affichage des villes</title>
</head>
<body>
<body style="text-align: center; padding: 0 15vw;">
<h1>Liste des villes de France</h1>
<a href="distance"><h5>Calculer la distance entre 2 villes</h5></a>
<div>
    <h4>Page ${page} sur 67</h4>
    <a href="villes?page=${page - 1}"><h4>Page precedante</h4></a>
    <a href="villes?page=${page + 1}"><h4>Page suivante</h4></a>
</div>
<table id="table" style="border: 1px solid black;border: medium solid #6495ed;">
    <tr style="border: thin solid #6495ed;">
        <th>Code INSEE</th>
        <th>Nom commune</th>
        <th>Code postal</th>
        <th>Libelle acheminement</th>
        <th>Ligne 5</th>
        <th>Latitude</th>
        <th>Longitude</th>
    </tr>
    <% List<Ville> allVilles = (List<Ville>) request.getAttribute("listVilles");
        int i;
        for (i = 0; i < allVilles.size() - 1; i++) {
            ;
    %>
    <tr style="border: thin solid #6495ed;">
        <td><%=allVilles.get(i).getCodeCommuneInsee()%></td>
        <td><a href="villeDescription?codeCommuneInsee=<%=allVilles.get(i).getCodeCommuneInsee()%>"><%=allVilles.get(i).getNomCommune()%></a></td>
        <td><%=allVilles.get(i).getCodePostal()%></td>
        <td><%=allVilles.get(i).getLibelleAcheminement()%></td>
        <td><%=allVilles.get(i).getLigne5()%></td>
        <td><%=allVilles.get(i).getLatitude()%></td>
        <td><%=allVilles.get(i).getLongitude()%></td>
        <% } %>
    </tr>
</table>
</body>
</body>
</html>
